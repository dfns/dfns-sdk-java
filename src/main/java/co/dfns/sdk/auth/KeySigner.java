package co.dfns.sdk.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.signers.ECDSASigner;
import org.bouncycastle.asn1.sec.SECNamedCurves;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.*;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Signer implementation supporting Ed25519, ECDSA P-256, secp256k1, and RSA.
 * Each factory method requires a {@code credentialId} that identifies the
 * credential registered with Dfns.
 *
 * <pre>
 *   Signer signer = KeySigner.fromEd25519PrivateKey("cr-xxx-xxx", privateKeyBytes);
 *   Signer signer = KeySigner.fromEcdsaP256PrivateKey("cr-xxx-xxx", privateKeyBytes);
 *   Signer signer = KeySigner.fromSecp256k1PrivateKey("cr-xxx-xxx", privateKeyBytes);
 *   Signer signer = KeySigner.fromRsaPrivateKey("cr-xxx-xxx", privateKeyBytes);
 * </pre>
 */
public class KeySigner {

    static {
        if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) == null) {
            Security.addProvider(new BouncyCastleProvider());
        }
    }

    private KeySigner() {}

    /** Sign with Ed25519 private key (raw 32-byte seed). */
    public static Signer fromEd25519PrivateKey(String credentialId, byte[] privateKeyBytes) {
        return challenge -> {
            KeyFactory kf = KeyFactory.getInstance("Ed25519");
            PrivateKey privateKey = kf.generatePrivate(new PKCS8EncodedKeySpec(toEd25519Pkcs8(privateKeyBytes)));
            Signature signer = Signature.getInstance("Ed25519");
            signer.initSign(privateKey);
            byte[] clientDataBytes = buildClientData(challenge);
            signer.update(clientDataBytes);
            return buildAssertion(credentialId, clientDataBytes, signer.sign());
        };
    }

    /** Sign with ECDSA P-256 private key (PKCS#8 DER encoded). */
    public static Signer fromEcdsaP256PrivateKey(String credentialId, byte[] privateKeyBytes) {
        return challenge -> {
            KeyFactory kf = KeyFactory.getInstance("EC");
            PrivateKey privateKey = kf.generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));
            Signature signer = Signature.getInstance("SHA256withECDSA");
            signer.initSign(privateKey);
            byte[] clientDataBytes = buildClientData(challenge);
            signer.update(clientDataBytes);
            return buildAssertion(credentialId, clientDataBytes, signer.sign());
        };
    }

    /** Sign with secp256k1 private key (raw 32-byte big-endian scalar) via Bouncy Castle. */
    public static Signer fromSecp256k1PrivateKey(String credentialId, byte[] privateKeyBytes) {
        return challenge -> {
            X9ECParameters params = SECNamedCurves.getByName("secp256k1");
            ECDomainParameters domainParams = new ECDomainParameters(
                params.getCurve(), params.getG(), params.getN(), params.getH());
            ECPrivateKeyParameters privKey = new ECPrivateKeyParameters(
                new BigInteger(1, privateKeyBytes), domainParams);
            ECDSASigner ecdsaSigner = new ECDSASigner();
            ecdsaSigner.init(true, privKey);
            byte[] clientDataBytes = buildClientData(challenge);
            byte[] hash = sha256(clientDataBytes);
            BigInteger[] sig = ecdsaSigner.generateSignature(hash);
            byte[] rBytes = sig[0].toByteArray();
            byte[] sBytes = sig[1].toByteArray();
            byte[] der = derEncode(rBytes, sBytes);
            return buildAssertion(credentialId, clientDataBytes, der);
        };
    }

    /** Sign with RSA private key (PKCS#8 DER encoded). */
    public static Signer fromRsaPrivateKey(String credentialId, byte[] privateKeyBytes) {
        return challenge -> {
            KeyFactory kf = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = kf.generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));
            Signature signer = Signature.getInstance("SHA256withRSA");
            signer.initSign(privateKey);
            byte[] clientDataBytes = buildClientData(challenge);
            signer.update(clientDataBytes);
            return buildAssertion(credentialId, clientDataBytes, signer.sign());
        };
    }

    private static byte[] buildClientData(UserActionChallenge challenge) throws Exception {
        Map<String, Object> clientData = new LinkedHashMap<>();
        clientData.put("type", "key.get");
        clientData.put("challenge", challenge.challenge());
        clientData.put("crossOrigin", false);
        return new ObjectMapper().writeValueAsBytes(clientData);
    }

    private static CredentialAssertion buildAssertion(String credentialId, byte[] clientDataBytes, byte[] signature) {
        Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
        return new CredentialAssertion("Key",
            new CredentialAssertion.CredentialAssertionData(
                credentialId,
                encoder.encodeToString(clientDataBytes),
                encoder.encodeToString(signature)));
    }

    private static byte[] sha256(byte[] data) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA-256").digest(data);
    }

    private static byte[] toEd25519Pkcs8(byte[] rawSeed) {
        // Wrap raw 32-byte seed in minimal PKCS#8 structure for Ed25519 OID 1.3.101.112
        byte[] prefix = { 0x30, 0x2e, 0x02, 0x01, 0x00, 0x30, 0x05, 0x06, 0x03, 0x2b, 0x65, 0x70,
                           0x04, 0x22, 0x04, 0x20 };
        byte[] pkcs8 = new byte[prefix.length + rawSeed.length];
        System.arraycopy(prefix, 0, pkcs8, 0, prefix.length);
        System.arraycopy(rawSeed, 0, pkcs8, prefix.length, rawSeed.length);
        return pkcs8;
    }

    private static byte[] derEncode(byte[] r, byte[] s) {
        byte[] seq = new byte[6 + r.length + s.length];
        seq[0] = 0x30;
        seq[1] = (byte) (4 + r.length + s.length);
        seq[2] = 0x02;
        seq[3] = (byte) r.length;
        System.arraycopy(r, 0, seq, 4, r.length);
        seq[4 + r.length] = 0x02;
        seq[5 + r.length] = (byte) s.length;
        System.arraycopy(s, 0, seq, 6 + r.length, s.length);
        return seq;
    }
}
