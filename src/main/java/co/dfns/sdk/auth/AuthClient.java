package co.dfns.sdk.auth;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.auth.model.*;
import java.util.Map;
import java.util.List;
import co.dfns.sdk.PaginatedList;

public class AuthClient {
    private final DfnsHttpClient httpClient;

    public AuthClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Create User Action Signature */
    public CreateUserActionSignatureResponse createUserActionSignature(CreateUserActionSignatureRequest body) {
        return httpClient.post("/auth/action", java.util.Map.of(), body, CreateUserActionSignatureResponse.class, false);
    }

    /** Create User Action Challenge */
    public CreateUserActionChallengeResponse createUserActionChallenge(CreateUserActionChallengeRequest body) {
        return httpClient.post("/auth/action/init", java.util.Map.of(), body, CreateUserActionChallengeResponse.class, false);
    }

    /** List Audit Logs */
    public Object listAuditLogs(ListAuditLogsQuery query) {
        return httpClient.get("/auth/action/logs", query.toMap(), Object.class);
    }

    /** Get Audit Log */
    public AuditLog getAuditLog(Object id) {
        return httpClient.get("/auth/action/logs/" + id, java.util.Map.of(), AuditLog.class);
    }

    /** List Applications */
    @Deprecated
    public ListApplicationsResponse listApplications() {
        return httpClient.get("/auth/apps", java.util.Map.of(), ListApplicationsResponse.class);
    }

    /** Get Application */
    @Deprecated
    public GetApplicationResponse getApplication(String appId) {
        return httpClient.get("/auth/apps/" + appId, java.util.Map.of(), GetApplicationResponse.class);
    }

    /** List Credentials */
    public ListCredentialsResponse listCredentials() {
        return httpClient.get("/auth/credentials", java.util.Map.of(), ListCredentialsResponse.class);
    }

    /** Create Credential */
    public Credential createCredential(Object body) {
        return httpClient.post("/auth/credentials", java.util.Map.of(), body, Credential.class, true);
    }

    /** Create Credential Challenge */
    public Object createCredentialChallenge(CreateCredentialChallengeRequest body) {
        return httpClient.post("/auth/credentials/init", java.util.Map.of(), body, Object.class, false);
    }

    /** Activate Credential */
    public ActivateCredentialResponse activateCredential(ActivateCredentialRequest body) {
        return httpClient.put("/auth/credentials/activate", java.util.Map.of(), body, ActivateCredentialResponse.class, true);
    }

    /** Delete Credential */
    @SuppressWarnings("unchecked")
    public Map<String, Object> deleteCredential(String credentialUuid) {
        return httpClient.delete("/auth/credentials/" + credentialUuid, java.util.Map.of(), null, (Class<Map<String, Object>>) (Class<?>) Map.class, true);
    }

    /** Deactivate Credential */
    public DeactivateCredentialResponse deactivateCredential(DeactivateCredentialRequest body) {
        return httpClient.put("/auth/credentials/deactivate", java.util.Map.of(), body, DeactivateCredentialResponse.class, true);
    }

    /** Create Credential Code */
    public CreateCredentialCodeResponse createCredentialCode(CreateCredentialCodeRequest body) {
        return httpClient.post("/auth/credentials/code", java.util.Map.of(), body, CreateCredentialCodeResponse.class, true);
    }

    /** Create Credential Challenge With Code */
    public Object createCredentialChallengeWithCode(CreateCredentialChallengeWithCodeRequest body) {
        return httpClient.post("/auth/credentials/code/init", java.util.Map.of(), body, Object.class, false);
    }

    /** Create Credential With Code */
    public Credential createCredentialWithCode(Object body) {
        return httpClient.post("/auth/credentials/code/verify", java.util.Map.of(), body, Credential.class, false);
    }

    /** Create Login Challenge */
    public CreateLoginChallengeResponse createLoginChallenge(CreateLoginChallengeRequest body) {
        return httpClient.post("/auth/login/init", java.util.Map.of(), body, CreateLoginChallengeResponse.class, false);
    }

    /** Delegated Login */
    public DelegatedLoginResponse delegatedLogin(DelegatedLoginRequest body) {
        return httpClient.post("/auth/login/delegated", java.util.Map.of(), body, DelegatedLoginResponse.class, true);
    }

    /** Complete User Login */
    public Object completeUserLogin(CompleteUserLoginRequest body) {
        return httpClient.post("/auth/login", java.util.Map.of(), body, Object.class, false);
    }

    /** Logout */
    public LogoutResponse logout(LogoutRequest body) {
        return httpClient.put("/auth/logout", java.util.Map.of(), body, LogoutResponse.class, false);
    }

    /** Complete OIDC Login */
    public Object completeOidcLogin(CompleteOidcLoginRequest body) {
        return httpClient.post("/auth/login/oidc", java.util.Map.of(), body, Object.class, false);
    }

