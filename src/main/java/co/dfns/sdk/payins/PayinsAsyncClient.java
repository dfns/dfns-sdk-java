package co.dfns.sdk.payins;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.payins.model.*;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class PayinsAsyncClient {
    private final DfnsHttpClient httpClient;

    public PayinsAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Payins */
    public CompletableFuture<ListPayinsResponse> listPayins(ListPayinsQuery query) {
        return httpClient.getAsync("/payins", query.toMap(), ListPayinsResponse.class);
    }

    /** Create Payin */
    public CompletableFuture<Object> createPayin(Object body) {
        return httpClient.postAsync("/payins", java.util.Map.of(), body, Object.class, true);
    }

    /** Request Payin Quote */
    public CompletableFuture<CreatePayinQuoteResponse> createPayinQuote(Object body) {
        return httpClient.postAsync("/payins/quote", java.util.Map.of(), body, CreatePayinQuoteResponse.class, false);
    }

    /** @deprecated Use {@link #createPayinQuote} instead. */
    @Deprecated
    public CompletableFuture<CreatePayinQuoteResponse> requestPayinQuote(Object body) {
        return createPayinQuote(body);
    }

    /** Get Payin Recipient */
    public CompletableFuture<GetPayinRecipientResponse> getPayinRecipient(GetPayinRecipientQuery query) {
        return httpClient.getAsync("/payins/recipients", query.toMap(), GetPayinRecipientResponse.class);
    }

    /** Register Payin Recipient */
    public CompletableFuture<CreatePayinRecipientResponse> createPayinRecipient(Object body) {
        return httpClient.postAsync("/payins/recipients", java.util.Map.of(), body, CreatePayinRecipientResponse.class, true);
    }

    /** @deprecated Use {@link #createPayinRecipient} instead. */
    @Deprecated
    public CompletableFuture<CreatePayinRecipientResponse> registerPayinRecipient(Object body) {
        return createPayinRecipient(body);
    }

    /** Get Payin Status */
    public CompletableFuture<Object> getPayin(String payinId) {
        return httpClient.getAsync("/payins/" + payinId, java.util.Map.of(), Object.class);
    }

    /** @deprecated Use {@link #getPayin} instead. */
    @Deprecated
    public CompletableFuture<Object> getPayinStatus(String payinId) {
        return getPayin(payinId);
    }

    /** List Payin Accounts */
    public CompletableFuture<ListPayinAccountsResponse> listPayinAccounts(ListPayinAccountsQuery query) {
        return httpClient.getAsync("/payins/accounts", query.toMap(), ListPayinAccountsResponse.class);
    }

    /** List Payin Balances */
    public CompletableFuture<ListPayinBalancesResponse> listPayinBalances(ListPayinBalancesQuery query) {
        return httpClient.getAsync("/payins/balances", query.toMap(), ListPayinBalancesResponse.class);
    }

    /** List Payin Options */
    public CompletableFuture<ListPayinOptionsResponse> listPayinOptions(ListPayinOptionsQuery query) {
        return httpClient.getAsync("/payins/options", query.toMap(), ListPayinOptionsResponse.class);
    }

    /** Register Payin Account Asset */
    public CompletableFuture<RegisterPayinAccountAssetResponse> registerPayinAccountAsset(Object body) {
        return httpClient.postAsync("/payins/accounts/assets", java.util.Map.of(), body, RegisterPayinAccountAssetResponse.class, true);
    }
}
