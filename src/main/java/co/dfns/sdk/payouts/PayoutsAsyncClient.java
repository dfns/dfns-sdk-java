package co.dfns.sdk.payouts;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.payouts.model.*;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class PayoutsAsyncClient {
    private final DfnsHttpClient httpClient;

    public PayoutsAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Payouts */
    public CompletableFuture<ListPayoutsResponse> listPayouts(ListPayoutsQuery query) {
        return httpClient.getAsync("/payouts", query.toMap(), ListPayoutsResponse.class);
    }

    /** Create Payout */
    public CompletableFuture<Object> createPayout(Object body) {
        return httpClient.postAsync("/payouts", java.util.Map.of(), body, Object.class, true);
    }

    /** Request Payout Quote */
    public CompletableFuture<RequestPayoutQuoteResponse> requestPayoutQuote(Object body) {
        return httpClient.postAsync("/payouts/quote", java.util.Map.of(), body, RequestPayoutQuoteResponse.class, false);
    }

    /** Get Payout Status */
    public CompletableFuture<Object> getPayoutStatus(String payoutId) {
        return httpClient.getAsync("/payouts/" + payoutId, java.util.Map.of(), Object.class);
    }

    /** Create Payout Action */
    @SuppressWarnings("unchecked")
    public CompletableFuture<Map<String, Object>> createPayoutAction(String payoutId, Object body) {
        return httpClient.postAsync("/payouts/" + payoutId + "/action", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, true);
    }
}