    /** Initiate OIDC Login */
    public InitiateOidcLoginResponse initiateOidcLogin(InitiateOidcLoginRequest body) {
        return httpClient.post("/auth/login/oidc/init", java.util.Map.of(), body, InitiateOidcLoginResponse.class, false);
    }

    /** Send Login Code */
    public SendLoginCodeResponse sendLoginCode(SendLoginCodeRequest body) {
        return httpClient.post("/auth/login/code", java.util.Map.of(), body, SendLoginCodeResponse.class, false);
    }

    /** Social Login */
    public SocialLoginResponse socialLogin(SocialLoginRequest body) {
        return httpClient.post("/auth/login/social", java.util.Map.of(), body, SocialLoginResponse.class, false);
    }

    /** Complete SSO Login */
    public CompleteSsoLoginResponse completeSsoLogin(CompleteSsoLoginRequest body) {
        return httpClient.post("/auth/login/sso", java.util.Map.of(), body, CompleteSsoLoginResponse.class, false);
    }

    /** Initiate SSO Login */
    public InitiateSsoLoginResponse initiateSsoLogin(InitiateSsoLoginRequest body) {
        return httpClient.post("/auth/login/sso/init", java.util.Map.of(), body, InitiateSsoLoginResponse.class, false);
    }

    /** Exchange Access Token */
    public ExchangeAccessTokenResponse exchangeAccessToken(ExchangeAccessTokenRequest body) {
        return httpClient.post("/auth/tokens", java.util.Map.of(), body, ExchangeAccessTokenResponse.class, false);
    }

    /** List Personal Access Tokens */
    public ListPersonalAccessTokensResponse listPersonalAccessTokens() {
        return httpClient.get("/auth/pats", java.util.Map.of(), ListPersonalAccessTokensResponse.class);
    }

    /** Create Personal Access Token */
    public CreatePersonalAccessTokenResponse createPersonalAccessToken(CreatePersonalAccessTokenRequest body) {
        return httpClient.post("/auth/pats", java.util.Map.of(), body, CreatePersonalAccessTokenResponse.class, true);
    }

    /** Get Personal Access Token */
    public PersonalAccessToken getPersonalAccessToken(String tokenId) {
        return httpClient.get("/auth/pats/" + tokenId, java.util.Map.of(), PersonalAccessToken.class);
    }

    /** Update Personal Access Token */
    public PersonalAccessToken updatePersonalAccessToken(String tokenId, UpdatePersonalAccessTokenRequest body) {
        return httpClient.put("/auth/pats/" + tokenId, java.util.Map.of(), body, PersonalAccessToken.class, true);
    }

    /** Delete Personal Access Token */
    public PersonalAccessToken deletePersonalAccessToken(String tokenId) {
        return httpClient.delete("/auth/pats/" + tokenId, java.util.Map.of(), null, PersonalAccessToken.class, true);
    }

    /** Activate Personal Access Token */
    public PersonalAccessToken activatePersonalAccessToken(String tokenId) {
        return httpClient.put("/auth/pats/" + tokenId + "/activate", java.util.Map.of(), null, PersonalAccessToken.class, true);
    }

    /** Deactivate Personal Access Token */
    public PersonalAccessToken deactivatePersonalAccessToken(String tokenId) {
        return httpClient.put("/auth/pats/" + tokenId + "/deactivate", java.util.Map.of(), null, PersonalAccessToken.class, true);
    }

    /** Create Delegated Recovery Challenge */
    public CreateDelegatedRecoveryChallengeResponse createDelegatedRecoveryChallenge(CreateDelegatedRecoveryChallengeRequest body) {
        return httpClient.post("/auth/recover/user/delegated", java.util.Map.of(), body, CreateDelegatedRecoveryChallengeResponse.class, true);
    }

    /** Recover User */
    public RecoverUserResponse recoverUser(RecoverUserRequest body) {
        return httpClient.post("/auth/recover/user", java.util.Map.of(), body, RecoverUserResponse.class, false);
    }

    /** Create Recovery Challenge */
    public CreateRecoveryChallengeResponse createRecoveryChallenge(CreateRecoveryChallengeRequest body) {
        return httpClient.post("/auth/recover/user/init", java.util.Map.of(), body, CreateRecoveryChallengeResponse.class, false);
    }

    /** Send Recovery Code Email */
    public SendRecoveryCodeEmailResponse sendRecoveryCodeEmail(SendRecoveryCodeEmailRequest body) {
        return httpClient.post("/auth/recover/user/code", java.util.Map.of(), body, SendRecoveryCodeEmailResponse.class, false);
    }

    /** Create Delegated Registration Challenge */
    public CreateDelegatedRegistrationChallengeResponse createDelegatedRegistrationChallenge(CreateDelegatedRegistrationChallengeRequest body) {
        return httpClient.post("/auth/registration/delegated", java.util.Map.of(), body, CreateDelegatedRegistrationChallengeResponse.class, true);
    }

