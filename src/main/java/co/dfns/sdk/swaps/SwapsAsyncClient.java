package co.dfns.sdk.swaps;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.swaps.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.concurrent.CompletableFuture;

public class SwapsAsyncClient {
    private final DfnsHttpClient httpClient;

    public SwapsAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Swaps */
    public CompletableFuture<PaginatedList<Swap>> listSwaps(ListSwapsQuery query) {
        return httpClient.getAsync("/swaps", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Swap>>() {});
    }

    /** Create Swap */
    public CompletableFuture<Swap> createSwap(Object body) {
        return httpClient.postAsync("/swaps", java.util.Map.of(), body, Swap.class, true);
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
