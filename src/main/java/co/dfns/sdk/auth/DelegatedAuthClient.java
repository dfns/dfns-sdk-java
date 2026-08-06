package co.dfns.sdk.auth;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.auth.model.*;
import java.util.Map;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedAuthClient {
    private final DfnsHttpClient httpClient;

    public DelegatedAuthClient(DfnsHttpClient httpClient) {
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

    /** Delegated signing step 1 for Create Credential: returns the challenge to sign out-of-band. */
    public UserActionChallenge createCredentialInit(Object body) {
        return httpClient.createUserActionChallenge("POST", "/auth/credentials", body);
    }

    /** Delegated signing step 2 for Create Credential: submits the signed challenge and issues the request. */
    public Credential createCredentialComplete(Object body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/auth/credentials", java.util.Map.of(), body, Credential.class, userAction);
    }

    /** Create Credential Challenge */
    public Object createCredentialChallenge(CreateCredentialChallengeRequest body) {
        return httpClient.post("/auth/credentials/init", java.util.Map.of(), body, Object.class, false);
    }

    /** Delegated signing step 1 for Activate Credential: returns the challenge to sign out-of-band. */
    public UserActionChallenge activateCredentialInit(ActivateCredentialRequest body) {
        return httpClient.createUserActionChallenge("PUT", "/auth/credentials/activate", body);
    }

    /** Delegated signing step 2 for Activate Credential: submits the signed challenge and issues the request. */
    public ActivateCredentialResponse activateCredentialComplete(ActivateCredentialRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/auth/credentials/activate", java.util.Map.of(), body, ActivateCredentialResponse.class, userAction);
    }

    /** Delegated signing step 1 for Delete Credential: returns the challenge to sign out-of-band. */
    public UserActionChallenge deleteCredentialInit(String credentialUuid) {
        return httpClient.createUserActionChallenge("DELETE", "/auth/credentials/" + credentialUuid, null);
    }

    /** Delegated signing step 2 for Delete Credential: submits the signed challenge and issues the request. */
    @SuppressWarnings("unchecked")
    public Map<String, Object> deleteCredentialComplete(String credentialUuid, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("DELETE", "/auth/credentials/" + credentialUuid, java.util.Map.of(), null, (Class<Map<String, Object>>) (Class<?>) Map.class, userAction);
    }

    /** Delegated signing step 1 for Deactivate Credential: returns the challenge to sign out-of-band. */
    public UserActionChallenge deactivateCredentialInit(DeactivateCredentialRequest body) {
        return httpClient.createUserActionChallenge("PUT", "/auth/credentials/deactivate", body);
    }

    /** Delegated signing step 2 for Deactivate Credential: submits the signed challenge and issues the request. */
    public DeactivateCredentialResponse deactivateCredentialComplete(DeactivateCredentialRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/auth/credentials/deactivate", java.util.Map.of(), body, DeactivateCredentialResponse.class, userAction);
    }

    /** Delegated signing step 1 for Create Credential Code: returns the challenge to sign out-of-band. */
    public UserActionChallenge createCredentialCodeInit(CreateCredentialCodeRequest body) {
        return httpClient.createUserActionChallenge("POST", "/auth/credentials/code", body);
    }

    /** Delegated signing step 2 for Create Credential Code: submits the signed challenge and issues the request. */
    public CreateCredentialCodeResponse createCredentialCodeComplete(CreateCredentialCodeRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/auth/credentials/code", java.util.Map.of(), body, CreateCredentialCodeResponse.class, userAction);
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

    /** Delegated signing step 1 for Delegated Login: returns the challenge to sign out-of-band. */
    public UserActionChallenge delegatedLoginInit(DelegatedLoginRequest body) {
        return httpClient.createUserActionChallenge("POST", "/auth/login/delegated", body);
    }

    /** Delegated signing step 2 for Delegated Login: submits the signed challenge and issues the request. */
    public DelegatedLoginResponse delegatedLoginComplete(DelegatedLoginRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/auth/login/delegated", java.util.Map.of(), body, DelegatedLoginResponse.class, userAction);
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

    /** Delegated signing step 1 for Create Personal Access Token: returns the challenge to sign out-of-band. */
    public UserActionChallenge createPersonalAccessTokenInit(CreatePersonalAccessTokenRequest body) {
        return httpClient.createUserActionChallenge("POST", "/auth/pats", body);
    }

    /** Delegated signing step 2 for Create Personal Access Token: submits the signed challenge and issues the request. */
    public CreatePersonalAccessTokenResponse createPersonalAccessTokenComplete(CreatePersonalAccessTokenRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/auth/pats", java.util.Map.of(), body, CreatePersonalAccessTokenResponse.class, userAction);
    }

    /** Get Personal Access Token */
    public PersonalAccessToken getPersonalAccessToken(String tokenId) {
        return httpClient.get("/auth/pats/" + tokenId, java.util.Map.of(), PersonalAccessToken.class);
    }

    /** Delegated signing step 1 for Update Personal Access Token: returns the challenge to sign out-of-band. */
    public UserActionChallenge updatePersonalAccessTokenInit(String tokenId, UpdatePersonalAccessTokenRequest body) {
        return httpClient.createUserActionChallenge("PUT", "/auth/pats/" + tokenId, body);
    }

    /** Delegated signing step 2 for Update Personal Access Token: submits the signed challenge and issues the request. */
    public PersonalAccessToken updatePersonalAccessTokenComplete(String tokenId, UpdatePersonalAccessTokenRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/auth/pats/" + tokenId, java.util.Map.of(), body, PersonalAccessToken.class, userAction);
    }

    /** Delegated signing step 1 for Delete Personal Access Token: returns the challenge to sign out-of-band. */
    public UserActionChallenge deletePersonalAccessTokenInit(String tokenId) {
        return httpClient.createUserActionChallenge("DELETE", "/auth/pats/" + tokenId, null);
    }

    /** Delegated signing step 2 for Delete Personal Access Token: submits the signed challenge and issues the request. */
    public PersonalAccessToken deletePersonalAccessTokenComplete(String tokenId, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("DELETE", "/auth/pats/" + tokenId, java.util.Map.of(), null, PersonalAccessToken.class, userAction);
    }

    /** Delegated signing step 1 for Activate Personal Access Token: returns the challenge to sign out-of-band. */
    public UserActionChallenge activatePersonalAccessTokenInit(String tokenId) {
        return httpClient.createUserActionChallenge("PUT", "/auth/pats/" + tokenId + "/activate", null);
    }

    /** Delegated signing step 2 for Activate Personal Access Token: submits the signed challenge and issues the request. */
    public PersonalAccessToken activatePersonalAccessTokenComplete(String tokenId, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/auth/pats/" + tokenId + "/activate", java.util.Map.of(), null, PersonalAccessToken.class, userAction);
    }

    /** Delegated signing step 1 for Deactivate Personal Access Token: returns the challenge to sign out-of-band. */
    public UserActionChallenge deactivatePersonalAccessTokenInit(String tokenId) {
        return httpClient.createUserActionChallenge("PUT", "/auth/pats/" + tokenId + "/deactivate", null);
    }

    /** Delegated signing step 2 for Deactivate Personal Access Token: submits the signed challenge and issues the request. */
    public PersonalAccessToken deactivatePersonalAccessTokenComplete(String tokenId, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/auth/pats/" + tokenId + "/deactivate", java.util.Map.of(), null, PersonalAccessToken.class, userAction);
    }

    /** Delegated signing step 1 for Create Delegated Recovery Challenge: returns the challenge to sign out-of-band. */
    public UserActionChallenge createDelegatedRecoveryChallengeInit(CreateDelegatedRecoveryChallengeRequest body) {
        return httpClient.createUserActionChallenge("POST", "/auth/recover/user/delegated", body);
    }

    /** Delegated signing step 2 for Create Delegated Recovery Challenge: submits the signed challenge and issues the request. */
    public CreateDelegatedRecoveryChallengeResponse createDelegatedRecoveryChallengeComplete(CreateDelegatedRecoveryChallengeRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/auth/recover/user/delegated", java.util.Map.of(), body, CreateDelegatedRecoveryChallengeResponse.class, userAction);
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

    /** Delegated signing step 1 for Create Delegated Registration Challenge: returns the challenge to sign out-of-band. */
    public UserActionChallenge createDelegatedRegistrationChallengeInit(CreateDelegatedRegistrationChallengeRequest body) {
        return httpClient.createUserActionChallenge("POST", "/auth/registration/delegated", body);
    }

    /** Delegated signing step 2 for Create Delegated Registration Challenge: submits the signed challenge and issues the request. */
    public CreateDelegatedRegistrationChallengeResponse createDelegatedRegistrationChallengeComplete(CreateDelegatedRegistrationChallengeRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/auth/registration/delegated", java.util.Map.of(), body, CreateDelegatedRegistrationChallengeResponse.class, userAction);
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

    /** Delegated signing step 1 for Create Service Account: returns the challenge to sign out-of-band. */
    public UserActionChallenge createServiceAccountInit(CreateServiceAccountRequest body) {
        return httpClient.createUserActionChallenge("POST", "/auth/service-accounts", body);
    }

    /** Delegated signing step 2 for Create Service Account: submits the signed challenge and issues the request. */
    public CreateServiceAccountResponse createServiceAccountComplete(CreateServiceAccountRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/auth/service-accounts", java.util.Map.of(), body, CreateServiceAccountResponse.class, userAction);
    }

    /** Get Service Account */
    public GetServiceAccountResponse getServiceAccount(String serviceAccountId) {
        return httpClient.get("/auth/service-accounts/" + serviceAccountId, java.util.Map.of(), GetServiceAccountResponse.class);
    }

    /** Delegated signing step 1 for Update Service Account: returns the challenge to sign out-of-band. */
    public UserActionChallenge updateServiceAccountInit(String serviceAccountId, UpdateServiceAccountRequest body) {
        return httpClient.createUserActionChallenge("PUT", "/auth/service-accounts/" + serviceAccountId, body);
    }

    /** Delegated signing step 2 for Update Service Account: submits the signed challenge and issues the request. */
    public UpdateServiceAccountResponse updateServiceAccountComplete(String serviceAccountId, UpdateServiceAccountRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/auth/service-accounts/" + serviceAccountId, java.util.Map.of(), body, UpdateServiceAccountResponse.class, userAction);
    }

    /** Delegated signing step 1 for Delete Service Account: returns the challenge to sign out-of-band. */
    public UserActionChallenge deleteServiceAccountInit(String serviceAccountId) {
        return httpClient.createUserActionChallenge("DELETE", "/auth/service-accounts/" + serviceAccountId, null);
    }

    /** Delegated signing step 2 for Delete Service Account: submits the signed challenge and issues the request. */
    public DeleteServiceAccountResponse deleteServiceAccountComplete(String serviceAccountId, DeleteServiceAccountQuery query, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("DELETE", "/auth/service-accounts/" + serviceAccountId, query.toMap(), null, DeleteServiceAccountResponse.class, userAction);
    }

    /** Delegated signing step 1 for Activate Service Account: returns the challenge to sign out-of-band. */
    public UserActionChallenge activateServiceAccountInit(String serviceAccountId) {
        return httpClient.createUserActionChallenge("PUT", "/auth/service-accounts/" + serviceAccountId + "/activate", null);
    }

    /** Delegated signing step 2 for Activate Service Account: submits the signed challenge and issues the request. */
    public ActivateServiceAccountResponse activateServiceAccountComplete(String serviceAccountId, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/auth/service-accounts/" + serviceAccountId + "/activate", java.util.Map.of(), null, ActivateServiceAccountResponse.class, userAction);
    }

    /** Delegated signing step 1 for Deactivate Service Account: returns the challenge to sign out-of-band. */
    public UserActionChallenge deactivateServiceAccountInit(String serviceAccountId, DeactivateServiceAccountRequest body) {
        return httpClient.createUserActionChallenge("PUT", "/auth/service-accounts/" + serviceAccountId + "/deactivate", body);
    }

    /** Delegated signing step 2 for Deactivate Service Account: submits the signed challenge and issues the request. */
    public DeactivateServiceAccountResponse deactivateServiceAccountComplete(String serviceAccountId, DeactivateServiceAccountRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/auth/service-accounts/" + serviceAccountId + "/deactivate", java.util.Map.of(), body, DeactivateServiceAccountResponse.class, userAction);
    }

    /** Delegated signing step 1 for Activate User: returns the challenge to sign out-of-band. */
    public UserActionChallenge activateUserInit(String userId) {
        return httpClient.createUserActionChallenge("PUT", "/auth/users/" + userId + "/activate", null);
    }

    /** Delegated signing step 2 for Activate User: submits the signed challenge and issues the request. */
    public User activateUserComplete(String userId, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/auth/users/" + userId + "/activate", java.util.Map.of(), null, User.class, userAction);
    }

    /** Delegated signing step 1 for Deactivate User: returns the challenge to sign out-of-band. */
    public UserActionChallenge deactivateUserInit(String userId) {
        return httpClient.createUserActionChallenge("PUT", "/auth/users/" + userId + "/deactivate", null);
    }

    /** Delegated signing step 2 for Deactivate User: submits the signed challenge and issues the request. */
    public User deactivateUserComplete(String userId, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/auth/users/" + userId + "/deactivate", java.util.Map.of(), null, User.class, userAction);
    }

    /** Get User */
    public User getUser(String userId) {
        return httpClient.get("/auth/users/" + userId, java.util.Map.of(), User.class);
    }

    /** Delegated signing step 1 for Update User: returns the challenge to sign out-of-band. */
    public UserActionChallenge updateUserInit(String userId, UpdateUserRequest body) {
        return httpClient.createUserActionChallenge("PUT", "/auth/users/" + userId, body);
    }

    /** Delegated signing step 2 for Update User: submits the signed challenge and issues the request. */
    public User updateUserComplete(String userId, UpdateUserRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/auth/users/" + userId, java.util.Map.of(), body, User.class, userAction);
    }

    /** Delegated signing step 1 for Delete User: returns the challenge to sign out-of-band. */
    public UserActionChallenge deleteUserInit(String userId) {
        return httpClient.createUserActionChallenge("DELETE", "/auth/users/" + userId, null);
    }

    /** Delegated signing step 2 for Delete User: submits the signed challenge and issues the request. */
    public User deleteUserComplete(String userId, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("DELETE", "/auth/users/" + userId, java.util.Map.of(), null, User.class, userAction);
    }

    /** List Users */
    public PaginatedList<User> listUsers(ListUsersQuery query) {
        return httpClient.get("/auth/users", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<User>>() {});
    }

    /** Delegated signing step 1 for Create User: returns the challenge to sign out-of-band. */
    public UserActionChallenge createUserInit(CreateUserRequest body) {
        return httpClient.createUserActionChallenge("POST", "/auth/users", body);
    }

    /** Delegated signing step 2 for Create User: submits the signed challenge and issues the request. */
    public User createUserComplete(CreateUserRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/auth/users", java.util.Map.of(), body, User.class, userAction);
    }

    /** Delegated signing step 1 for Invite Tenant User: returns the challenge to sign out-of-band. */
    public UserActionChallenge inviteTenantUserInit(InviteTenantUserRequest body) {
        return httpClient.createUserActionChallenge("POST", "/auth/users/invite", body);
    }

    /** Delegated signing step 2 for Invite Tenant User: submits the signed challenge and issues the request. */
    @SuppressWarnings("unchecked")
    public Map<String, Object> inviteTenantUserComplete(InviteTenantUserRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/auth/users/invite", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, userAction);
    }
}
