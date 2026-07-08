package co.dfns.sdk.swaps;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.swaps.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedSwapsClient {
    private final DfnsHttpClient httpClient;

    public DelegatedSwapsClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Swaps */
    public PaginatedList<Swap> listSwaps(ListSwapsQuery query) {
        return httpClient.get("/swaps", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Swap>>() {});
    }

    /** Delegated signing step 1 for Create Swap: returns the challenge to sign out-of-band. */
    public UserActionChallenge createSwapInit(Object body) {
        return httpClient.createUserActionChallenge("POST", "/swaps", body);
    }

    /** Delegated signing step 2 for Create Swap: submits the signed challenge and issues the request. */
    public Swap createSwapComplete(Object body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/swaps", java.util.Map.of(), body, Swap.class, userAction);
    }

    /** Request Swap Quote */
    public SwapQuote requestSwapQuote(Object body) {
        return httpClient.post("/swaps/quotes", java.util.Map.of(), body, SwapQuote.class, false);
    }

    /** Get Swap */
    public Swap getSwap(String swapId) {
        return httpClient.get("/swaps/" + swapId, java.util.Map.of(), Swap.class);
    }

    /** Get Swap Quote */
    public SwapQuote getSwapQuote(String quoteId) {
        return httpClient.get("/swaps/quotes/" + quoteId, java.util.Map.of(), SwapQuote.class);
    }
}
