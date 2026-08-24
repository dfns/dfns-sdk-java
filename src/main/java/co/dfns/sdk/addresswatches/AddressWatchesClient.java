package co.dfns.sdk.addresswatches;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.addresswatches.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.Map;

public class AddressWatchesClient {
    private final DfnsHttpClient httpClient;

    public AddressWatchesClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Address Watches */
    public PaginatedList<AddressWatch> listAddressWatches(ListAddressWatchesQuery query) {
        return httpClient.get("/address-watches", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<AddressWatch>>() {});
    }

    /** Create Address Watch */
    public AddressWatch createAddressWatch(CreateAddressWatchRequest body) {
        return httpClient.post("/address-watches", java.util.Map.of(), body, AddressWatch.class, true);
    }

    /** Get Address Watch */
    public AddressWatch getAddressWatch(String addressWatchId) {
        return httpClient.get("/address-watches/" + addressWatchId, java.util.Map.of(), AddressWatch.class);
    }

    /** Delete Address Watch */
    public AddressWatch deleteAddressWatch(String addressWatchId) {
        return httpClient.delete("/address-watches/" + addressWatchId, java.util.Map.of(), null, AddressWatch.class, true);
    }

    /** Get Address Watch Assets */
    public GetAddressWatchAssetsResponse getAddressWatchAssets(String addressWatchId, GetAddressWatchAssetsQuery query) {
        return httpClient.get("/address-watches/" + addressWatchId + "/assets", query.toMap(), GetAddressWatchAssetsResponse.class);
    }

    /** Get Address Watch Blockchain Events */
    public GetAddressWatchBlockchainEventsResponse getAddressWatchBlockchainEvents(String addressWatchId, GetAddressWatchBlockchainEventsQuery query) {
        return httpClient.get("/address-watches/" + addressWatchId + "/blockchain-events", query.toMap(), GetAddressWatchBlockchainEventsResponse.class);
    }

    /** Get Address Watch History */
    public GetAddressWatchHistoryResponse getAddressWatchHistory(String addressWatchId, GetAddressWatchHistoryQuery query) {
        return httpClient.get("/address-watches/" + addressWatchId + "/history", query.toMap(), GetAddressWatchHistoryResponse.class);
    }
}
