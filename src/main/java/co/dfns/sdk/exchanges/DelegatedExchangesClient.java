package co.dfns.sdk.exchanges;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.exchanges.model.*;
import java.util.Map;
import java.util.List;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedExchangesClient {
    private final DfnsHttpClient httpClient;

    public DelegatedExchangesClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Get Exchange */
    public GetExchangeResponse getExchange(String exchangeId) {
        return httpClient.get("/exchanges/" + exchangeId, java.util.Map.of(), GetExchangeResponse.class);
    }

    /** Delegated signing step 1 for Delete Exchange: returns the challenge to sign out-of-band. */
    public UserActionChallenge deleteExchangeInit(String exchangeId) {
        return httpClient.createUserActionChallenge("DELETE", "/exchanges/" + exchangeId, null);
    }

    /** Delegated signing step 2 for Delete Exchange: submits the signed challenge and issues the request. */
    public DeleteExchangeResponse deleteExchangeComplete(String exchangeId, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("DELETE", "/exchanges/" + exchangeId, java.util.Map.of(), null, DeleteExchangeResponse.class, userAction);
    }

    /** List Exchanges */
    public ListExchangesResponse listExchanges(ListExchangesQuery query) {
        return httpClient.get("/exchanges", query.toMap(), ListExchangesResponse.class);
    }

    /** Delegated signing step 1 for Create Exchange: returns the challenge to sign out-of-band. */
    public UserActionChallenge createExchangeInit(CreateExchangeRequest body) {
        return httpClient.createUserActionChallenge("POST", "/exchanges", body);
    }

    /** Delegated signing step 2 for Create Exchange: submits the signed challenge and issues the request. */
    public CreateExchangeResponse createExchangeComplete(CreateExchangeRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/exchanges", java.util.Map.of(), body, CreateExchangeResponse.class, userAction);
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

    /** Delegated signing step 1 for Create Exchange Deposit: returns the challenge to sign out-of-band. */
    public UserActionChallenge createExchangeDepositInit(String exchangeId, String accountId, Object body) {
        return httpClient.createUserActionChallenge("POST", "/exchanges/" + exchangeId + "/accounts/" + accountId + "/deposits", body);
    }

    /** Delegated signing step 2 for Create Exchange Deposit: submits the signed challenge and issues the request. */
    public CreateExchangeDepositResponse createExchangeDepositComplete(String exchangeId, String accountId, Object body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/exchanges/" + exchangeId + "/accounts/" + accountId + "/deposits", java.util.Map.of(), body, CreateExchangeDepositResponse.class, userAction);
    }

    /** Delegated signing step 1 for Create Exchange Withdrawal: returns the challenge to sign out-of-band. */
    public UserActionChallenge createExchangeWithdrawalInit(String exchangeId, String accountId, Object body) {
        return httpClient.createUserActionChallenge("POST", "/exchanges/" + exchangeId + "/accounts/" + accountId + "/withdrawals", body);
    }

    /** Delegated signing step 2 for Create Exchange Withdrawal: submits the signed challenge and issues the request. */
    public CreateExchangeWithdrawalResponse createExchangeWithdrawalComplete(String exchangeId, String accountId, Object body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/exchanges/" + exchangeId + "/accounts/" + accountId + "/withdrawals", java.util.Map.of(), body, CreateExchangeWithdrawalResponse.class, userAction);
    }
}
