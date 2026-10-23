package co.dfns.sdk.tenant;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.tenant.model.*;
import java.util.Map;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedTenantClient {
    private final DfnsHttpClient httpClient;

    public DelegatedTenantClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Delegated signing step 1 for Assign Tenant Permission: returns the challenge to sign out-of-band. */
    public UserActionChallenge assignTenantPermissionInit(String permissionId, AssignTenantPermissionRequest body) {
        return httpClient.createUserActionChallenge("POST", "/tenant/permissions/" + permissionId + "/assign", body);
    }

    /** Delegated signing step 2 for Assign Tenant Permission: submits the signed challenge and issues the request. */
    public Object assignTenantPermissionComplete(String permissionId, AssignTenantPermissionRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/tenant/permissions/" + permissionId + "/assign", java.util.Map.of(), body, Object.class, userAction);
    }

    /** Delegated signing step 1 for Revoke Tenant Permission: returns the challenge to sign out-of-band. */
    public UserActionChallenge revokeTenantPermissionInit(String permissionId, RevokeTenantPermissionRequest body) {
        return httpClient.createUserActionChallenge("POST", "/tenant/permissions/" + permissionId + "/revoke", body);
    }

    /** Delegated signing step 2 for Revoke Tenant Permission: submits the signed challenge and issues the request. */
    public Object revokeTenantPermissionComplete(String permissionId, RevokeTenantPermissionRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/tenant/permissions/" + permissionId + "/revoke", java.util.Map.of(), body, Object.class, userAction);
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

    /** Delegated signing step 1 for Create Tenant User: returns the challenge to sign out-of-band. */
    public UserActionChallenge createTenantUserInit(CreateTenantUserRequest body) {
        return httpClient.createUserActionChallenge("POST", "/tenant/users", body);
    }

    /** Delegated signing step 2 for Create Tenant User: submits the signed challenge and issues the request. */
    public TenantUser createTenantUserComplete(CreateTenantUserRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/tenant/users", java.util.Map.of(), body, TenantUser.class, userAction);
    }

    /** Get Tenant User */
    public TenantUser getTenantUser(String userId) {
        return httpClient.get("/tenant/users/" + userId, java.util.Map.of(), TenantUser.class);
    }

    /** Delegated signing step 1 for Update Tenant User: returns the challenge to sign out-of-band. */
    public UserActionChallenge updateTenantUserInit(String userId, UpdateTenantUserRequest body) {
        return httpClient.createUserActionChallenge("PUT", "/tenant/users/" + userId, body);
    }

    /** Delegated signing step 2 for Update Tenant User: submits the signed challenge and issues the request. */
    @SuppressWarnings("unchecked")
    public Map<String, Object> updateTenantUserComplete(String userId, UpdateTenantUserRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/tenant/users/" + userId, java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, userAction);
    }

    /** Delegated signing step 1 for Delete Tenant User: returns the challenge to sign out-of-band. */
    public UserActionChallenge deleteTenantUserInit(String userId) {
        return httpClient.createUserActionChallenge("DELETE", "/tenant/users/" + userId, null);
    }

    /** Delegated signing step 2 for Delete Tenant User: submits the signed challenge and issues the request. */
    @SuppressWarnings("unchecked")
    public Map<String, Object> deleteTenantUserComplete(String userId, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("DELETE", "/tenant/users/" + userId, java.util.Map.of(), null, (Class<Map<String, Object>>) (Class<?>) Map.class, userAction);
    }

    /** List Orgs */
    public ListOrgsResponse listOrgs(ListOrgsQuery query) {
        return httpClient.get("/tenant/orgs", query.toMap(), ListOrgsResponse.class);
    }

    /** Delegated signing step 1 for Create Org: returns the challenge to sign out-of-band. */
    public UserActionChallenge createOrgInit(CreateOrgRequest body) {
        return httpClient.createUserActionChallenge("POST", "/tenant/orgs", body);
    }

    /** Delegated signing step 2 for Create Org: submits the signed challenge and issues the request. */
    public CreateOrgResponse createOrgComplete(CreateOrgRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/tenant/orgs", java.util.Map.of(), body, CreateOrgResponse.class, userAction);
    }

    /** List Tenant User Groups */
    public PaginatedList<UserGroup> listTenantUserGroups(ListTenantUserGroupsQuery query) {
        return httpClient.get("/tenant/user-groups", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<UserGroup>>() {});
    }

    /** Delegated signing step 1 for Create Tenant User Group: returns the challenge to sign out-of-band. */
    public UserActionChallenge createTenantUserGroupInit(CreateTenantUserGroupRequest body) {
        return httpClient.createUserActionChallenge("POST", "/tenant/user-groups", body);
    }

    /** Delegated signing step 2 for Create Tenant User Group: submits the signed challenge and issues the request. */
    public UserGroup createTenantUserGroupComplete(CreateTenantUserGroupRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/tenant/user-groups", java.util.Map.of(), body, UserGroup.class, userAction);
    }

    /** Get Tenant User Group */
    public UserGroup getTenantUserGroup(String userGroupId) {
        return httpClient.get("/tenant/user-groups/" + userGroupId, java.util.Map.of(), UserGroup.class);
    }

    /** Delegated signing step 1 for Update Tenant User Group: returns the challenge to sign out-of-band. */
    public UserActionChallenge updateTenantUserGroupInit(String userGroupId, UpdateTenantUserGroupRequest body) {
        return httpClient.createUserActionChallenge("PUT", "/tenant/user-groups/" + userGroupId, body);
    }

    /** Delegated signing step 2 for Update Tenant User Group: submits the signed challenge and issues the request. */
    public UserGroup updateTenantUserGroupComplete(String userGroupId, UpdateTenantUserGroupRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/tenant/user-groups/" + userGroupId, java.util.Map.of(), body, UserGroup.class, userAction);
    }

    /** Delegated signing step 1 for Delete Tenant User Group: returns the challenge to sign out-of-band. */
    public UserActionChallenge deleteTenantUserGroupInit(String userGroupId) {
        return httpClient.createUserActionChallenge("DELETE", "/tenant/user-groups/" + userGroupId, null);
    }

    /** Delegated signing step 2 for Delete Tenant User Group: submits the signed challenge and issues the request. */
    @SuppressWarnings("unchecked")
    public Map<String, Object> deleteTenantUserGroupComplete(String userGroupId, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("DELETE", "/tenant/user-groups/" + userGroupId, java.util.Map.of(), null, (Class<Map<String, Object>>) (Class<?>) Map.class, userAction);
    }

    /** List Tenant User Group Members */
    public PaginatedList<UserGroupMember> listTenantUserGroupMembers(String userGroupId, ListTenantUserGroupMembersQuery query) {
        return httpClient.get("/tenant/user-groups/" + userGroupId + "/members", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<UserGroupMember>>() {});
    }

    /** Delegated signing step 1 for Add Tenant User Group Members: returns the challenge to sign out-of-band. */
    public UserActionChallenge addTenantUserGroupMembersInit(String userGroupId, AddTenantUserGroupMembersRequest body) {
        return httpClient.createUserActionChallenge("POST", "/tenant/user-groups/" + userGroupId + "/members", body);
    }

    /** Delegated signing step 2 for Add Tenant User Group Members: submits the signed challenge and issues the request. */
    @SuppressWarnings("unchecked")
    public Map<String, Object> addTenantUserGroupMembersComplete(String userGroupId, AddTenantUserGroupMembersRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/tenant/user-groups/" + userGroupId + "/members", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, userAction);
    }

    /** Delegated signing step 1 for Remove Tenant User Group Members: returns the challenge to sign out-of-band. */
    public UserActionChallenge removeTenantUserGroupMembersInit(String userGroupId, RemoveTenantUserGroupMembersRequest body) {
        return httpClient.createUserActionChallenge("DELETE", "/tenant/user-groups/" + userGroupId + "/members", body);
    }

    /** Delegated signing step 2 for Remove Tenant User Group Members: submits the signed challenge and issues the request. */
    @SuppressWarnings("unchecked")
    public Map<String, Object> removeTenantUserGroupMembersComplete(String userGroupId, RemoveTenantUserGroupMembersRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("DELETE", "/tenant/user-groups/" + userGroupId + "/members", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, userAction);
    }

    /** Get Org */
    public GetOrgResponse getOrg(String orgId) {
        return httpClient.get("/tenant/orgs/" + orgId, java.util.Map.of(), GetOrgResponse.class);
    }

    /** Delegated signing step 1 for Update Org: returns the challenge to sign out-of-band. */
    public UserActionChallenge updateOrgInit(String orgId, UpdateOrgRequest body) {
        return httpClient.createUserActionChallenge("PUT", "/tenant/orgs/" + orgId, body);
    }

    /** Delegated signing step 2 for Update Org: submits the signed challenge and issues the request. */
    public UpdateOrgResponse updateOrgComplete(String orgId, UpdateOrgRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/tenant/orgs/" + orgId, java.util.Map.of(), body, UpdateOrgResponse.class, userAction);
    }

    /** Delegated signing step 1 for Update Org Status: returns the challenge to sign out-of-band. */
    public UserActionChallenge updateOrgStatusInit(String orgId, UpdateOrgStatusRequest body) {
        return httpClient.createUserActionChallenge("PUT", "/tenant/orgs/" + orgId + "/status", body);
    }

    /** Delegated signing step 2 for Update Org Status: submits the signed challenge and issues the request. */
    @SuppressWarnings("unchecked")
    public Map<String, Object> updateOrgStatusComplete(String orgId, UpdateOrgStatusRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/tenant/orgs/" + orgId + "/status", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, userAction);
    }
}
