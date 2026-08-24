package co.dfns.sdk.addresswatches;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.addresswatches.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class AddressWatchesAsyncClient {
    private final DfnsHttpClient httpClient;

    public AddressWatchesAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Address Watches */
    public CompletableFuture<PaginatedList<AddressWatch>> listAddressWatches(ListAddressWatchesQuery query) {
        return httpClient.getAsync("/address-watches", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<AddressWatch>>() {});
    }

    /** Create Address Watch */
    public CompletableFuture<AddressWatch> createAddressWatch(CreateAddressWatchRequest body) {
        return httpClient.postAsync("/address-watches", java.util.Map.of(), body, AddressWatch.class, true);
    }

    /** Get Address Watch */
    public CompletableFuture<AddressWatch> getAddressWatch(String addressWatchId) {
        return httpClient.getAsync("/address-watches/" + addressWatchId, java.util.Map.of(), AddressWatch.class);
    }

    /** Delete Address Watch */
    public CompletableFuture<AddressWatch> deleteAddressWatch(String addressWatchId) {
        return httpClient.deleteAsync("/address-watches/" + addressWatchId, java.util.Map.of(), null, AddressWatch.class, true);
    }

    /** Get Address Watch Assets */
    public CompletableFuture<GetAddressWatchAssetsResponse> getAddressWatchAssets(String addressWatchId, GetAddressWatchAssetsQuery query) {
        return httpClient.getAsync("/address-watches/" + addressWatchId + "/assets", query.toMap(), GetAddressWatchAssetsResponse.class);
    }

    /** Get Address Watch Blockchain Events */
    public CompletableFuture<GetAddressWatchBlockchainEventsResponse> getAddressWatchBlockchainEvents(String addressWatchId, GetAddressWatchBlockchainEventsQuery query) {
        return httpClient.getAsync("/address-watches/" + addressWatchId + "/blockchain-events", query.toMap(), GetAddressWatchBlockchainEventsResponse.class);
    }

    /** Get Address Watch History */
    public CompletableFuture<GetAddressWatchHistoryResponse> getAddressWatchHistory(String addressWatchId, GetAddressWatchHistoryQuery query) {
        return httpClient.getAsync("/address-watches/" + addressWatchId + "/history", query.toMap(), GetAddressWatchHistoryResponse.class);
    }
}
