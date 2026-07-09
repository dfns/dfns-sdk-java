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
}
