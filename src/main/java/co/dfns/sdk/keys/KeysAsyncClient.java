package co.dfns.sdk.keys;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.keys.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class KeysAsyncClient {
    private final DfnsHttpClient httpClient;

    public KeysAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Keys */
    public CompletableFuture<PaginatedList<Key>> listKeys(ListKeysQuery query) {
        return httpClient.getAsync("/keys", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Key>>() {});
    }

    /** Create Key */
    public CompletableFuture<Key> createKey(CreateKeyRequest body) {
        return httpClient.postAsync("/keys", java.util.Map.of(), body, Key.class, true);
    }

    /** Delegate Key */
    public CompletableFuture<DelegateKeyResponse> delegateKey(String keyId, DelegateKeyRequest body) {
        return httpClient.postAsync("/keys/" + keyId + "/delegate", java.util.Map.of(), body, DelegateKeyResponse.class, true);
    }

    /** Get Key */
    public CompletableFuture<Key> getKey(String keyId) {
        return httpClient.getAsync("/keys/" + keyId, java.util.Map.of(), Key.class);
    }

    /** Update Key */
    public CompletableFuture<Key> updateKey(String keyId, UpdateKeyRequest body) {
        return httpClient.putAsync("/keys/" + keyId, java.util.Map.of(), body, Key.class, true);
    }

    /** Delete Key */
    public CompletableFuture<Key> deleteKey(String keyId) {
        return httpClient.deleteAsync("/keys/" + keyId, java.util.Map.of(), null, Key.class, true);
    }

    /** Derive Key */
    public CompletableFuture<DeriveKeyResponse> deriveKey(String keyId, DeriveKeyRequest body) {
        return httpClient.postAsync("/keys/" + keyId + "/derive", java.util.Map.of(), body, DeriveKeyResponse.class, true);
    }

    /** Export Key */
    public CompletableFuture<ExportKeyResponse> exportKey(String keyId, ExportKeyRequest body) {
        return httpClient.postAsync("/keys/" + keyId + "/export", java.util.Map.of(), body, ExportKeyResponse.class, true);
    }

    /** List Signatures */
    public CompletableFuture<ListSignaturesResponse> listSignatures(String keyId, ListSignaturesQuery query) {
        return httpClient.getAsync("/keys/" + keyId + "/signatures", query.toMap(), ListSignaturesResponse.class);
    }

    /** Generate Signature */
    public CompletableFuture<SignatureRequest> generateSignature(String keyId, Object body) {
        return httpClient.postAsync("/keys/" + keyId + "/signatures", java.util.Map.of(), body, SignatureRequest.class, true);
    }

    /** Get Signature */
    public CompletableFuture<SignatureRequest> getSignature(String keyId, String signatureId) {
        return httpClient.getAsync("/keys/" + keyId + "/signatures/" + signatureId, java.util.Map.of(), SignatureRequest.class);
    }

    /** Import Key */
    public CompletableFuture<Key> importKey(ImportKeyRequest body) {
        return httpClient.postAsync("/keys/import", java.util.Map.of(), body, Key.class, true);
    }
}
