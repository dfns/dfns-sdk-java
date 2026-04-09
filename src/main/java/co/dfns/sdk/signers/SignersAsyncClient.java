package co.dfns.sdk.signers;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.signers.model.*;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class SignersAsyncClient {
    private final DfnsHttpClient httpClient;

    public SignersAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Key Stores */
    public CompletableFuture<ListKeyStoresResponse> listKeyStores() {
        return httpClient.getAsync("/key-stores", java.util.Map.of(), ListKeyStoresResponse.class);
    }

    /** List Signers */
    public CompletableFuture<ListSignersResponse> listSigners() {
        return httpClient.getAsync("/signers", java.util.Map.of(), ListSignersResponse.class);
    }
}
