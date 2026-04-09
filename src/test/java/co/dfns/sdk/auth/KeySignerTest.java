package co.dfns.sdk.auth;

import co.dfns.sdk.auth.KeySigner;
import co.dfns.sdk.auth.Signer;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;
import org.junit.jupiter.api.Test;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for {@link KeySigner} verifying Ed25519 and secp256k1 signing
 * produce valid credential assertions with correct structure and deterministic output.
 */
class KeySignerTest {

    private static final UserActionChallenge TEST_CHALLENGE = new UserActionChallenge(
        "test-challenge-123", "ch-test-id", "", java.util.Map.of());

    @Test
    void testEd25519Signing() throws Exception {
        byte[] seed = new byte[32]; // all zeros — valid Ed25519 seed for testing
        Signer signer = KeySigner.fromEd25519PrivateKey("cr-test-ed25519", seed);

        CredentialAssertion assertion = signer.sign(TEST_CHALLENGE);

        // Verify structure
        assertEquals("Key", assertion.kind());
        assertEquals("cr-test-ed25519", assertion.credentialAssertion().credId());
        assertNotNull(assertion.credentialAssertion().clientData());
        assertFalse(assertion.credentialAssertion().clientData().isEmpty());
        assertNotNull(assertion.credentialAssertion().signature());
        assertFalse(assertion.credentialAssertion().signature().isEmpty());

        // Decode and verify clientData JSON
        byte[] clientDataBytes = Base64.getUrlDecoder().decode(assertion.credentialAssertion().clientData());
        String clientDataJson = new String(clientDataBytes, java.nio.charset.StandardCharsets.UTF_8);
        assertTrue(clientDataJson.contains("\"type\":\"key.get\""));
        assertTrue(clientDataJson.contains("\"challenge\":\"test-challenge-123\""));
        assertTrue(clientDataJson.contains("\"crossOrigin\":false"));

        // Ed25519 is deterministic — signing same input twice must produce identical output
        CredentialAssertion assertion2 = signer.sign(TEST_CHALLENGE);
        assertEquals(assertion.credentialAssertion().clientData(), assertion2.credentialAssertion().clientData());
        assertEquals(assertion.credentialAssertion().signature(), assertion2.credentialAssertion().signature());
    }

    @Test
    void testSecp256k1Signing() throws Exception {
        // Private key = 1 (valid for secp256k1)
        byte[] keyBytes = new byte[] {
            0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,1
        };
        Signer signer = KeySigner.fromSecp256k1PrivateKey("cr-test-secp256k1", keyBytes);

        CredentialAssertion assertion = signer.sign(TEST_CHALLENGE);

        // Verify structure
        assertEquals("Key", assertion.kind());
        assertEquals("cr-test-secp256k1", assertion.credentialAssertion().credId());
        assertNotNull(assertion.credentialAssertion().clientData());
        assertFalse(assertion.credentialAssertion().clientData().isEmpty());
        assertNotNull(assertion.credentialAssertion().signature());
        assertFalse(assertion.credentialAssertion().signature().isEmpty());

        // Decode and verify clientData JSON
        byte[] clientDataBytes = Base64.getUrlDecoder().decode(assertion.credentialAssertion().clientData());
        String clientDataJson = new String(clientDataBytes, java.nio.charset.StandardCharsets.UTF_8);
        assertTrue(clientDataJson.contains("\"type\":\"key.get\""));
        assertTrue(clientDataJson.contains("\"challenge\":\"test-challenge-123\""));
        assertTrue(clientDataJson.contains("\"crossOrigin\":false"));

        // Decode signature and verify DER structure
        byte[] sigBytes = Base64.getUrlDecoder().decode(assertion.credentialAssertion().signature());
        assertEquals(0x30, sigBytes[0] & 0xFF, "DER signature must start with SEQUENCE tag 0x30");
        int seqLen = sigBytes[1] & 0xFF;
        assertEquals(sigBytes.length - 2, seqLen, "DER SEQUENCE length must match remaining bytes");

        // First INTEGER component (r)
        assertEquals(0x02, sigBytes[2] & 0xFF, "First component must be INTEGER tag 0x02");
        int rLen = sigBytes[3] & 0xFF;

        // Second INTEGER component (s)
        int sOffset = 4 + rLen;
        assertEquals(0x02, sigBytes[sOffset] & 0xFF, "Second component must be INTEGER tag 0x02");
    }
}
