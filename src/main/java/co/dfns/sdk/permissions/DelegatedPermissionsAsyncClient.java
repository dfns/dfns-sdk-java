package co.dfns.sdk.permissions;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.permissions.model.*;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedPermissionsAsyncClient {
    private final DfnsHttpClient httpClient;

    public DelegatedPermissionsAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Delegated signing step 1 for Archive Permission: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> archivePermissionInit(String permissionId, ArchivePermissionRequest body) {
        return httpClient.createUserActionChallengeAsync("PUT", "/permissions/" + permissionId + "/archive", body);
    }

    /** Delegated signing step 2 for Archive Permission: submits the signed challenge and issues the request. */
    public CompletableFuture<Permission> archivePermissionComplete(String permissionId, ArchivePermissionRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("PUT", "/permissions/" + permissionId + "/archive", java.util.Map.of(), body, Permission.class, userAction));
    }

    /** List Permission Assignments */
    public CompletableFuture<ListPermissionAssignmentsResponse> listPermissionAssignments(String permissionId, ListPermissionAssignmentsQuery query) {
        return httpClient.getAsync("/permissions/" + permissionId + "/assignments", query.toMap(), ListPermissionAssignmentsResponse.class);
    }

    /** Delegated signing step 1 for Assign Permission: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> assignPermissionInit(String permissionId, AssignPermissionRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/permissions/" + permissionId + "/assignments", body);
    }

    /** Delegated signing step 2 for Assign Permission: submits the signed challenge and issues the request. */
    public CompletableFuture<AssignPermissionResponse> assignPermissionComplete(String permissionId, AssignPermissionRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/permissions/" + permissionId + "/assignments", java.util.Map.of(), body, AssignPermissionResponse.class, userAction));
    }

    /** List Permissions */
    public CompletableFuture<ListPermissionsResponse> listPermissions(ListPermissionsQuery query) {
        return httpClient.getAsync("/permissions", query.toMap(), ListPermissionsResponse.class);
    }

    /** Delegated signing step 1 for Create Permission: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createPermissionInit(CreatePermissionRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/permissions", body);
    }

    /** Delegated signing step 2 for Create Permission: submits the signed challenge and issues the request. */
    public CompletableFuture<Permission> createPermissionComplete(CreatePermissionRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/permissions", java.util.Map.of(), body, Permission.class, userAction));
    }

    /** Delegated signing step 1 for Revoke Permission: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> revokePermissionInit(String permissionId, String assignmentId) {
        return httpClient.createUserActionChallengeAsync("DELETE", "/permissions/" + permissionId + "/assignments/" + assignmentId, null);
    }

    /** Delegated signing step 2 for Revoke Permission: submits the signed challenge and issues the request. */
    public CompletableFuture<Void> revokePermissionComplete(String permissionId, String assignmentId, RevokePermissionQuery query, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("DELETE", "/permissions/" + permissionId + "/assignments/" + assignmentId, query.toMap(), null, Void.class, userAction));
    }

    /** Get Permission */
    public CompletableFuture<Permission> getPermission(String permissionId) {
        return httpClient.getAsync("/permissions/" + permissionId, java.util.Map.of(), Permission.class);
    }

    /** Delegated signing step 1 for Update Permission: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> updatePermissionInit(String permissionId, UpdatePermissionRequest body) {
        return httpClient.createUserActionChallengeAsync("PUT", "/permissions/" + permissionId, body);
    }

    /** Delegated signing step 2 for Update Permission: submits the signed challenge and issues the request. */
    public CompletableFuture<Permission> updatePermissionComplete(String permissionId, UpdatePermissionRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("PUT", "/permissions/" + permissionId, java.util.Map.of(), body, Permission.class, userAction));
    }
}
