package co.dfns.sdk.auth;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.auth.model.*;
import java.util.Map;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.concurrent.CompletableFuture;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedAuthAsyncClient {
    private final DfnsHttpClient httpClient;

    public DelegatedAuthAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Create User Action Signature */
    public CompletableFuture<CreateUserActionSignatureResponse> createUserActionSignature(CreateUserActionSignatureRequest body) {
        return httpClient.postAsync("/auth/action", java.util.Map.of(), body, CreateUserActionSignatureResponse.class, false);
    }

    /** Create User Action Challenge */
    public CompletableFuture<CreateUserActionChallengeResponse> createUserActionChallenge(CreateUserActionChallengeRequest body) {
        return httpClient.postAsync("/auth/action/init", java.util.Map.of(), body, CreateUserActionChallengeResponse.class, false);
    }

    /** List Audit Logs */
    public CompletableFuture<Object> listAuditLogs(ListAuditLogsQuery query) {
        return httpClient.getAsync("/auth/action/logs", query.toMap(), Object.class);
    }

    /** Get Audit Log */
    public CompletableFuture<AuditLog> getAuditLog(Object id) {
        return httpClient.getAsync("/auth/action/logs/" + id, java.util.Map.of(), AuditLog.class);
    }

    /** List Applications */
    @Deprecated
    public CompletableFuture<ListApplicationsResponse> listApplications() {
        return httpClient.getAsync("/auth/apps", java.util.Map.of(), ListApplicationsResponse.class);
    }

    /** Get Application */
    @Deprecated
    public CompletableFuture<GetApplicationResponse> getApplication(String appId) {
        return httpClient.getAsync("/auth/apps/" + appId, java.util.Map.of(), GetApplicationResponse.class);
    }

    /** List Credentials */
    public CompletableFuture<ListCredentialsResponse> listCredentials() {
        return httpClient.getAsync("/auth/credentials", java.util.Map.of(), ListCredentialsResponse.class);
    }

    /** Delegated signing step 1 for Create Credential: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createCredentialInit(Object body) {
        return httpClient.createUserActionChallengeAsync("POST", "/auth/credentials", body);
    }

    /** Delegated signing step 2 for Create Credential: submits the signed challenge and issues the request. */
    public CompletableFuture<Credential> createCredentialComplete(Object body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/auth/credentials", java.util.Map.of(), body, Credential.class, userAction));
    }

    /** Create Credential Challenge */
    public CompletableFuture<Object> createCredentialChallenge(CreateCredentialChallengeRequest body) {
        return httpClient.postAsync("/auth/credentials/init", java.util.Map.of(), body, Object.class, false);
    }

    /** Delegated signing step 1 for Activate Credential: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> activateCredentialInit(ActivateCredentialRequest body) {
        return httpClient.createUserActionChallengeAsync("PUT", "/auth/credentials/activate", body);
    }

    /** Delegated signing step 2 for Activate Credential: submits the signed challenge and issues the request. */
    public CompletableFuture<ActivateCredentialResponse> activateCredentialComplete(ActivateCredentialRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("PUT", "/auth/credentials/activate", java.util.Map.of(), body, ActivateCredentialResponse.class, userAction));
    }

    /** Delegated signing step 1 for Delete Credential: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> deleteCredentialInit(String credentialUuid) {
        return httpClient.createUserActionChallengeAsync("DELETE", "/auth/credentials/" + credentialUuid, null);
    }

    /** Delegated signing step 2 for Delete Credential: submits the signed challenge and issues the request. */
    @SuppressWarnings("unchecked")
    public CompletableFuture<Map<String, Object>> deleteCredentialComplete(String credentialUuid, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("DELETE", "/auth/credentials/" + credentialUuid, java.util.Map.of(), null, (Class<Map<String, Object>>) (Class<?>) Map.class, userAction));
    }

    /** Delegated signing step 1 for Deactivate Credential: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> deactivateCredentialInit(DeactivateCredentialRequest body) {
        return httpClient.createUserActionChallengeAsync("PUT", "/auth/credentials/deactivate", body);
    }

    /** Delegated signing step 2 for Deactivate Credential: submits the signed challenge and issues the request. */
    public CompletableFuture<DeactivateCredentialResponse> deactivateCredentialComplete(DeactivateCredentialRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("PUT", "/auth/credentials/deactivate", java.util.Map.of(), body, DeactivateCredentialResponse.class, userAction));
    }

    /** Delegated signing step 1 for Create Credential Code: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createCredentialCodeInit(CreateCredentialCodeRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/auth/credentials/code", body);
    }

    /** Delegated signing step 2 for Create Credential Code: submits the signed challenge and issues the request. */
    public CompletableFuture<CreateCredentialCodeResponse> createCredentialCodeComplete(CreateCredentialCodeRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/auth/credentials/code", java.util.Map.of(), body, CreateCredentialCodeResponse.class, userAction));
    }

    /** Create Credential Challenge With Code */
    public CompletableFuture<Object> createCredentialChallengeWithCode(CreateCredentialChallengeWithCodeRequest body) {
        return httpClient.postAsync("/auth/credentials/code/init", java.util.Map.of(), body, Object.class, false);
    }

    /** Create Credential With Code */
    public CompletableFuture<Credential> createCredentialWithCode(Object body) {
        return httpClient.postAsync("/auth/credentials/code/verify", java.util.Map.of(), body, Credential.class, false);
    }

    /** Create Login Challenge */
    public CompletableFuture<CreateLoginChallengeResponse> createLoginChallenge(CreateLoginChallengeRequest body) {
        return httpClient.postAsync("/auth/login/init", java.util.Map.of(), body, CreateLoginChallengeResponse.class, false);
    }

    /** Delegated signing step 1 for Delegated Login: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> delegatedLoginInit(DelegatedLoginRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/auth/login/delegated", body);
    }

    /** Delegated signing step 2 for Delegated Login: submits the signed challenge and issues the request. */
    public CompletableFuture<DelegatedLoginResponse> delegatedLoginComplete(DelegatedLoginRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/auth/login/delegated", java.util.Map.of(), body, DelegatedLoginResponse.class, userAction));
    }

    /** Complete User Login */
    public CompletableFuture<Object> completeUserLogin(CompleteUserLoginRequest body) {
        return httpClient.postAsync("/auth/login", java.util.Map.of(), body, Object.class, false);
    }

    /** Logout */
    public CompletableFuture<LogoutResponse> logout(LogoutRequest body) {
        return httpClient.putAsync("/auth/logout", java.util.Map.of(), body, LogoutResponse.class, false);
    }

    /** Complete OIDC Login */
    public CompletableFuture<Object> completeOidcLogin(CompleteOidcLoginRequest body) {
        return httpClient.postAsync("/auth/login/oidc", java.util.Map.of(), body, Object.class, false);
    }

    /** Initiate OIDC Login */
    public CompletableFuture<InitiateOidcLoginResponse> initiateOidcLogin(InitiateOidcLoginRequest body) {
        return httpClient.postAsync("/auth/login/oidc/init", java.util.Map.of(), body, InitiateOidcLoginResponse.class, false);
    }

    /** Send Login Code */
    public CompletableFuture<SendLoginCodeResponse> sendLoginCode(SendLoginCodeRequest body) {
        return httpClient.postAsync("/auth/login/code", java.util.Map.of(), body, SendLoginCodeResponse.class, false);
    }

    /** Social Login */
    public CompletableFuture<SocialLoginResponse> socialLogin(SocialLoginRequest body) {
        return httpClient.postAsync("/auth/login/social", java.util.Map.of(), body, SocialLoginResponse.class, false);
    }

    /** Complete SSO Login */
    public CompletableFuture<CompleteSsoLoginResponse> completeSsoLogin(CompleteSsoLoginRequest body) {
        return httpClient.postAsync("/auth/login/sso", java.util.Map.of(), body, CompleteSsoLoginResponse.class, false);
    }

    /** Initiate SSO Login */
    public CompletableFuture<InitiateSsoLoginResponse> initiateSsoLogin(InitiateSsoLoginRequest body) {
        return httpClient.postAsync("/auth/login/sso/init", java.util.Map.of(), body, InitiateSsoLoginResponse.class, false);
    }

    /** Exchange Access Token */
    public CompletableFuture<ExchangeAccessTokenResponse> exchangeAccessToken(ExchangeAccessTokenRequest body) {
        return httpClient.postAsync("/auth/tokens", java.util.Map.of(), body, ExchangeAccessTokenResponse.class, false);
    }

    /** List Personal Access Tokens */
    public CompletableFuture<ListPersonalAccessTokensResponse> listPersonalAccessTokens() {
        return httpClient.getAsync("/auth/pats", java.util.Map.of(), ListPersonalAccessTokensResponse.class);
    }

    /** Delegated signing step 1 for Create Personal Access Token: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createPersonalAccessTokenInit(CreatePersonalAccessTokenRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/auth/pats", body);
    }

    /** Delegated signing step 2 for Create Personal Access Token: submits the signed challenge and issues the request. */
    public CompletableFuture<CreatePersonalAccessTokenResponse> createPersonalAccessTokenComplete(CreatePersonalAccessTokenRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/auth/pats", java.util.Map.of(), body, CreatePersonalAccessTokenResponse.class, userAction));
    }

    /** Get Personal Access Token */
    public CompletableFuture<PersonalAccessToken> getPersonalAccessToken(String tokenId) {
        return httpClient.getAsync("/auth/pats/" + tokenId, java.util.Map.of(), PersonalAccessToken.class);
    }

    /** Delegated signing step 1 for Update Personal Access Token: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> updatePersonalAccessTokenInit(String tokenId, UpdatePersonalAccessTokenRequest body) {
        return httpClient.createUserActionChallengeAsync("PUT", "/auth/pats/" + tokenId, body);
    }

    /** Delegated signing step 2 for Update Personal Access Token: submits the signed challenge and issues the request. */
    public CompletableFuture<PersonalAccessToken> updatePersonalAccessTokenComplete(String tokenId, UpdatePersonalAccessTokenRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("PUT", "/auth/pats/" + tokenId, java.util.Map.of(), body, PersonalAccessToken.class, userAction));
    }

    /** Delegated signing step 1 for Delete Personal Access Token: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> deletePersonalAccessTokenInit(String tokenId) {
        return httpClient.createUserActionChallengeAsync("DELETE", "/auth/pats/" + tokenId, null);
    }

    /** Delegated signing step 2 for Delete Personal Access Token: submits the signed challenge and issues the request. */
    public CompletableFuture<PersonalAccessToken> deletePersonalAccessTokenComplete(String tokenId, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("DELETE", "/auth/pats/" + tokenId, java.util.Map.of(), null, PersonalAccessToken.class, userAction));
    }

    /** Delegated signing step 1 for Activate Personal Access Token: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> activatePersonalAccessTokenInit(String tokenId) {
        return httpClient.createUserActionChallengeAsync("PUT", "/auth/pats/" + tokenId + "/activate", null);
    }

    /** Delegated signing step 2 for Activate Personal Access Token: submits the signed challenge and issues the request. */
    public CompletableFuture<PersonalAccessToken> activatePersonalAccessTokenComplete(String tokenId, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("PUT", "/auth/pats/" + tokenId + "/activate", java.util.Map.of(), null, PersonalAccessToken.class, userAction));
    }

    /** Delegated signing step 1 for Deactivate Personal Access Token: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> deactivatePersonalAccessTokenInit(String tokenId) {
        return httpClient.createUserActionChallengeAsync("PUT", "/auth/pats/" + tokenId + "/deactivate", null);
    }

    /** Delegated signing step 2 for Deactivate Personal Access Token: submits the signed challenge and issues the request. */
    public CompletableFuture<PersonalAccessToken> deactivatePersonalAccessTokenComplete(String tokenId, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("PUT", "/auth/pats/" + tokenId + "/deactivate", java.util.Map.of(), null, PersonalAccessToken.class, userAction));
    }

    /** Delegated signing step 1 for Create Delegated Recovery Challenge: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createDelegatedRecoveryChallengeInit(CreateDelegatedRecoveryChallengeRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/auth/recover/user/delegated", body);
    }

    /** Delegated signing step 2 for Create Delegated Recovery Challenge: submits the signed challenge and issues the request. */
    public CompletableFuture<CreateDelegatedRecoveryChallengeResponse> createDelegatedRecoveryChallengeComplete(CreateDelegatedRecoveryChallengeRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/auth/recover/user/delegated", java.util.Map.of(), body, CreateDelegatedRecoveryChallengeResponse.class, userAction));
    }

    /** Recover User */
    public CompletableFuture<RecoverUserResponse> recoverUser(RecoverUserRequest body) {
        return httpClient.postAsync("/auth/recover/user", java.util.Map.of(), body, RecoverUserResponse.class, false);
    }

    /** Create Recovery Challenge */
    public CompletableFuture<CreateRecoveryChallengeResponse> createRecoveryChallenge(CreateRecoveryChallengeRequest body) {
        return httpClient.postAsync("/auth/recover/user/init", java.util.Map.of(), body, CreateRecoveryChallengeResponse.class, false);
    }

    /** Send Recovery Code Email */
    public CompletableFuture<SendRecoveryCodeEmailResponse> sendRecoveryCodeEmail(SendRecoveryCodeEmailRequest body) {
        return httpClient.postAsync("/auth/recover/user/code", java.util.Map.of(), body, SendRecoveryCodeEmailResponse.class, false);
    }

    /** Delegated signing step 1 for Create Delegated Registration Challenge: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createDelegatedRegistrationChallengeInit(CreateDelegatedRegistrationChallengeRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/auth/registration/delegated", body);
    }

    /** Delegated signing step 2 for Create Delegated Registration Challenge: submits the signed challenge and issues the request. */
    public CompletableFuture<CreateDelegatedRegistrationChallengeResponse> createDelegatedRegistrationChallengeComplete(CreateDelegatedRegistrationChallengeRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/auth/registration/delegated", java.util.Map.of(), body, CreateDelegatedRegistrationChallengeResponse.class, userAction));
    }

    /** Create Registration Challenge */
    public CompletableFuture<CreateRegistrationChallengeResponse> createRegistrationChallenge(CreateRegistrationChallengeRequest body) {
        return httpClient.postAsync("/auth/registration/init", java.util.Map.of(), body, CreateRegistrationChallengeResponse.class, false);
    }

    /** Create Social Registration Challenge */
    public CompletableFuture<CreateSocialRegistrationChallengeResponse> createSocialRegistrationChallenge(CreateSocialRegistrationChallengeRequest body) {
        return httpClient.postAsync("/auth/registration/social", java.util.Map.of(), body, CreateSocialRegistrationChallengeResponse.class, false);
    }

    /** Complete User Registration */
    public CompletableFuture<CompleteUserRegistrationResponse> completeUserRegistration(CompleteUserRegistrationRequest body) {
        return httpClient.postAsync("/auth/registration", java.util.Map.of(), body, CompleteUserRegistrationResponse.class, false);
    }

    /** Complete End User Registration with Wallets */
    public CompletableFuture<CompleteEndUserRegistrationWithWalletsResponse> completeEndUserRegistrationWithWallets(CompleteEndUserRegistrationWithWalletsRequest body) {
        return httpClient.postAsync("/auth/registration/enduser", java.util.Map.of(), body, CompleteEndUserRegistrationWithWalletsResponse.class, false);
    }

    /** Resend Registration Code */
    public CompletableFuture<ResendRegistrationCodeResponse> resendRegistrationCode(ResendRegistrationCodeRequest body) {
        return httpClient.putAsync("/auth/registration/code", java.util.Map.of(), body, ResendRegistrationCodeResponse.class, false);
    }

    /** List Service Accounts */
    public CompletableFuture<ListServiceAccountsResponse> listServiceAccounts() {
        return httpClient.getAsync("/auth/service-accounts", java.util.Map.of(), ListServiceAccountsResponse.class);
    }

    /** Delegated signing step 1 for Create Service Account: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createServiceAccountInit(CreateServiceAccountRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/auth/service-accounts", body);
    }

    /** Delegated signing step 2 for Create Service Account: submits the signed challenge and issues the request. */
    public CompletableFuture<CreateServiceAccountResponse> createServiceAccountComplete(CreateServiceAccountRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/auth/service-accounts", java.util.Map.of(), body, CreateServiceAccountResponse.class, userAction));
    }

    /** Get Service Account */
    public CompletableFuture<GetServiceAccountResponse> getServiceAccount(String serviceAccountId) {
        return httpClient.getAsync("/auth/service-accounts/" + serviceAccountId, java.util.Map.of(), GetServiceAccountResponse.class);
    }

    /** Delegated signing step 1 for Update Service Account: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> updateServiceAccountInit(String serviceAccountId, UpdateServiceAccountRequest body) {
        return httpClient.createUserActionChallengeAsync("PUT", "/auth/service-accounts/" + serviceAccountId, body);
    }

    /** Delegated signing step 2 for Update Service Account: submits the signed challenge and issues the request. */
    public CompletableFuture<UpdateServiceAccountResponse> updateServiceAccountComplete(String serviceAccountId, UpdateServiceAccountRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("PUT", "/auth/service-accounts/" + serviceAccountId, java.util.Map.of(), body, UpdateServiceAccountResponse.class, userAction));
    }

    /** Delegated signing step 1 for Delete Service Account: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> deleteServiceAccountInit(String serviceAccountId) {
        return httpClient.createUserActionChallengeAsync("DELETE", "/auth/service-accounts/" + serviceAccountId, null);
    }

    /** Delegated signing step 2 for Delete Service Account: submits the signed challenge and issues the request. */
    public CompletableFuture<DeleteServiceAccountResponse> deleteServiceAccountComplete(String serviceAccountId, DeleteServiceAccountQuery query, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("DELETE", "/auth/service-accounts/" + serviceAccountId, query.toMap(), null, DeleteServiceAccountResponse.class, userAction));
    }

    /** Delegated signing step 1 for Activate Service Account: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> activateServiceAccountInit(String serviceAccountId) {
        return httpClient.createUserActionChallengeAsync("PUT", "/auth/service-accounts/" + serviceAccountId + "/activate", null);
    }

    /** Delegated signing step 2 for Activate Service Account: submits the signed challenge and issues the request. */
    public CompletableFuture<ActivateServiceAccountResponse> activateServiceAccountComplete(String serviceAccountId, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("PUT", "/auth/service-accounts/" + serviceAccountId + "/activate", java.util.Map.of(), null, ActivateServiceAccountResponse.class, userAction));
    }

    /** Delegated signing step 1 for Deactivate Service Account: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> deactivateServiceAccountInit(String serviceAccountId, DeactivateServiceAccountRequest body) {
        return httpClient.createUserActionChallengeAsync("PUT", "/auth/service-accounts/" + serviceAccountId + "/deactivate", body);
    }

    /** Delegated signing step 2 for Deactivate Service Account: submits the signed challenge and issues the request. */
    public CompletableFuture<DeactivateServiceAccountResponse> deactivateServiceAccountComplete(String serviceAccountId, DeactivateServiceAccountRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("PUT", "/auth/service-accounts/" + serviceAccountId + "/deactivate", java.util.Map.of(), body, DeactivateServiceAccountResponse.class, userAction));
    }

    /** Delegated signing step 1 for Activate User: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> activateUserInit(String userId) {
        return httpClient.createUserActionChallengeAsync("PUT", "/auth/users/" + userId + "/activate", null);
    }

    /** Delegated signing step 2 for Activate User: submits the signed challenge and issues the request. */
    public CompletableFuture<User> activateUserComplete(String userId, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("PUT", "/auth/users/" + userId + "/activate", java.util.Map.of(), null, User.class, userAction));
    }

    /** Delegated signing step 1 for Deactivate User: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> deactivateUserInit(String userId) {
        return httpClient.createUserActionChallengeAsync("PUT", "/auth/users/" + userId + "/deactivate", null);
    }

    /** Delegated signing step 2 for Deactivate User: submits the signed challenge and issues the request. */
    public CompletableFuture<User> deactivateUserComplete(String userId, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("PUT", "/auth/users/" + userId + "/deactivate", java.util.Map.of(), null, User.class, userAction));
    }

    /** Get User */
    public CompletableFuture<User> getUser(String userId) {
        return httpClient.getAsync("/auth/users/" + userId, java.util.Map.of(), User.class);
    }

    /** Delegated signing step 1 for Update User: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> updateUserInit(String userId, UpdateUserRequest body) {
        return httpClient.createUserActionChallengeAsync("PUT", "/auth/users/" + userId, body);
    }

    /** Delegated signing step 2 for Update User: submits the signed challenge and issues the request. */
    public CompletableFuture<User> updateUserComplete(String userId, UpdateUserRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("PUT", "/auth/users/" + userId, java.util.Map.of(), body, User.class, userAction));
    }

    /** Delegated signing step 1 for Delete User: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> deleteUserInit(String userId) {
        return httpClient.createUserActionChallengeAsync("DELETE", "/auth/users/" + userId, null);
    }

    /** Delegated signing step 2 for Delete User: submits the signed challenge and issues the request. */
    public CompletableFuture<User> deleteUserComplete(String userId, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("DELETE", "/auth/users/" + userId, java.util.Map.of(), null, User.class, userAction));
    }

    /** List Users */
    public CompletableFuture<PaginatedList<User>> listUsers(ListUsersQuery query) {
        return httpClient.getAsync("/auth/users", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<User>>() {});
    }

    /** Delegated signing step 1 for Create User: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createUserInit(CreateUserRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/auth/users", body);
    }

    /** Delegated signing step 2 for Create User: submits the signed challenge and issues the request. */
    public CompletableFuture<User> createUserComplete(CreateUserRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/auth/users", java.util.Map.of(), body, User.class, userAction));
    }

    /** Delegated signing step 1 for Invite Tenant User: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> inviteTenantUserInit(InviteTenantUserRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/auth/users/invite", body);
    }

    /** Delegated signing step 2 for Invite Tenant User: submits the signed challenge and issues the request. */
    @SuppressWarnings("unchecked")
    public CompletableFuture<Map<String, Object>> inviteTenantUserComplete(InviteTenantUserRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/auth/users/invite", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, userAction));
    }
}
