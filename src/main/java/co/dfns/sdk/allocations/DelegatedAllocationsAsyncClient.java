package co.dfns.sdk.allocations;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.allocations.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.concurrent.CompletableFuture;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedAllocationsAsyncClient {
    private final DfnsHttpClient httpClient;

    public DelegatedAllocationsAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Allocations */
    public CompletableFuture<PaginatedList<Allocation>> listAllocations(ListAllocationsQuery query) {
        return httpClient.getAsync("/allocations", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Allocation>>() {});
    }

    /** Delegated signing step 1 for Create Allocation: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createAllocationInit(Object body) {
        return httpClient.createUserActionChallengeAsync("POST", "/allocations", body);
    }

    /** Delegated signing step 2 for Create Allocation: submits the signed challenge and issues the request. */
    public CompletableFuture<Allocation> createAllocationComplete(Object body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/allocations", java.util.Map.of(), body, Allocation.class, userAction));
    }

    /** List Allocation Actions */
    public CompletableFuture<PaginatedList<AllocationAction>> listAllocationActions(String allocationId, ListAllocationActionsQuery query) {
        return httpClient.getAsync("/allocations/" + allocationId + "/actions", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<AllocationAction>>() {});
    }

    /** Delegated signing step 1 for Create Allocation Action: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createAllocationActionInit(String allocationId, Object body) {
        return httpClient.createUserActionChallengeAsync("POST", "/allocations/" + allocationId + "/actions", body);
    }

    /** Delegated signing step 2 for Create Allocation Action: submits the signed challenge and issues the request. */
    public CompletableFuture<Allocation> createAllocationActionComplete(String allocationId, Object body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/allocations/" + allocationId + "/actions", java.util.Map.of(), body, Allocation.class, userAction));
    }

    /** Get Allocation */
    public CompletableFuture<Allocation> getAllocation(String allocationId) {
        return httpClient.getAsync("/allocations/" + allocationId, java.util.Map.of(), Allocation.class);
    }
}
