package co.dfns.sdk.swaps;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.swaps.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;

public class SwapsClient {
    private final DfnsHttpClient httpClient;

    public SwapsClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Swaps */
    public PaginatedList<Swap> listSwaps(ListSwapsQuery query) {
        return httpClient.get("/swaps", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Swap>>() {});
    }

    /** Create Swap */
    public Swap createSwap(Object body) {
        return httpClient.post("/swaps", java.util.Map.of(), body, Swap.class, true);
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
