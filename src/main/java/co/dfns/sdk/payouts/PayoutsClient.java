package co.dfns.sdk.payouts;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.payouts.model.*;
import java.util.Map;

public class PayoutsClient {
    private final DfnsHttpClient httpClient;

    public PayoutsClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Payouts */
    public ListPayoutsResponse listPayouts(ListPayoutsQuery query) {
        return httpClient.get("/payouts", query.toMap(), ListPayoutsResponse.class);
    }

    /** Create Payout */
    public Object createPayout(Object body) {
        return httpClient.post("/payouts", java.util.Map.of(), body, Object.class, true);
    }

    /** Request Payout Quote */
    public RequestPayoutQuoteResponse requestPayoutQuote(Object body) {
        return httpClient.post("/payouts/quote", java.util.Map.of(), body, RequestPayoutQuoteResponse.class, false);
    }

    /** Get Payout Status */
    public Object getPayoutStatus(String payoutId) {
        return httpClient.get("/payouts/" + payoutId, java.util.Map.of(), Object.class);
    }

    /** Create Payout Action */
    @SuppressWarnings("unchecked")
    public Map<String, Object> createPayoutAction(String payoutId, Object body) {
        return httpClient.post("/payouts/" + payoutId + "/action", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, true);
    }
}
