package co.dfns.sdk.policies;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.policies.model.*;
import java.util.Map;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.concurrent.CompletableFuture;

public class PoliciesAsyncClient {
    private final DfnsHttpClient httpClient;

    public PoliciesAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Get Policy */
    public CompletableFuture<Policy> getPolicy(String policyId) {
        return httpClient.getAsync("/v2/policies/" + policyId, java.util.Map.of(), Policy.class);
    }

    /** Update Policy */
    public CompletableFuture<Policy> updatePolicy(String policyId, Object body) {
        return httpClient.putAsync("/v2/policies/" + policyId, java.util.Map.of(), body, Policy.class, true);
    }

    /** Delete Policy */
    public CompletableFuture<Policy> deletePolicy(String policyId) {
        return httpClient.deleteAsync("/v2/policies/" + policyId, java.util.Map.of(), null, Policy.class, true);
    }

    /** Create Approval Decision */
    public CompletableFuture<PolicyApproval> createApprovalDecision(String approvalId, CreateApprovalDecisionRequest body) {
        return httpClient.postAsync("/v2/policy-approvals/" + approvalId + "/decisions", java.util.Map.of(), body, PolicyApproval.class, true);
    }

    /** List Policies */
    public CompletableFuture<ListPoliciesResponse> listPolicies(ListPoliciesQuery query) {
        return httpClient.getAsync("/v2/policies", query.toMap(), ListPoliciesResponse.class);
    }

    /** Create Policy */
    public CompletableFuture<Policy> createPolicy(Object body) {
        return httpClient.postAsync("/v2/policies", java.util.Map.of(), body, Policy.class, true);
    }

    /** Get Approval */
    public CompletableFuture<PolicyApproval> getApproval(String approvalId) {
        return httpClient.getAsync("/v2/policy-approvals/" + approvalId, java.util.Map.of(), PolicyApproval.class);
    }

    /** List Approvals */
    public CompletableFuture<PaginatedList<PolicyApproval>> listApprovals(ListApprovalsQuery query) {
        return httpClient.getAsync("/v2/policy-approvals", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<PolicyApproval>>() {});
    }
}
