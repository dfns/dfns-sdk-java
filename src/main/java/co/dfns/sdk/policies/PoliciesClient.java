package co.dfns.sdk.policies;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.policies.model.*;
import java.util.Map;
import java.util.List;
import co.dfns.sdk.PaginatedList;

public class PoliciesClient {
    private final DfnsHttpClient httpClient;

    public PoliciesClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Get Policy */
    public Policy getPolicy(String policyId) {
        return httpClient.get("/v2/policies/" + policyId, java.util.Map.of(), Policy.class);
    }

    /** Update Policy */
    public Policy updatePolicy(String policyId, Object body) {
        return httpClient.put("/v2/policies/" + policyId, java.util.Map.of(), body, Policy.class, true);
    }

    /** Delete Policy */
    public Policy deletePolicy(String policyId) {
        return httpClient.delete("/v2/policies/" + policyId, java.util.Map.of(), null, Policy.class, true);
    }

    /** Create Approval Decision */
    public PolicyApproval createApprovalDecision(String approvalId, CreateApprovalDecisionRequest body) {
        return httpClient.post("/v2/policy-approvals/" + approvalId + "/decisions", java.util.Map.of(), body, PolicyApproval.class, true);
    }

    /** List Policies */
    public ListPoliciesResponse listPolicies(ListPoliciesQuery query) {
        return httpClient.get("/v2/policies", query.toMap(), ListPoliciesResponse.class);
    }

    /** Create Policy */
    public Policy createPolicy(Object body) {
        return httpClient.post("/v2/policies", java.util.Map.of(), body, Policy.class, true);
    }

    /** Get Approval */
    public PolicyApproval getApproval(String approvalId) {
        return httpClient.get("/v2/policy-approvals/" + approvalId, java.util.Map.of(), PolicyApproval.class);
    }

    /** List Approvals */
    public PaginatedList<PolicyApproval> listApprovals(ListApprovalsQuery query) {
        return httpClient.get("/v2/policy-approvals", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<PolicyApproval>>() {});
    }
}
