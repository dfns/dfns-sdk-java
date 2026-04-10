package co.dfns.sdk.permissions;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.permissions.model.*;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class PermissionsAsyncClient {
    private final DfnsHttpClient httpClient;

    public PermissionsAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Archive Permission */
    public CompletableFuture<Permission> archivePermission(String permissionId, ArchivePermissionRequest body) {
        return httpClient.putAsync("/permissions/" + permissionId + "/archive", java.util.Map.of(), body, Permission.class, true);
    }

    /** List Permission Assignments */
    public CompletableFuture<ListPermissionAssignmentsResponse> listPermissionAssignments(String permissionId, ListPermissionAssignmentsQuery query) {
        return httpClient.getAsync("/permissions/" + permissionId + "/assignments", query.toMap(), ListPermissionAssignmentsResponse.class);
    }

    /** Assign Permission */
    public CompletableFuture<AssignPermissionResponse> assignPermission(String permissionId, AssignPermissionRequest body) {
        return httpClient.postAsync("/permissions/" + permissionId + "/assignments", java.util.Map.of(), body, AssignPermissionResponse.class, true);
    }

    /** List Permissions */
    public CompletableFuture<ListPermissionsResponse> listPermissions(ListPermissionsQuery query) {
        return httpClient.getAsync("/permissions", query.toMap(), ListPermissionsResponse.class);
    }

    /** Create Permission */
    public CompletableFuture<Permission> createPermission(CreatePermissionRequest body) {
        return httpClient.postAsync("/permissions", java.util.Map.of(), body, Permission.class, true);
    }

    /** Revoke Permission */
    public CompletableFuture<Void> revokePermission(String permissionId, String assignmentId, RevokePermissionQuery query) {
        return httpClient.deleteAsync("/permissions/" + permissionId + "/assignments/" + assignmentId, query.toMap(), null, Void.class, true);
    }

    /** Get Permission */
    public CompletableFuture<Permission> getPermission(String permissionId) {
        return httpClient.getAsync("/permissions/" + permissionId, java.util.Map.of(), Permission.class);
    }

    /** Update Permission */
    public CompletableFuture<Permission> updatePermission(String permissionId, UpdatePermissionRequest body) {
        return httpClient.putAsync("/permissions/" + permissionId, java.util.Map.of(), body, Permission.class, true);
    }
}
