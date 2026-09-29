package co.dfns.sdk.payins;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.payins.model.*;
import java.util.Map;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedPayinsClient {
    private final DfnsHttpClient httpClient;

    public DelegatedPayinsClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Payins */
    public ListPayinsResponse listPayins(ListPayinsQuery query) {
        return httpClient.get("/payins", query.toMap(), ListPayinsResponse.class);
    }

    /** Delegated signing step 1 for Create Payin: returns the challenge to sign out-of-band. */
    public UserActionChallenge createPayinInit(Object body) {
        return httpClient.createUserActionChallenge("POST", "/payins", body);
    }

    /** Delegated signing step 2 for Create Payin: submits the signed challenge and issues the request. */
    public Object createPayinComplete(Object body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/payins", java.util.Map.of(), body, Object.class, userAction);
    }

    /** Request Payin Quote */
    public CreatePayinQuoteResponse createPayinQuote(Object body) {
        return httpClient.post("/payins/quote", java.util.Map.of(), body, CreatePayinQuoteResponse.class, false);
    }

    /** @deprecated Use {@link #createPayinQuote} instead. */
    @Deprecated
    public CreatePayinQuoteResponse requestPayinQuote(Object body) {
        return createPayinQuote(body);
    }

    /** Get Payin Recipient */
    public GetPayinRecipientResponse getPayinRecipient(GetPayinRecipientQuery query) {
        return httpClient.get("/payins/recipients", query.toMap(), GetPayinRecipientResponse.class);
    }

    /** Delegated signing step 1 for Register Payin Recipient: returns the challenge to sign out-of-band. */
    public UserActionChallenge createPayinRecipientInit(Object body) {
        return httpClient.createUserActionChallenge("POST", "/payins/recipients", body);
    }

    /** Delegated signing step 2 for Register Payin Recipient: submits the signed challenge and issues the request. */
    public CreatePayinRecipientResponse createPayinRecipientComplete(Object body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/payins/recipients", java.util.Map.of(), body, CreatePayinRecipientResponse.class, userAction);
    }

    /** Get Payin Status */
    public Object getPayin(String payinId) {
        return httpClient.get("/payins/" + payinId, java.util.Map.of(), Object.class);
    }

    /** @deprecated Use {@link #getPayin} instead. */
    @Deprecated
    public Object getPayinStatus(String payinId) {
        return getPayin(payinId);
    }

    /** List Payin Accounts */
    public ListPayinAccountsResponse listPayinAccounts(ListPayinAccountsQuery query) {
        return httpClient.get("/payins/accounts", query.toMap(), ListPayinAccountsResponse.class);
    }

    /** List Payin Balances */
    public ListPayinBalancesResponse listPayinBalances(ListPayinBalancesQuery query) {
        return httpClient.get("/payins/balances", query.toMap(), ListPayinBalancesResponse.class);
    }

    /** List Payin Options */
    public ListPayinOptionsResponse listPayinOptions(ListPayinOptionsQuery query) {
        return httpClient.get("/payins/options", query.toMap(), ListPayinOptionsResponse.class);
    }

    /** Delegated signing step 1 for Register Payin Account Asset: returns the challenge to sign out-of-band. */
    public UserActionChallenge registerPayinAccountAssetInit(Object body) {
        return httpClient.createUserActionChallenge("POST", "/payins/accounts/assets", body);
    }

    /** Delegated signing step 2 for Register Payin Account Asset: submits the signed challenge and issues the request. */
    public RegisterPayinAccountAssetResponse registerPayinAccountAssetComplete(Object body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/payins/accounts/assets", java.util.Map.of(), body, RegisterPayinAccountAssetResponse.class, userAction);
    }
}
