package co.dfns.sdk.exchanges;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.exchanges.model.*;
import java.util.Map;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ExchangesAsyncClient {
    private final DfnsHttpClient httpClient;

    public ExchangesAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Get Exchange */
    public CompletableFuture<GetExchangeResponse> getExchange(String exchangeId) {
        return httpClient.getAsync("/exchanges/" + exchangeId, java.util.Map.of(), GetExchangeResponse.class);
    }

    /** Delete Exchange */
    public CompletableFuture<DeleteExchangeResponse> deleteExchange(String exchangeId) {
        return httpClient.deleteAsync("/exchanges/" + exchangeId, java.util.Map.of(), null, DeleteExchangeResponse.class, true);
    }

    /** List Exchanges */
    public CompletableFuture<ListExchangesResponse> listExchanges(ListExchangesQuery query) {
        return httpClient.getAsync("/exchanges", query.toMap(), ListExchangesResponse.class);
    }

    /** Create Exchange */
    public CompletableFuture<CreateExchangeResponse> createExchange(CreateExchangeRequest body) {
        return httpClient.postAsync("/exchanges", java.util.Map.of(), body, CreateExchangeResponse.class, true);
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

    /** Create Exchange Deposit */
    public CompletableFuture<CreateExchangeDepositResponse> createExchangeDeposit(String exchangeId, String accountId, Object body) {
        return httpClient.postAsync("/exchanges/" + exchangeId + "/accounts/" + accountId + "/deposits", java.util.Map.of(), body, CreateExchangeDepositResponse.class, true);
    }

    /** Create Exchange Withdrawal */
    public CompletableFuture<CreateExchangeWithdrawalResponse> createExchangeWithdrawal(String exchangeId, String accountId, Object body) {
        return httpClient.postAsync("/exchanges/" + exchangeId + "/accounts/" + accountId + "/withdrawals", java.util.Map.of(), body, CreateExchangeWithdrawalResponse.class, true);
    }
}
