package co.dfns.sdk.allocations;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.allocations.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class AllocationsAsyncClient {
    private final DfnsHttpClient httpClient;

    public AllocationsAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Allocations */
    public CompletableFuture<PaginatedList<Allocation>> listAllocations(ListAllocationsQuery query) {
        return httpClient.getAsync("/allocations", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Allocation>>() {});
    }

    /** Create Allocation */
    public CompletableFuture<Allocation> createAllocation(Object body) {
        return httpClient.postAsync("/allocations", java.util.Map.of(), body, Allocation.class, true);
    }

    /** List Allocation Actions */
    public CompletableFuture<PaginatedList<AllocationAction>> listAllocationActions(String allocationId, ListAllocationActionsQuery query) {
        return httpClient.getAsync("/allocations/" + allocationId + "/actions", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<AllocationAction>>() {});
    }

    /** Create Allocation Action */
    public CompletableFuture<Allocation> createAllocationAction(String allocationId, Object body) {
        return httpClient.postAsync("/allocations/" + allocationId + "/actions", java.util.Map.of(), body, Allocation.class, true);
    }

    /** Get Allocation */
    public CompletableFuture<Allocation> getAllocation(String allocationId) {
        return httpClient.getAsync("/allocations/" + allocationId, java.util.Map.of(), Allocation.class);
    }

    /** Get Allocations Info */
    public CompletableFuture<GetAllocationsInfoResponse> getAllocationsInfo() {
        return httpClient.getAsync("/allocations/info", java.util.Map.of(), GetAllocationsInfoResponse.class);
    }
}
