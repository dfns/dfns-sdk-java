package co.dfns.sdk.exchanges;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.exchanges.model.*;
import java.util.Map;
import java.util.List;

public class ExchangesClient {
    private final DfnsHttpClient httpClient;

    public ExchangesClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Get Exchange */
    public GetExchangeResponse getExchange(String exchangeId) {
        return httpClient.get("/exchanges/" + exchangeId, java.util.Map.of(), GetExchangeResponse.class);
    }

    /** Delete Exchange */
    public DeleteExchangeResponse deleteExchange(String exchangeId) {
        return httpClient.delete("/exchanges/" + exchangeId, java.util.Map.of(), null, DeleteExchangeResponse.class, true);
    }

    /** List Exchanges */
    public ListExchangesResponse listExchanges(ListExchangesQuery query) {
        return httpClient.get("/exchanges", query.toMap(), ListExchangesResponse.class);
    }

    /** Create Exchange */
    public CreateExchangeResponse createExchange(CreateExchangeRequest body) {
        return httpClient.post("/exchanges", java.util.Map.of(), body, CreateExchangeResponse.class, true);
    }

    /** List Accounts */
    public ListAccountsResponse listAccounts(String exchangeId, ListAccountsQuery query) {
        return httpClient.get("/exchanges/" + exchangeId + "/accounts", query.toMap(), ListAccountsResponse.class);
    }

    /** List Account Assets */
    public ListAccountAssetsResponse listAccountAssets(String exchangeId, String accountId, ListAccountAssetsQuery query) {
        return httpClient.get("/exchanges/" + exchangeId + "/accounts/" + accountId + "/assets", query.toMap(), ListAccountAssetsResponse.class);
    }

    /** List Asset Withdrawal Networks */
    @SuppressWarnings("unchecked")
    public List<Object> listAssetWithdrawalNetworks(String exchangeId, String accountId, String asset) {
        return httpClient.get("/exchanges/" + exchangeId + "/accounts/" + accountId + "/assets/" + asset + "/withdrawal-networks", java.util.Map.of(), (Class<List<Object>>) (Class<?>) List.class);
    }

    /** Create Exchange Deposit */
    public CreateExchangeDepositResponse createExchangeDeposit(String exchangeId, String accountId, Object body) {
        return httpClient.post("/exchanges/" + exchangeId + "/accounts/" + accountId + "/deposits", java.util.Map.of(), body, CreateExchangeDepositResponse.class, true);
    }

    /** Create Exchange Withdrawal */
    public CreateExchangeWithdrawalResponse createExchangeWithdrawal(String exchangeId, String accountId, Object body) {
        return httpClient.post("/exchanges/" + exchangeId + "/accounts/" + accountId + "/withdrawals", java.util.Map.of(), body, CreateExchangeWithdrawalResponse.class, true);
    }
}