    /** Create Registration Challenge */
    public CreateRegistrationChallengeResponse createRegistrationChallenge(CreateRegistrationChallengeRequest body) {
        return httpClient.post("/auth/registration/init", java.util.Map.of(), body, CreateRegistrationChallengeResponse.class, false);
    }

    /** Create Social Registration Challenge */
    public CreateSocialRegistrationChallengeResponse createSocialRegistrationChallenge(CreateSocialRegistrationChallengeRequest body) {
        return httpClient.post("/auth/registration/social", java.util.Map.of(), body, CreateSocialRegistrationChallengeResponse.class, false);
    }

    /** Complete User Registration */
    public CompleteUserRegistrationResponse completeUserRegistration(CompleteUserRegistrationRequest body) {
        return httpClient.post("/auth/registration", java.util.Map.of(), body, CompleteUserRegistrationResponse.class, false);
    }

    /** Complete End User Registration with Wallets */
    public CompleteEndUserRegistrationWithWalletsResponse completeEndUserRegistrationWithWallets(CompleteEndUserRegistrationWithWalletsRequest body) {
        return httpClient.post("/auth/registration/enduser", java.util.Map.of(), body, CompleteEndUserRegistrationWithWalletsResponse.class, false);
    }

    /** Resend Registration Code */
    public ResendRegistrationCodeResponse resendRegistrationCode(ResendRegistrationCodeRequest body) {
        return httpClient.put("/auth/registration/code", java.util.Map.of(), body, ResendRegistrationCodeResponse.class, false);
    }

    /** List Service Accounts */
    public ListServiceAccountsResponse listServiceAccounts() {
        return httpClient.get("/auth/service-accounts", java.util.Map.of(), ListServiceAccountsResponse.class);
    }

    /** Create Service Account */
    public CreateServiceAccountResponse createServiceAccount(CreateServiceAccountRequest body) {
        return httpClient.post("/auth/service-accounts", java.util.Map.of(), body, CreateServiceAccountResponse.class, true);
    }

    /** Get Service Account */
    public GetServiceAccountResponse getServiceAccount(String serviceAccountId) {
        return httpClient.get("/auth/service-accounts/" + serviceAccountId, java.util.Map.of(), GetServiceAccountResponse.class);
    }

    /** Update Service Account */
    public UpdateServiceAccountResponse updateServiceAccount(String serviceAccountId, UpdateServiceAccountRequest body) {
        return httpClient.put("/auth/service-accounts/" + serviceAccountId, java.util.Map.of(), body, UpdateServiceAccountResponse.class, true);
    }

    /** Delete Service Account */
    public DeleteServiceAccountResponse deleteServiceAccount(String serviceAccountId, DeleteServiceAccountQuery query) {
        return httpClient.delete("/auth/service-accounts/" + serviceAccountId, query.toMap(), null, DeleteServiceAccountResponse.class, true);
    }

    /** Activate Service Account */
    public ActivateServiceAccountResponse activateServiceAccount(String serviceAccountId) {
        return httpClient.put("/auth/service-accounts/" + serviceAccountId + "/activate", java.util.Map.of(), null, ActivateServiceAccountResponse.class, true);
    }

    /** Deactivate Service Account */
    public DeactivateServiceAccountResponse deactivateServiceAccount(String serviceAccountId, DeactivateServiceAccountRequest body) {
        return httpClient.put("/auth/service-accounts/" + serviceAccountId + "/deactivate", java.util.Map.of(), body, DeactivateServiceAccountResponse.class, true);
    }

    /** Activate User */
    public User activateUser(String userId) {
        return httpClient.put("/auth/users/" + userId + "/activate", java.util.Map.of(), null, User.class, true);
    }

    /** Deactivate User */
    public User deactivateUser(String userId) {
        return httpClient.put("/auth/users/" + userId + "/deactivate", java.util.Map.of(), null, User.class, true);
    }

    /** Get User */
    public User getUser(String userId) {
        return httpClient.get("/auth/users/" + userId, java.util.Map.of(), User.class);
    }

    /** Update User */
    public User updateUser(String userId, UpdateUserRequest body) {
        return httpClient.put("/auth/users/" + userId, java.util.Map.of(), body, User.class, true);
    }

    /** Delete User */
    public User deleteUser(String userId) {
        return httpClient.delete("/auth/users/" + userId, java.util.Map.of(), null, User.class, true);
    }

    /** List Users */
    public PaginatedList<User> listUsers(ListUsersQuery query) {
        return httpClient.get("/auth/users", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<User>>() {});
    }

    /** Create User */
    public User createUser(CreateUserRequest body) {
        return httpClient.post("/auth/users", java.util.Map.of(), body, User.class, true);
    }

    /** Invite Tenant User */
    @SuppressWarnings("unchecked")
    public Map<String, Object> inviteTenantUser(InviteTenantUserRequest body) {
        return httpClient.post("/auth/users/invite", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, true);
    }
}
