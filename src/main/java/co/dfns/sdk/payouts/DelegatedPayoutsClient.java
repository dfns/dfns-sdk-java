package co.dfns.sdk.payouts;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.payouts.model.*;
import java.util.Map;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedPayoutsClient {
    private final DfnsHttpClient httpClient;

    public DelegatedPayoutsClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Payouts */
    public ListPayoutsResponse listPayouts(ListPayoutsQuery query) {
        return httpClient.get("/payouts", query.toMap(), ListPayoutsResponse.class);
    }

    /** Delegated signing step 1 for Create Payout: returns the challenge to sign out-of-band. */
    public UserActionChallenge createPayoutInit(Object body) {
        return httpClient.createUserActionChallenge("POST", "/payouts", body);
    }

    /** Delegated signing step 2 for Create Payout: submits the signed challenge and issues the request. */
    public Object createPayoutComplete(Object body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/payouts", java.util.Map.of(), body, Object.class, userAction);
    }

    /** Request Payout Quote */
    public RequestPayoutQuoteResponse requestPayoutQuote(Object body) {
        return httpClient.post("/payouts/quote", java.util.Map.of(), body, RequestPayoutQuoteResponse.class, false);
    }

    /** Get Payout Status */
    public Object getPayoutStatus(String payoutId) {
        return httpClient.get("/payouts/" + payoutId, java.util.Map.of(), Object.class);
    }

    /** Delegated signing step 1 for Create Payout Action: returns the challenge to sign out-of-band. */
    public UserActionChallenge createPayoutActionInit(String payoutId, Object body) {
        return httpClient.createUserActionChallenge("POST", "/payouts/" + payoutId + "/action", body);
    }

    /** Delegated signing step 2 for Create Payout Action: submits the signed challenge and issues the request. */
    @SuppressWarnings("unchecked")
    public Map<String, Object> createPayoutActionComplete(String payoutId, Object body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/payouts/" + payoutId + "/action", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, userAction);
    }
}
