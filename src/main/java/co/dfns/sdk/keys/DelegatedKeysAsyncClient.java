package co.dfns.sdk.keys;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.keys.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedKeysAsyncClient {
    private final DfnsHttpClient httpClient;

    public DelegatedKeysAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Keys */
    public CompletableFuture<PaginatedList<Key>> listKeys(ListKeysQuery query) {
        return httpClient.getAsync("/keys", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Key>>() {});
    }

    /** Delegated signing step 1 for Create Key: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createKeyInit(CreateKeyRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/keys", body);
    }

    /** Delegated signing step 2 for Create Key: submits the signed challenge and issues the request. */
    public CompletableFuture<Key> createKeyComplete(CreateKeyRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/keys", java.util.Map.of(), body, Key.class, userAction));
    }

    /** Delegated signing step 1 for Delegate Key: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> delegateKeyInit(String keyId, DelegateKeyRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/keys/" + keyId + "/delegate", body);
    }

    /** Delegated signing step 2 for Delegate Key: submits the signed challenge and issues the request. */
    public CompletableFuture<DelegateKeyResponse> delegateKeyComplete(String keyId, DelegateKeyRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/keys/" + keyId + "/delegate", java.util.Map.of(), body, DelegateKeyResponse.class, userAction));
    }

    /** Get Key */
    public CompletableFuture<Key> getKey(String keyId) {
        return httpClient.getAsync("/keys/" + keyId, java.util.Map.of(), Key.class);
    }

    /** Delegated signing step 1 for Update Key: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> updateKeyInit(String keyId, UpdateKeyRequest body) {
        return httpClient.createUserActionChallengeAsync("PUT", "/keys/" + keyId, body);
    }

    /** Delegated signing step 2 for Update Key: submits the signed challenge and issues the request. */
    public CompletableFuture<Key> updateKeyComplete(String keyId, UpdateKeyRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("PUT", "/keys/" + keyId, java.util.Map.of(), body, Key.class, userAction));
    }

    /** Delegated signing step 1 for Delete Key: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> deleteKeyInit(String keyId) {
        return httpClient.createUserActionChallengeAsync("DELETE", "/keys/" + keyId, null);
    }

    /** Delegated signing step 2 for Delete Key: submits the signed challenge and issues the request. */
    public CompletableFuture<Key> deleteKeyComplete(String keyId, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("DELETE", "/keys/" + keyId, java.util.Map.of(), null, Key.class, userAction));
    }

    /** Delegated signing step 1 for Derive Key: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> deriveKeyInit(String keyId, DeriveKeyRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/keys/" + keyId + "/derive", body);
    }

    /** Delegated signing step 2 for Derive Key: submits the signed challenge and issues the request. */
    public CompletableFuture<DeriveKeyResponse> deriveKeyComplete(String keyId, DeriveKeyRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/keys/" + keyId + "/derive", java.util.Map.of(), body, DeriveKeyResponse.class, userAction));
    }

    /** Delegated signing step 1 for Export Key: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> exportKeyInit(String keyId, ExportKeyRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/keys/" + keyId + "/export", body);
    }

    /** Delegated signing step 2 for Export Key: submits the signed challenge and issues the request. */
    public CompletableFuture<ExportKeyResponse> exportKeyComplete(String keyId, ExportKeyRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/keys/" + keyId + "/export", java.util.Map.of(), body, ExportKeyResponse.class, userAction));
    }

    /** List Signatures */
    public CompletableFuture<ListSignaturesResponse> listSignatures(String keyId, ListSignaturesQuery query) {
        return httpClient.getAsync("/keys/" + keyId + "/signatures", query.toMap(), ListSignaturesResponse.class);
    }

    /** Delegated signing step 1 for Generate Signature: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> generateSignatureInit(String keyId, Object body) {
        return httpClient.createUserActionChallengeAsync("POST", "/keys/" + keyId + "/signatures", body);
    }

    /** Delegated signing step 2 for Generate Signature: submits the signed challenge and issues the request. */
    public CompletableFuture<SignatureRequest> generateSignatureComplete(String keyId, Object body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/keys/" + keyId + "/signatures", java.util.Map.of(), body, SignatureRequest.class, userAction));
    }

    /** Get Signature */
    public CompletableFuture<SignatureRequest> getSignature(String keyId, String signatureId) {
        return httpClient.getAsync("/keys/" + keyId + "/signatures/" + signatureId, java.util.Map.of(), SignatureRequest.class);
    }

    /** Delegated signing step 1 for Import Key: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> importKeyInit(ImportKeyRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/keys/import", body);
    }

    /** Delegated signing step 2 for Import Key: submits the signed challenge and issues the request. */
    public CompletableFuture<Key> importKeyComplete(ImportKeyRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/keys/import", java.util.Map.of(), body, Key.class, userAction));
    }
}
