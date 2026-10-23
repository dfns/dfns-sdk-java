package co.dfns.sdk.tenant;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.tenant.model.*;
import java.util.Map;
import java.util.List;
import co.dfns.sdk.PaginatedList;

public class TenantClient {
    private final DfnsHttpClient httpClient;

    public TenantClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Assign Tenant Permission */
    public Object assignTenantPermission(String permissionId, AssignTenantPermissionRequest body) {
        return httpClient.post("/tenant/permissions/" + permissionId + "/assign", java.util.Map.of(), body, Object.class, true);
    }

    /** Revoke Tenant Permission */
    public Object revokeTenantPermission(String permissionId, RevokeTenantPermissionRequest body) {
        return httpClient.post("/tenant/permissions/" + permissionId + "/revoke", java.util.Map.of(), body, Object.class, true);
    }

    /** Get Tenant Permission */
    public Permission getTenantPermission(String permissionId) {
        return httpClient.get("/tenant/permissions/" + permissionId, java.util.Map.of(), Permission.class);
    }

    /** List Tenant Permissions */
    public PaginatedList<Permission> listTenantPermissions(ListTenantPermissionsQuery query) {
        return httpClient.get("/tenant/permissions", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Permission>>() {});
    }

    /** List Tenant Users */
    public PaginatedList<TenantUser> listTenantUsers(ListTenantUsersQuery query) {
        return httpClient.get("/tenant/users", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<TenantUser>>() {});
    }

    /** Create Tenant User */
    public TenantUser createTenantUser(CreateTenantUserRequest body) {
        return httpClient.post("/tenant/users", java.util.Map.of(), body, TenantUser.class, true);
    }

    /** Get Tenant User */
    public TenantUser getTenantUser(String userId) {
        return httpClient.get("/tenant/users/" + userId, java.util.Map.of(), TenantUser.class);
    }

    /** Update Tenant User */
    @SuppressWarnings("unchecked")
    public Map<String, Object> updateTenantUser(String userId, UpdateTenantUserRequest body) {
        return httpClient.put("/tenant/users/" + userId, java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, true);
    }

    /** Delete Tenant User */
    @SuppressWarnings("unchecked")
    public Map<String, Object> deleteTenantUser(String userId) {
        return httpClient.delete("/tenant/users/" + userId, java.util.Map.of(), null, (Class<Map<String, Object>>) (Class<?>) Map.class, true);
    }

    /** List Orgs */
    public ListOrgsResponse listOrgs(ListOrgsQuery query) {
        return httpClient.get("/tenant/orgs", query.toMap(), ListOrgsResponse.class);
    }

    /** Create Org */
    public CreateOrgResponse createOrg(CreateOrgRequest body) {
        return httpClient.post("/tenant/orgs", java.util.Map.of(), body, CreateOrgResponse.class, true);
    }

    /** List Tenant User Groups */
    public PaginatedList<UserGroup> listTenantUserGroups(ListTenantUserGroupsQuery query) {
        return httpClient.get("/tenant/user-groups", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<UserGroup>>() {});
    }

    /** Create Tenant User Group */
    public UserGroup createTenantUserGroup(CreateTenantUserGroupRequest body) {
        return httpClient.post("/tenant/user-groups", java.util.Map.of(), body, UserGroup.class, true);
    }

    /** Get Tenant User Group */
    public UserGroup getTenantUserGroup(String userGroupId) {
        return httpClient.get("/tenant/user-groups/" + userGroupId, java.util.Map.of(), UserGroup.class);
    }

    /** Update Tenant User Group */
    public UserGroup updateTenantUserGroup(String userGroupId, UpdateTenantUserGroupRequest body) {
        return httpClient.put("/tenant/user-groups/" + userGroupId, java.util.Map.of(), body, UserGroup.class, true);
    }

    /** Delete Tenant User Group */
    @SuppressWarnings("unchecked")
    public Map<String, Object> deleteTenantUserGroup(String userGroupId) {
        return httpClient.delete("/tenant/user-groups/" + userGroupId, java.util.Map.of(), null, (Class<Map<String, Object>>) (Class<?>) Map.class, true);
    }

    /** List Tenant User Group Members */
    public PaginatedList<UserGroupMember> listTenantUserGroupMembers(String userGroupId, ListTenantUserGroupMembersQuery query) {
        return httpClient.get("/tenant/user-groups/" + userGroupId + "/members", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<UserGroupMember>>() {});
    }

    /** Add Tenant User Group Members */
    @SuppressWarnings("unchecked")
    public Map<String, Object> addTenantUserGroupMembers(String userGroupId, AddTenantUserGroupMembersRequest body) {
        return httpClient.post("/tenant/user-groups/" + userGroupId + "/members", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, true);
    }

    /** Remove Tenant User Group Members */
    @SuppressWarnings("unchecked")
    public Map<String, Object> removeTenantUserGroupMembers(String userGroupId, RemoveTenantUserGroupMembersRequest body) {
        return httpClient.delete("/tenant/user-groups/" + userGroupId + "/members", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, true);
    }

    /** Get Org */
    public GetOrgResponse getOrg(String orgId) {
        return httpClient.get("/tenant/orgs/" + orgId, java.util.Map.of(), GetOrgResponse.class);
    }

    /** Update Org */
    public UpdateOrgResponse updateOrg(String orgId, UpdateOrgRequest body) {
        return httpClient.put("/tenant/orgs/" + orgId, java.util.Map.of(), body, UpdateOrgResponse.class, true);
    }

    /** Update Org Status */
    @SuppressWarnings("unchecked")
    public Map<String, Object> updateOrgStatus(String orgId, UpdateOrgStatusRequest body) {
        return httpClient.put("/tenant/orgs/" + orgId + "/status", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, true);
    }
}
