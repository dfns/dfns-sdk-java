package co.dfns.sdk.policies;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.policies.model.*;
import java.util.Map;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.concurrent.CompletableFuture;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedPoliciesAsyncClient {
    private final DfnsHttpClient httpClient;

    public DelegatedPoliciesAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Get Policy */
    public CompletableFuture<Policy> getPolicy(String policyId) {
        return httpClient.getAsync("/v2/policies/" + policyId, java.util.Map.of(), Policy.class);
    }

    /** Delegated signing step 1 for Update Policy: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> updatePolicyInit(String policyId, Object body) {
        return httpClient.createUserActionChallengeAsync("PUT", "/v2/policies/" + policyId, body);
    }

    /** Delegated signing step 2 for Update Policy: submits the signed challenge and issues the request. */
    public CompletableFuture<Policy> updatePolicyComplete(String policyId, Object body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("PUT", "/v2/policies/" + policyId, java.util.Map.of(), body, Policy.class, userAction));
    }

    /** Delegated signing step 1 for Delete Policy: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> deletePolicyInit(String policyId) {
        return httpClient.createUserActionChallengeAsync("DELETE", "/v2/policies/" + policyId, null);
    }

    /** Delegated signing step 2 for Delete Policy: submits the signed challenge and issues the request. */
    public CompletableFuture<Policy> deletePolicyComplete(String policyId, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("DELETE", "/v2/policies/" + policyId, java.util.Map.of(), null, Policy.class, userAction));
    }

    /** Delegated signing step 1 for Create Approval Decision: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createApprovalDecisionInit(String approvalId, CreateApprovalDecisionRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/v2/policy-approvals/" + approvalId + "/decisions", body);
    }

    /** Delegated signing step 2 for Create Approval Decision: submits the signed challenge and issues the request. */
    public CompletableFuture<PolicyApproval> createApprovalDecisionComplete(String approvalId, CreateApprovalDecisionRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/v2/policy-approvals/" + approvalId + "/decisions", java.util.Map.of(), body, PolicyApproval.class, userAction));
    }

    /** List Policies */
    public CompletableFuture<ListPoliciesResponse> listPolicies(ListPoliciesQuery query) {
        return httpClient.getAsync("/v2/policies", query.toMap(), ListPoliciesResponse.class);
    }

    /** Delegated signing step 1 for Create Policy: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createPolicyInit(Object body) {
        return httpClient.createUserActionChallengeAsync("POST", "/v2/policies", body);
    }

    /** Delegated signing step 2 for Create Policy: submits the signed challenge and issues the request. */
    public CompletableFuture<Policy> createPolicyComplete(Object body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/v2/policies", java.util.Map.of(), body, Policy.class, userAction));
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
