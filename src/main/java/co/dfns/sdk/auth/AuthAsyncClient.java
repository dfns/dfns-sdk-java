package co.dfns.sdk.auth;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.auth.model.*;
import java.util.Map;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.concurrent.CompletableFuture;

public class AuthAsyncClient {
    private final DfnsHttpClient httpClient;

    public AuthAsyncClient(DfnsHttpClient httpClient) {
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

    /** Create Credential */
    public CompletableFuture<Credential> createCredential(Object body) {
        return httpClient.postAsync("/auth/credentials", java.util.Map.of(), body, Credential.class, true);
    }

    /** Create Credential Challenge */
    public CompletableFuture<Object> createCredentialChallenge(CreateCredentialChallengeRequest body) {
        return httpClient.postAsync("/auth/credentials/init", java.util.Map.of(), body, Object.class, false);
    }

    /** Activate Credential */
    public CompletableFuture<ActivateCredentialResponse> activateCredential(ActivateCredentialRequest body) {
        return httpClient.putAsync("/auth/credentials/activate", java.util.Map.of(), body, ActivateCredentialResponse.class, true);
    }

    /** Deactivate Credential */
    public CompletableFuture<DeactivateCredentialResponse> deactivateCredential(DeactivateCredentialRequest body) {
        return httpClient.putAsync("/auth/credentials/deactivate", java.util.Map.of(), body, DeactivateCredentialResponse.class, true);
    }

    /** Create Credential Code */
    public CompletableFuture<CreateCredentialCodeResponse> createCredentialCode(CreateCredentialCodeRequest body) {
        return httpClient.postAsync("/auth/credentials/code", java.util.Map.of(), body, CreateCredentialCodeResponse.class, true);
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

    /** Delegated Login */
    public CompletableFuture<DelegatedLoginResponse> delegatedLogin(DelegatedLoginRequest body) {
        return httpClient.postAsync("/auth/login/delegated", java.util.Map.of(), body, DelegatedLoginResponse.class, true);
    }

    /** Complete User Login */
    public CompletableFuture<Object> completeUserLogin(CompleteUserLoginRequest body) {
        return httpClient.postAsync("/auth/login", java.util.Map.of(), body, Object.class, false);
    }

    /** Logout */
    public CompletableFuture<LogoutResponse> logout(LogoutRequest body) {
        return httpClient.putAsync("/auth/logout", java.util.Map.of(), body, LogoutResponse.class, false);
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

    /** List Personal Access Tokens */
    public CompletableFuture<ListPersonalAccessTokensResponse> listPersonalAccessTokens() {
        return httpClient.getAsync("/auth/pats", java.util.Map.of(), ListPersonalAccessTokensResponse.class);
    }

    /** Create Personal Access Token */
    public CompletableFuture<CreatePersonalAccessTokenResponse> createPersonalAccessToken(CreatePersonalAccessTokenRequest body) {
        return httpClient.postAsync("/auth/pats", java.util.Map.of(), body, CreatePersonalAccessTokenResponse.class, true);
    }

    /** Get Personal Access Token */
    public CompletableFuture<PersonalAccessToken> getPersonalAccessToken(String tokenId) {
        return httpClient.getAsync("/auth/pats/" + tokenId, java.util.Map.of(), PersonalAccessToken.class);
    }

    /** Update Personal Access Token */
    public CompletableFuture<PersonalAccessToken> updatePersonalAccessToken(String tokenId, UpdatePersonalAccessTokenRequest body) {
        return httpClient.putAsync("/auth/pats/" + tokenId, java.util.Map.of(), body, PersonalAccessToken.class, true);
    }

    /** Delete Personal Access Token */
    public CompletableFuture<PersonalAccessToken> deletePersonalAccessToken(String tokenId) {
        return httpClient.deleteAsync("/auth/pats/" + tokenId, java.util.Map.of(), null, PersonalAccessToken.class, true);
    }

    /** Activate Personal Access Token */
    public CompletableFuture<PersonalAccessToken> activatePersonalAccessToken(String tokenId) {
        return httpClient.putAsync("/auth/pats/" + tokenId + "/activate", java.util.Map.of(), null, PersonalAccessToken.class, true);
    }

    /** Deactivate Personal Access Token */
    public CompletableFuture<PersonalAccessToken> deactivatePersonalAccessToken(String tokenId) {
        return httpClient.putAsync("/auth/pats/" + tokenId + "/deactivate", java.util.Map.of(), null, PersonalAccessToken.class, true);
    }

    /** Create Delegated Recovery Challenge */
    public CompletableFuture<CreateDelegatedRecoveryChallengeResponse> createDelegatedRecoveryChallenge(CreateDelegatedRecoveryChallengeRequest body) {
        return httpClient.postAsync("/auth/recover/user/delegated", java.util.Map.of(), body, CreateDelegatedRecoveryChallengeResponse.class, true);
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

    /** Create Delegated Registration Challenge */
    public CompletableFuture<CreateDelegatedRegistrationChallengeResponse> createDelegatedRegistrationChallenge(CreateDelegatedRegistrationChallengeRequest body) {
        return httpClient.postAsync("/auth/registration/delegated", java.util.Map.of(), body, CreateDelegatedRegistrationChallengeResponse.class, true);
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

    /** Create Service Account */
    public CompletableFuture<CreateServiceAccountResponse> createServiceAccount(CreateServiceAccountRequest body) {
        return httpClient.postAsync("/auth/service-accounts", java.util.Map.of(), body, CreateServiceAccountResponse.class, true);
    }

    /** Get Service Account */
    public CompletableFuture<GetServiceAccountResponse> getServiceAccount(String serviceAccountId) {
        return httpClient.getAsync("/auth/service-accounts/" + serviceAccountId, java.util.Map.of(), GetServiceAccountResponse.class);
    }

    /** Update Service Account */
    public CompletableFuture<UpdateServiceAccountResponse> updateServiceAccount(String serviceAccountId, UpdateServiceAccountRequest body) {
        return httpClient.putAsync("/auth/service-accounts/" + serviceAccountId, java.util.Map.of(), body, UpdateServiceAccountResponse.class, true);
    }

    /** Delete Service Account */
    public CompletableFuture<DeleteServiceAccountResponse> deleteServiceAccount(String serviceAccountId) {
        return httpClient.deleteAsync("/auth/service-accounts/" + serviceAccountId, java.util.Map.of(), null, DeleteServiceAccountResponse.class, true);
    }

    /** Activate Service Account */
    public CompletableFuture<ActivateServiceAccountResponse> activateServiceAccount(String serviceAccountId) {
        return httpClient.putAsync("/auth/service-accounts/" + serviceAccountId + "/activate", java.util.Map.of(), null, ActivateServiceAccountResponse.class, true);
    }

    /** Deactivate Service Account */
    public CompletableFuture<DeactivateServiceAccountResponse> deactivateServiceAccount(String serviceAccountId) {
        return httpClient.putAsync("/auth/service-accounts/" + serviceAccountId + "/deactivate", java.util.Map.of(), null, DeactivateServiceAccountResponse.class, true);
    }

    /** Activate User */
    public CompletableFuture<User> activateUser(String userId) {
        return httpClient.putAsync("/auth/users/" + userId + "/activate", java.util.Map.of(), null, User.class, true);
    }

    /** Deactivate User */
    public CompletableFuture<User> deactivateUser(String userId) {
        return httpClient.putAsync("/auth/users/" + userId + "/deactivate", java.util.Map.of(), null, User.class, true);
    }

    /** Get User */
    public CompletableFuture<User> getUser(String userId) {
        return httpClient.getAsync("/auth/users/" + userId, java.util.Map.of(), User.class);
    }

    /** Update User */
    public CompletableFuture<User> updateUser(String userId, UpdateUserRequest body) {
        return httpClient.putAsync("/auth/users/" + userId, java.util.Map.of(), body, User.class, true);
    }

    /** Delete User */
    public CompletableFuture<User> deleteUser(String userId) {
        return httpClient.deleteAsync("/auth/users/" + userId, java.util.Map.of(), null, User.class, true);
    }

    /** List Users */
    public CompletableFuture<PaginatedList<User>> listUsers(ListUsersQuery query) {
        return httpClient.getAsync("/auth/users", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<User>>() {});
    }

    /** Create User */
    public CompletableFuture<User> createUser(CreateUserRequest body) {
        return httpClient.postAsync("/auth/users", java.util.Map.of(), body, User.class, true);
    }
}
