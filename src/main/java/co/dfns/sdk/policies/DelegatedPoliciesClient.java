package co.dfns.sdk.policies;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.policies.model.*;
import java.util.Map;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedPoliciesClient {
    private final DfnsHttpClient httpClient;

    public DelegatedPoliciesClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Get Policy */
    public Policy getPolicy(String policyId) {
        return httpClient.get("/v2/policies/" + policyId, java.util.Map.of(), Policy.class);
    }

    /** Delegated signing step 1 for Update Policy: returns the challenge to sign out-of-band. */
    public UserActionChallenge updatePolicyInit(String policyId, Object body) {
        return httpClient.createUserActionChallenge("PUT", "/v2/policies/" + policyId, body);
    }

    /** Delegated signing step 2 for Update Policy: submits the signed challenge and issues the request. */
    public Policy updatePolicyComplete(String policyId, Object body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/v2/policies/" + policyId, java.util.Map.of(), body, Policy.class, userAction);
    }

    /** Delegated signing step 1 for Delete Policy: returns the challenge to sign out-of-band. */
    public UserActionChallenge deletePolicyInit(String policyId) {
        return httpClient.createUserActionChallenge("DELETE", "/v2/policies/" + policyId, null);
    }

    /** Delegated signing step 2 for Delete Policy: submits the signed challenge and issues the request. */
    public Policy deletePolicyComplete(String policyId, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("DELETE", "/v2/policies/" + policyId, java.util.Map.of(), null, Policy.class, userAction);
    }

    /** Delegated signing step 1 for Create Approval Decision: returns the challenge to sign out-of-band. */
    public UserActionChallenge createApprovalDecisionInit(String approvalId, CreateApprovalDecisionRequest body) {
        return httpClient.createUserActionChallenge("POST", "/v2/policy-approvals/" + approvalId + "/decisions", body);
    }

    /** Delegated signing step 2 for Create Approval Decision: submits the signed challenge and issues the request. */
    public PolicyApproval createApprovalDecisionComplete(String approvalId, CreateApprovalDecisionRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/v2/policy-approvals/" + approvalId + "/decisions", java.util.Map.of(), body, PolicyApproval.class, userAction);
    }

    /** List Policies */
    public ListPoliciesResponse listPolicies(ListPoliciesQuery query) {
        return httpClient.get("/v2/policies", query.toMap(), ListPoliciesResponse.class);
    }

    /** Delegated signing step 1 for Create Policy: returns the challenge to sign out-of-band. */
    public UserActionChallenge createPolicyInit(Object body) {
        return httpClient.createUserActionChallenge("POST", "/v2/policies", body);
    }

    /** Delegated signing step 2 for Create Policy: submits the signed challenge and issues the request. */
    public Policy createPolicyComplete(Object body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/v2/policies", java.util.Map.of(), body, Policy.class, userAction);
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
