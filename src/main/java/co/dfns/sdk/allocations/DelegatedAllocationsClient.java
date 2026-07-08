package co.dfns.sdk.allocations;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.allocations.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedAllocationsClient {
    private final DfnsHttpClient httpClient;

    public DelegatedAllocationsClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Allocations */
    public PaginatedList<Allocation> listAllocations(ListAllocationsQuery query) {
        return httpClient.get("/allocations", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Allocation>>() {});
    }

    /** Delegated signing step 1 for Create Allocation: returns the challenge to sign out-of-band. */
    public UserActionChallenge createAllocationInit(Object body) {
        return httpClient.createUserActionChallenge("POST", "/allocations", body);
    }

    /** Delegated signing step 2 for Create Allocation: submits the signed challenge and issues the request. */
    public Allocation createAllocationComplete(Object body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/allocations", java.util.Map.of(), body, Allocation.class, userAction);
    }

    /** List Allocation Actions */
    public PaginatedList<AllocationAction> listAllocationActions(String allocationId, ListAllocationActionsQuery query) {
        return httpClient.get("/allocations/" + allocationId + "/actions", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<AllocationAction>>() {});
    }

    /** Delegated signing step 1 for Create Allocation Action: returns the challenge to sign out-of-band. */
    public UserActionChallenge createAllocationActionInit(String allocationId, Object body) {
        return httpClient.createUserActionChallenge("POST", "/allocations/" + allocationId + "/actions", body);
    }

    /** Delegated signing step 2 for Create Allocation Action: submits the signed challenge and issues the request. */
    public Allocation createAllocationActionComplete(String allocationId, Object body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/allocations/" + allocationId + "/actions", java.util.Map.of(), body, Allocation.class, userAction);
    }

    /** Get Allocation */
    public Allocation getAllocation(String allocationId) {
        return httpClient.get("/allocations/" + allocationId, java.util.Map.of(), Allocation.class);
    }
}
