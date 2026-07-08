package co.dfns.sdk.permissions;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.permissions.model.*;
import java.util.Map;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedPermissionsClient {
    private final DfnsHttpClient httpClient;

    public DelegatedPermissionsClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Delegated signing step 1 for Archive Permission: returns the challenge to sign out-of-band. */
    public UserActionChallenge archivePermissionInit(String permissionId, ArchivePermissionRequest body) {
        return httpClient.createUserActionChallenge("PUT", "/permissions/" + permissionId + "/archive", body);
    }

    /** Delegated signing step 2 for Archive Permission: submits the signed challenge and issues the request. */
    public Permission archivePermissionComplete(String permissionId, ArchivePermissionRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/permissions/" + permissionId + "/archive", java.util.Map.of(), body, Permission.class, userAction);
    }

    /** List Permission Assignments */
    public ListPermissionAssignmentsResponse listPermissionAssignments(String permissionId, ListPermissionAssignmentsQuery query) {
        return httpClient.get("/permissions/" + permissionId + "/assignments", query.toMap(), ListPermissionAssignmentsResponse.class);
    }

    /** Delegated signing step 1 for Assign Permission: returns the challenge to sign out-of-band. */
    public UserActionChallenge assignPermissionInit(String permissionId, AssignPermissionRequest body) {
        return httpClient.createUserActionChallenge("POST", "/permissions/" + permissionId + "/assignments", body);
    }

    /** Delegated signing step 2 for Assign Permission: submits the signed challenge and issues the request. */
    public AssignPermissionResponse assignPermissionComplete(String permissionId, AssignPermissionRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/permissions/" + permissionId + "/assignments", java.util.Map.of(), body, AssignPermissionResponse.class, userAction);
    }

    /** List Permissions */
    public ListPermissionsResponse listPermissions(ListPermissionsQuery query) {
        return httpClient.get("/permissions", query.toMap(), ListPermissionsResponse.class);
    }

    /** Delegated signing step 1 for Create Permission: returns the challenge to sign out-of-band. */
    public UserActionChallenge createPermissionInit(CreatePermissionRequest body) {
        return httpClient.createUserActionChallenge("POST", "/permissions", body);
    }

    /** Delegated signing step 2 for Create Permission: submits the signed challenge and issues the request. */
    public Permission createPermissionComplete(CreatePermissionRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/permissions", java.util.Map.of(), body, Permission.class, userAction);
    }

    /** Delegated signing step 1 for Revoke Permission: returns the challenge to sign out-of-band. */
    public UserActionChallenge revokePermissionInit(String permissionId, String assignmentId) {
        return httpClient.createUserActionChallenge("DELETE", "/permissions/" + permissionId + "/assignments/" + assignmentId, null);
    }

    /** Delegated signing step 2 for Revoke Permission: submits the signed challenge and issues the request. */
    public Void revokePermissionComplete(String permissionId, String assignmentId, RevokePermissionQuery query, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("DELETE", "/permissions/" + permissionId + "/assignments/" + assignmentId, query.toMap(), null, Void.class, userAction);
    }

    /** Get Permission */
    public Permission getPermission(String permissionId) {
        return httpClient.get("/permissions/" + permissionId, java.util.Map.of(), Permission.class);
    }

    /** Delegated signing step 1 for Update Permission: returns the challenge to sign out-of-band. */
    public UserActionChallenge updatePermissionInit(String permissionId, UpdatePermissionRequest body) {
        return httpClient.createUserActionChallenge("PUT", "/permissions/" + permissionId, body);
    }

    /** Delegated signing step 2 for Update Permission: submits the signed challenge and issues the request. */
    public Permission updatePermissionComplete(String permissionId, UpdatePermissionRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/permissions/" + permissionId, java.util.Map.of(), body, Permission.class, userAction);
    }
}
