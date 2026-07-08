package co.dfns.sdk.exchanges;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.exchanges.model.*;
import java.util.Map;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedExchangesAsyncClient {
    private final DfnsHttpClient httpClient;

    public DelegatedExchangesAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Get Exchange */
    public CompletableFuture<GetExchangeResponse> getExchange(String exchangeId) {
        return httpClient.getAsync("/exchanges/" + exchangeId, java.util.Map.of(), GetExchangeResponse.class);
    }

    /** Delegated signing step 1 for Delete Exchange: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> deleteExchangeInit(String exchangeId) {
        return httpClient.createUserActionChallengeAsync("DELETE", "/exchanges/" + exchangeId, null);
    }

    /** Delegated signing step 2 for Delete Exchange: submits the signed challenge and issues the request. */
    public CompletableFuture<DeleteExchangeResponse> deleteExchangeComplete(String exchangeId, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("DELETE", "/exchanges/" + exchangeId, java.util.Map.of(), null, DeleteExchangeResponse.class, userAction));
    }

    /** List Exchanges */
    public CompletableFuture<ListExchangesResponse> listExchanges(ListExchangesQuery query) {
        return httpClient.getAsync("/exchanges", query.toMap(), ListExchangesResponse.class);
    }

    /** Delegated signing step 1 for Create Exchange: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createExchangeInit(CreateExchangeRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/exchanges", body);
    }

    /** Delegated signing step 2 for Create Exchange: submits the signed challenge and issues the request. */
    public CompletableFuture<CreateExchangeResponse> createExchangeComplete(CreateExchangeRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/exchanges", java.util.Map.of(), body, CreateExchangeResponse.class, userAction));
    }

    /** List Accounts */
    public CompletableFuture<ListAccountsResponse> listAccounts(String exchangeId, ListAccountsQuery query) {
        return httpClient.getAsync("/exchanges/" + exchangeId + "/accounts", query.toMap(), ListAccountsResponse.class);
    }

    /** List Account Assets */
    public CompletableFuture<ListAccountAssetsResponse> listAccountAssets(String exchangeId, String accountId, ListAccountAssetsQuery query) {
        return httpClient.getAsync("/exchanges/" + exchangeId + "/accounts/" + accountId + "/assets", query.toMap(), ListAccountAssetsResponse.class);
    }

    /** List Asset Withdrawal Networks */
    @SuppressWarnings("unchecked")
    public CompletableFuture<List<Object>> listAssetWithdrawalNetworks(String exchangeId, String accountId, String asset) {
        return httpClient.getAsync("/exchanges/" + exchangeId + "/accounts/" + accountId + "/assets/" + asset + "/withdrawal-networks", java.util.Map.of(), (Class<List<Object>>) (Class<?>) List.class);
    }

    /** Delegated signing step 1 for Create Exchange Deposit: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createExchangeDepositInit(String exchangeId, String accountId, Object body) {
        return httpClient.createUserActionChallengeAsync("POST", "/exchanges/" + exchangeId + "/accounts/" + accountId + "/deposits", body);
    }

    /** Delegated signing step 2 for Create Exchange Deposit: submits the signed challenge and issues the request. */
    public CompletableFuture<CreateExchangeDepositResponse> createExchangeDepositComplete(String exchangeId, String accountId, Object body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/exchanges/" + exchangeId + "/accounts/" + accountId + "/deposits", java.util.Map.of(), body, CreateExchangeDepositResponse.class, userAction));
    }

    /** Delegated signing step 1 for Create Exchange Withdrawal: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createExchangeWithdrawalInit(String exchangeId, String accountId, Object body) {
        return httpClient.createUserActionChallengeAsync("POST", "/exchanges/" + exchangeId + "/accounts/" + accountId + "/withdrawals", body);
    }

    /** Delegated signing step 2 for Create Exchange Withdrawal: submits the signed challenge and issues the request. */
    public CompletableFuture<CreateExchangeWithdrawalResponse> createExchangeWithdrawalComplete(String exchangeId, String accountId, Object body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/exchanges/" + exchangeId + "/accounts/" + accountId + "/withdrawals", java.util.Map.of(), body, CreateExchangeWithdrawalResponse.class, userAction));
    }
}
