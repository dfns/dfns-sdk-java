package co.dfns.sdk.allocations;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.allocations.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.Map;

public class AllocationsClient {
    private final DfnsHttpClient httpClient;

    public AllocationsClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Allocations */
    public PaginatedList<Allocation> listAllocations(ListAllocationsQuery query) {
        return httpClient.get("/allocations", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Allocation>>() {});
    }

    /** Create Allocation */
    public Allocation createAllocation(Object body) {
        return httpClient.post("/allocations", java.util.Map.of(), body, Allocation.class, true);
    }

    /** List Allocation Actions */
    public PaginatedList<AllocationAction> listAllocationActions(String allocationId, ListAllocationActionsQuery query) {
        return httpClient.get("/allocations/" + allocationId + "/actions", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<AllocationAction>>() {});
    }

    /** Create Allocation Action */
    public Allocation createAllocationAction(String allocationId, Object body) {
        return httpClient.post("/allocations/" + allocationId + "/actions", java.util.Map.of(), body, Allocation.class, true);
    }

    /** Get Allocation */
    public Allocation getAllocation(String allocationId) {
        return httpClient.get("/allocations/" + allocationId, java.util.Map.of(), Allocation.class);
    }

    /** Get Allocations Info */
    public GetAllocationsInfoResponse getAllocationsInfo() {
        return httpClient.get("/allocations/info", java.util.Map.of(), GetAllocationsInfoResponse.class);
    }
}
