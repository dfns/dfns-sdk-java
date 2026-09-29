package co.dfns.sdk.payins;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.payins.model.*;
import java.util.Map;

public class PayinsClient {
    private final DfnsHttpClient httpClient;

    public PayinsClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Payins */
    public ListPayinsResponse listPayins(ListPayinsQuery query) {
        return httpClient.get("/payins", query.toMap(), ListPayinsResponse.class);
    }

    /** Create Payin */
    public Object createPayin(Object body) {
        return httpClient.post("/payins", java.util.Map.of(), body, Object.class, true);
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

    /** Register Payin Recipient */
    public CreatePayinRecipientResponse createPayinRecipient(Object body) {
        return httpClient.post("/payins/recipients", java.util.Map.of(), body, CreatePayinRecipientResponse.class, true);
    }

    /** @deprecated Use {@link #createPayinRecipient} instead. */
    @Deprecated
    public CreatePayinRecipientResponse registerPayinRecipient(Object body) {
        return createPayinRecipient(body);
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

    /** Register Payin Account Asset */
    public RegisterPayinAccountAssetResponse registerPayinAccountAsset(Object body) {
        return httpClient.post("/payins/accounts/assets", java.util.Map.of(), body, RegisterPayinAccountAssetResponse.class, true);
    }
}
