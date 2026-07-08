package co.dfns.sdk.keys;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.keys.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.Map;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedKeysClient {
    private final DfnsHttpClient httpClient;

    public DelegatedKeysClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Keys */
    public PaginatedList<Key> listKeys(ListKeysQuery query) {
        return httpClient.get("/keys", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Key>>() {});
    }

    /** Delegated signing step 1 for Create Key: returns the challenge to sign out-of-band. */
    public UserActionChallenge createKeyInit(CreateKeyRequest body) {
        return httpClient.createUserActionChallenge("POST", "/keys", body);
    }

    /** Delegated signing step 2 for Create Key: submits the signed challenge and issues the request. */
    public Key createKeyComplete(CreateKeyRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/keys", java.util.Map.of(), body, Key.class, userAction);
    }

    /** Delegated signing step 1 for Delegate Key: returns the challenge to sign out-of-band. */
    public UserActionChallenge delegateKeyInit(String keyId, DelegateKeyRequest body) {
        return httpClient.createUserActionChallenge("POST", "/keys/" + keyId + "/delegate", body);
    }

    /** Delegated signing step 2 for Delegate Key: submits the signed challenge and issues the request. */
    public DelegateKeyResponse delegateKeyComplete(String keyId, DelegateKeyRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/keys/" + keyId + "/delegate", java.util.Map.of(), body, DelegateKeyResponse.class, userAction);
    }

    /** Get Key */
    public Key getKey(String keyId) {
        return httpClient.get("/keys/" + keyId, java.util.Map.of(), Key.class);
    }

    /** Delegated signing step 1 for Update Key: returns the challenge to sign out-of-band. */
    public UserActionChallenge updateKeyInit(String keyId, UpdateKeyRequest body) {
        return httpClient.createUserActionChallenge("PUT", "/keys/" + keyId, body);
    }

    /** Delegated signing step 2 for Update Key: submits the signed challenge and issues the request. */
    public Key updateKeyComplete(String keyId, UpdateKeyRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/keys/" + keyId, java.util.Map.of(), body, Key.class, userAction);
    }

    /** Delegated signing step 1 for Delete Key: returns the challenge to sign out-of-band. */
    public UserActionChallenge deleteKeyInit(String keyId) {
        return httpClient.createUserActionChallenge("DELETE", "/keys/" + keyId, null);
    }

    /** Delegated signing step 2 for Delete Key: submits the signed challenge and issues the request. */
    public Key deleteKeyComplete(String keyId, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("DELETE", "/keys/" + keyId, java.util.Map.of(), null, Key.class, userAction);
    }

    /** Delegated signing step 1 for Derive Key: returns the challenge to sign out-of-band. */
    public UserActionChallenge deriveKeyInit(String keyId, DeriveKeyRequest body) {
        return httpClient.createUserActionChallenge("POST", "/keys/" + keyId + "/derive", body);
    }

    /** Delegated signing step 2 for Derive Key: submits the signed challenge and issues the request. */
    public DeriveKeyResponse deriveKeyComplete(String keyId, DeriveKeyRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/keys/" + keyId + "/derive", java.util.Map.of(), body, DeriveKeyResponse.class, userAction);
    }

    /** Delegated signing step 1 for Export Key: returns the challenge to sign out-of-band. */
    public UserActionChallenge exportKeyInit(String keyId, ExportKeyRequest body) {
        return httpClient.createUserActionChallenge("POST", "/keys/" + keyId + "/export", body);
    }

    /** Delegated signing step 2 for Export Key: submits the signed challenge and issues the request. */
    public ExportKeyResponse exportKeyComplete(String keyId, ExportKeyRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/keys/" + keyId + "/export", java.util.Map.of(), body, ExportKeyResponse.class, userAction);
    }

    /** List Signatures */
    public ListSignaturesResponse listSignatures(String keyId, ListSignaturesQuery query) {
        return httpClient.get("/keys/" + keyId + "/signatures", query.toMap(), ListSignaturesResponse.class);
    }

    /** Delegated signing step 1 for Generate Signature: returns the challenge to sign out-of-band. */
    public UserActionChallenge generateSignatureInit(String keyId, Object body) {
        return httpClient.createUserActionChallenge("POST", "/keys/" + keyId + "/signatures", body);
    }

    /** Delegated signing step 2 for Generate Signature: submits the signed challenge and issues the request. */
    public SignatureRequest generateSignatureComplete(String keyId, Object body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/keys/" + keyId + "/signatures", java.util.Map.of(), body, SignatureRequest.class, userAction);
    }

    /** Get Signature */
    public SignatureRequest getSignature(String keyId, String signatureId) {
        return httpClient.get("/keys/" + keyId + "/signatures/" + signatureId, java.util.Map.of(), SignatureRequest.class);
    }

    /** Delegated signing step 1 for Import Key: returns the challenge to sign out-of-band. */
    public UserActionChallenge importKeyInit(ImportKeyRequest body) {
        return httpClient.createUserActionChallenge("POST", "/keys/import", body);
    }

    /** Delegated signing step 2 for Import Key: submits the signed challenge and issues the request. */
    public Key importKeyComplete(ImportKeyRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/keys/import", java.util.Map.of(), body, Key.class, userAction);
    }
}
