package co.dfns.sdk.payins;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.payins.model.*;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedPayinsAsyncClient {
    private final DfnsHttpClient httpClient;

    public DelegatedPayinsAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Payins */
    public CompletableFuture<ListPayinsResponse> listPayins(ListPayinsQuery query) {
        return httpClient.getAsync("/payins", query.toMap(), ListPayinsResponse.class);
    }

    /** Delegated signing step 1 for Create Payin: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createPayinInit(Object body) {
        return httpClient.createUserActionChallengeAsync("POST", "/payins", body);
    }

    /** Delegated signing step 2 for Create Payin: submits the signed challenge and issues the request. */
    public CompletableFuture<Object> createPayinComplete(Object body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/payins", java.util.Map.of(), body, Object.class, userAction));
    }

    /** Get Payin Recipient */
    public CompletableFuture<GetPayinRecipientResponse> getPayinRecipient(GetPayinRecipientQuery query) {
        return httpClient.getAsync("/payins/recipients", query.toMap(), GetPayinRecipientResponse.class);
    }

    /** Delegated signing step 1 for Register Payin Recipient: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> registerPayinRecipientInit(Object body) {
        return httpClient.createUserActionChallengeAsync("POST", "/payins/recipients", body);
    }

    /** Delegated signing step 2 for Register Payin Recipient: submits the signed challenge and issues the request. */
    public CompletableFuture<RegisterPayinRecipientResponse> registerPayinRecipientComplete(Object body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/payins/recipients", java.util.Map.of(), body, RegisterPayinRecipientResponse.class, userAction));
    }

    /** Get Payin Status */
    public CompletableFuture<Object> getPayinStatus(String payinId) {
        return httpClient.getAsync("/payins/" + payinId, java.util.Map.of(), Object.class);
    }

    /** List Payin Balances */
    public CompletableFuture<ListPayinBalancesResponse> listPayinBalances(ListPayinBalancesQuery query) {
        return httpClient.getAsync("/payins/balances", query.toMap(), ListPayinBalancesResponse.class);
    }
}
