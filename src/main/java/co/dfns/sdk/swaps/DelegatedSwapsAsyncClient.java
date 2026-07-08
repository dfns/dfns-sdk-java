package co.dfns.sdk.swaps;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.swaps.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.concurrent.CompletableFuture;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedSwapsAsyncClient {
    private final DfnsHttpClient httpClient;

    public DelegatedSwapsAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Swaps */
    public CompletableFuture<PaginatedList<Swap>> listSwaps(ListSwapsQuery query) {
        return httpClient.getAsync("/swaps", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Swap>>() {});
    }

    /** Delegated signing step 1 for Create Swap: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createSwapInit(Object body) {
        return httpClient.createUserActionChallengeAsync("POST", "/swaps", body);
    }

    /** Delegated signing step 2 for Create Swap: submits the signed challenge and issues the request. */
    public CompletableFuture<Swap> createSwapComplete(Object body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/swaps", java.util.Map.of(), body, Swap.class, userAction));
    }

    /** Request Swap Quote */
    public CompletableFuture<SwapQuote> requestSwapQuote(Object body) {
        return httpClient.postAsync("/swaps/quotes", java.util.Map.of(), body, SwapQuote.class, false);
    }

    /** Get Swap */
    public CompletableFuture<Swap> getSwap(String swapId) {
        return httpClient.getAsync("/swaps/" + swapId, java.util.Map.of(), Swap.class);
    }

    /** Get Swap Quote */
    public CompletableFuture<SwapQuote> getSwapQuote(String quoteId) {
        return httpClient.getAsync("/swaps/quotes/" + quoteId, java.util.Map.of(), SwapQuote.class);
    }
}
