package co.dfns.sdk.signers;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.signers.model.*;
import java.util.Map;

public class SignersClient {
    private final DfnsHttpClient httpClient;

    public SignersClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Key Stores */
    public ListKeyStoresResponse listKeyStores() {
        return httpClient.get("/key-stores", java.util.Map.of(), ListKeyStoresResponse.class);
    }

    /** List Signers */
    public ListSignersResponse listSigners() {
        return httpClient.get("/signers", java.util.Map.of(), ListSignersResponse.class);
    }
}
