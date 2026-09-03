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
    public RequestPayinQuoteResponse requestPayinQuote(Object body) {
        return httpClient.post("/payins/quote", java.util.Map.of(), body, RequestPayinQuoteResponse.class, false);
    }

    /** Get Payin Recipient */
    public GetPayinRecipientResponse getPayinRecipient(GetPayinRecipientQuery query) {
        return httpClient.get("/payins/recipients", query.toMap(), GetPayinRecipientResponse.class);
    }

    /** Register Payin Recipient */
    public RegisterPayinRecipientResponse registerPayinRecipient(Object body) {
        return httpClient.post("/payins/recipients", java.util.Map.of(), body, RegisterPayinRecipientResponse.class, true);
    }

    /** Get Payin Status */
    public Object getPayinStatus(String payinId) {
        return httpClient.get("/payins/" + payinId, java.util.Map.of(), Object.class);
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
