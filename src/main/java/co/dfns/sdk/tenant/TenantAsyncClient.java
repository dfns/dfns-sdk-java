package co.dfns.sdk.tenant;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.tenant.model.*;
import java.util.Map;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.concurrent.CompletableFuture;

public class TenantAsyncClient {
    private final DfnsHttpClient httpClient;

    public TenantAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Assign Tenant Permission */
    public CompletableFuture<Object> assignTenantPermission(String permissionId, AssignTenantPermissionRequest body) {
        return httpClient.postAsync("/tenant/permissions/" + permissionId + "/assign", java.util.Map.of(), body, Object.class, true);
    }

    /** Revoke Tenant Permission */
    public CompletableFuture<Object> revokeTenantPermission(String permissionId, RevokeTenantPermissionRequest body) {
        return httpClient.postAsync("/tenant/permissions/" + permissionId + "/revoke", java.util.Map.of(), body, Object.class, true);
    }

    /** Get Tenant Permission */
    public CompletableFuture<Permission> getTenantPermission(String permissionId) {
        return httpClient.getAsync("/tenant/permissions/" + permissionId, java.util.Map.of(), Permission.class);
    }

    /** List Tenant Permissions */
    public CompletableFuture<PaginatedList<Permission>> listTenantPermissions(ListTenantPermissionsQuery query) {
        return httpClient.getAsync("/tenant/permissions", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Permission>>() {});
    }

    /** List Tenant Users */
    public CompletableFuture<PaginatedList<TenantUser>> listTenantUsers(ListTenantUsersQuery query) {
        return httpClient.getAsync("/tenant/users", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<TenantUser>>() {});
    }

    /** Create Tenant User */
    public CompletableFuture<TenantUser> createTenantUser(CreateTenantUserRequest body) {
        return httpClient.postAsync("/tenant/users", java.util.Map.of(), body, TenantUser.class, true);
    }

    /** Get Tenant User */
    public CompletableFuture<TenantUser> getTenantUser(String userId) {
        return httpClient.getAsync("/tenant/users/" + userId, java.util.Map.of(), TenantUser.class);
    }

    /** Update Tenant User */
    @SuppressWarnings("unchecked")
    public CompletableFuture<Map<String, Object>> updateTenantUser(String userId, UpdateTenantUserRequest body) {
        return httpClient.putAsync("/tenant/users/" + userId, java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, true);
    }

    /** Delete Tenant User */
    @SuppressWarnings("unchecked")
    public CompletableFuture<Map<String, Object>> deleteTenantUser(String userId) {
        return httpClient.deleteAsync("/tenant/users/" + userId, java.util.Map.of(), null, (Class<Map<String, Object>>) (Class<?>) Map.class, true);
    }

    /** List Orgs */
    public CompletableFuture<ListOrgsResponse> listOrgs(ListOrgsQuery query) {
        return httpClient.getAsync("/tenant/orgs", query.toMap(), ListOrgsResponse.class);
    }

    /** Create Org */
    public CompletableFuture<CreateOrgResponse> createOrg(CreateOrgRequest body) {
        return httpClient.postAsync("/tenant/orgs", java.util.Map.of(), body, CreateOrgResponse.class, true);
    }

    /** List Tenant User Groups */
    public CompletableFuture<PaginatedList<UserGroup>> listTenantUserGroups(ListTenantUserGroupsQuery query) {
        return httpClient.getAsync("/tenant/user-groups", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<UserGroup>>() {});
    }

    /** Create Tenant User Group */
    public CompletableFuture<UserGroup> createTenantUserGroup(CreateTenantUserGroupRequest body) {
        return httpClient.postAsync("/tenant/user-groups", java.util.Map.of(), body, UserGroup.class, true);
    }

    /** Get Tenant User Group */
    public CompletableFuture<UserGroup> getTenantUserGroup(String userGroupId) {
        return httpClient.getAsync("/tenant/user-groups/" + userGroupId, java.util.Map.of(), UserGroup.class);
    }

    /** Update Tenant User Group */
    public CompletableFuture<UserGroup> updateTenantUserGroup(String userGroupId, UpdateTenantUserGroupRequest body) {
        return httpClient.putAsync("/tenant/user-groups/" + userGroupId, java.util.Map.of(), body, UserGroup.class, true);
    }

    /** Delete Tenant User Group */
    @SuppressWarnings("unchecked")
    public CompletableFuture<Map<String, Object>> deleteTenantUserGroup(String userGroupId) {
        return httpClient.deleteAsync("/tenant/user-groups/" + userGroupId, java.util.Map.of(), null, (Class<Map<String, Object>>) (Class<?>) Map.class, true);
    }

    /** List Tenant User Group Members */
    public CompletableFuture<PaginatedList<UserGroupMember>> listTenantUserGroupMembers(String userGroupId, ListTenantUserGroupMembersQuery query) {
        return httpClient.getAsync("/tenant/user-groups/" + userGroupId + "/members", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<UserGroupMember>>() {});
    }

    /** Add Tenant User Group Members */
    @SuppressWarnings("unchecked")
    public CompletableFuture<Map<String, Object>> addTenantUserGroupMembers(String userGroupId, AddTenantUserGroupMembersRequest body) {
        return httpClient.postAsync("/tenant/user-groups/" + userGroupId + "/members", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, true);
    }

    /** Remove Tenant User Group Members */
    @SuppressWarnings("unchecked")
    public CompletableFuture<Map<String, Object>> removeTenantUserGroupMembers(String userGroupId, RemoveTenantUserGroupMembersRequest body) {
        return httpClient.deleteAsync("/tenant/user-groups/" + userGroupId + "/members", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, true);
    }

    /** Get Org */
    public CompletableFuture<GetOrgResponse> getOrg(String orgId) {
        return httpClient.getAsync("/tenant/orgs/" + orgId, java.util.Map.of(), GetOrgResponse.class);
    }

    /** Update Org */
    public CompletableFuture<UpdateOrgResponse> updateOrg(String orgId, UpdateOrgRequest body) {
        return httpClient.putAsync("/tenant/orgs/" + orgId, java.util.Map.of(), body, UpdateOrgResponse.class, true);
    }

    /** Update Org Status */
    @SuppressWarnings("unchecked")
    public CompletableFuture<Map<String, Object>> updateOrgStatus(String orgId, UpdateOrgStatusRequest body) {
        return httpClient.putAsync("/tenant/orgs/" + orgId + "/status", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, true);
    }
}
