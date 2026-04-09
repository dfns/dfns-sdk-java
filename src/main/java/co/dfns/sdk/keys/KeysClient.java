package co.dfns.sdk.keys;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.keys.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.Map;

public class KeysClient {
    private final DfnsHttpClient httpClient;

    public KeysClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Keys */
    public PaginatedList<Key> listKeys(ListKeysQuery query) {
        return httpClient.get("/keys", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Key>>() {});
    }

    /** Create Key */
    public Key createKey(CreateKeyRequest body) {
        return httpClient.post("/keys", java.util.Map.of(), body, Key.class, true);
    }

    /** Delegate Key */
    public DelegateKeyResponse delegateKey(String keyId, DelegateKeyRequest body) {
        return httpClient.post("/keys/" + keyId + "/delegate", java.util.Map.of(), body, DelegateKeyResponse.class, true);
    }

    /** Get Key */
    public Key getKey(String keyId) {
        return httpClient.get("/keys/" + keyId, java.util.Map.of(), Key.class);
    }

    /** Update Key */
    public Key updateKey(String keyId, UpdateKeyRequest body) {
        return httpClient.put("/keys/" + keyId, java.util.Map.of(), body, Key.class, true);
    }

    /** Delete Key */
    public Key deleteKey(String keyId) {
        return httpClient.delete("/keys/" + keyId, java.util.Map.of(), null, Key.class, true);
    }

    /** Derive Key */
    public DeriveKeyResponse deriveKey(String keyId, DeriveKeyRequest body) {
        return httpClient.post("/keys/" + keyId + "/derive", java.util.Map.of(), body, DeriveKeyResponse.class, true);
    }

    /** Export Key */
    public ExportKeyResponse exportKey(String keyId, ExportKeyRequest body) {
        return httpClient.post("/keys/" + keyId + "/export", java.util.Map.of(), body, ExportKeyResponse.class, true);
    }

    /** List Signatures */
    public ListSignaturesResponse listSignatures(String keyId, ListSignaturesQuery query) {
        return httpClient.get("/keys/" + keyId + "/signatures", query.toMap(), ListSignaturesResponse.class);
    }

    /** Generate Signature */
    public SignatureRequest generateSignature(String keyId, Object body) {
        return httpClient.post("/keys/" + keyId + "/signatures", java.util.Map.of(), body, SignatureRequest.class, true);
    }

    /** Get Signature */
    public SignatureRequest getSignature(String keyId, String signatureId) {
        return httpClient.get("/keys/" + keyId + "/signatures/" + signatureId, java.util.Map.of(), SignatureRequest.class);
    }

    /** Import Key */
    public Key importKey(ImportKeyRequest body) {
        return httpClient.post("/keys/import", java.util.Map.of(), body, Key.class, true);
    }
}
