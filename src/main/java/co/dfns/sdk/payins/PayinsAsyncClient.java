package co.dfns.sdk.payins;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.payins.model.*;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class PayinsAsyncClient {
    private final DfnsHttpClient httpClient;

    public PayinsAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Get Payin Recipient */
    public CompletableFuture<GetPayinRecipientResponse> getPayinRecipient(GetPayinRecipientQuery query) {
        return httpClient.getAsync("/payins/recipients", query.toMap(), GetPayinRecipientResponse.class);
    }

    /** Register Payin Recipient */
    public CompletableFuture<RegisterPayinRecipientResponse> registerPayinRecipient(Object body) {
        return httpClient.postAsync("/payins/recipients", java.util.Map.of(), body, RegisterPayinRecipientResponse.class, true);
    }
}
