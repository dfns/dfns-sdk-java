package co.dfns.sdk.payouts;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.payouts.model.*;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedPayoutsAsyncClient {
    private final DfnsHttpClient httpClient;

    public DelegatedPayoutsAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Payouts */
    public CompletableFuture<ListPayoutsResponse> listPayouts(ListPayoutsQuery query) {
        return httpClient.getAsync("/payouts", query.toMap(), ListPayoutsResponse.class);
    }

    /** Delegated signing step 1 for Create Payout: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createPayoutInit(Object body) {
        return httpClient.createUserActionChallengeAsync("POST", "/payouts", body);
    }

    /** Delegated signing step 2 for Create Payout: submits the signed challenge and issues the request. */
    public CompletableFuture<Object> createPayoutComplete(Object body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/payouts", java.util.Map.of(), body, Object.class, userAction));
    }

    /** Request Payout Quote */
    public CompletableFuture<RequestPayoutQuoteResponse> requestPayoutQuote(Object body) {
        return httpClient.postAsync("/payouts/quote", java.util.Map.of(), body, RequestPayoutQuoteResponse.class, false);
    }

    /** Get Payout Status */
    public CompletableFuture<Object> getPayoutStatus(String payoutId) {
        return httpClient.getAsync("/payouts/" + payoutId, java.util.Map.of(), Object.class);
    }

    /** Delegated signing step 1 for Create Payout Action: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createPayoutActionInit(String payoutId, Object body) {
        return httpClient.createUserActionChallengeAsync("POST", "/payouts/" + payoutId + "/action", body);
    }

    /** Delegated signing step 2 for Create Payout Action: submits the signed challenge and issues the request. */
    @SuppressWarnings("unchecked")
    public CompletableFuture<Map<String, Object>> createPayoutActionComplete(String payoutId, Object body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/payouts/" + payoutId + "/action", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, userAction));
    }
}
