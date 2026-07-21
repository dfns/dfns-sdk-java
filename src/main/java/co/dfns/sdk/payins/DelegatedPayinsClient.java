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

    /** Get Payin Recipient */
    public GetPayinRecipientResponse getPayinRecipient(GetPayinRecipientQuery query) {
        return httpClient.get("/payins/recipients", query.toMap(), GetPayinRecipientResponse.class);
    }

    /** Delegated signing step 1 for Register Payin Recipient: returns the challenge to sign out-of-band. */
    public UserActionChallenge registerPayinRecipientInit(Object body) {
        return httpClient.createUserActionChallenge("POST", "/payins/recipients", body);
    }

    /** Delegated signing step 2 for Register Payin Recipient: submits the signed challenge and issues the request. */
    public RegisterPayinRecipientResponse registerPayinRecipientComplete(Object body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/payins/recipients", java.util.Map.of(), body, RegisterPayinRecipientResponse.class, userAction);
    }

    /** Get Payin Status */
    public Object getPayinStatus(String payinId) {
        return httpClient.get("/payins/" + payinId, java.util.Map.of(), Object.class);
    }

    /** List Payin Balances */
    public ListPayinBalancesResponse listPayinBalances(ListPayinBalancesQuery query) {
        return httpClient.get("/payins/balances", query.toMap(), ListPayinBalancesResponse.class);
    }
}
