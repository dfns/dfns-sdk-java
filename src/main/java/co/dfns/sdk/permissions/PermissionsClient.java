package co.dfns.sdk.permissions;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.permissions.model.*;
import java.util.Map;

public class PermissionsClient {
    private final DfnsHttpClient httpClient;

    public PermissionsClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Archive Permission */
    public Permission archivePermission(String permissionId, ArchivePermissionRequest body) {
        return httpClient.put("/permissions/" + permissionId + "/archive", java.util.Map.of(), body, Permission.class, true);
    }

    /** List Permission Assignments */
    public ListPermissionAssignmentsResponse listPermissionAssignments(String permissionId, ListPermissionAssignmentsQuery query) {
        return httpClient.get("/permissions/" + permissionId + "/assignments", query.toMap(), ListPermissionAssignmentsResponse.class);
    }

    /** Assign Permission */
    public AssignPermissionResponse assignPermission(String permissionId, AssignPermissionRequest body) {
        return httpClient.post("/permissions/" + permissionId + "/assignments", java.util.Map.of(), body, AssignPermissionResponse.class, true);
    }

    /** List Permissions */
    public ListPermissionsResponse listPermissions(ListPermissionsQuery query) {
        return httpClient.get("/permissions", query.toMap(), ListPermissionsResponse.class);
    }

    /** Create Permission */
    public Permission createPermission(CreatePermissionRequest body) {
        return httpClient.post("/permissions", java.util.Map.of(), body, Permission.class, true);
    }

    /** Revoke Permission */
    public Void revokePermission(String permissionId, String assignmentId, RevokePermissionQuery query) {
        return httpClient.delete("/permissions/" + permissionId + "/assignments/" + assignmentId, query.toMap(), null, Void.class, true);
    }

    /** Get Permission */
    public Permission getPermission(String permissionId) {
        return httpClient.get("/permissions/" + permissionId, java.util.Map.of(), Permission.class);
    }

    /** Update Permission */
    public Permission updatePermission(String permissionId, UpdatePermissionRequest body) {
        return httpClient.put("/permissions/" + permissionId, java.util.Map.of(), body, Permission.class, true);
    }
}
