package co.dfns.sdk.agreements;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.agreements.model.*;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedAgreementsAsyncClient {
    private final DfnsHttpClient httpClient;

    public DelegatedAgreementsAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Get Latest Unaccepted Agreement */
    public CompletableFuture<GetLatestUnacceptedAgreementResponse> getLatestUnacceptedAgreement(GetLatestUnacceptedAgreementQuery query) {
        return httpClient.getAsync("/agreements/latest-unaccepted", query.toMap(), GetLatestUnacceptedAgreementResponse.class);
    }

    /** Delegated signing step 1 for Record Agreement Acceptance: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> recordAgreementAcceptanceInit(String agreementId) {
        return httpClient.createUserActionChallengeAsync("POST", "/agreements/" + agreementId + "/accept", null);
    }

    /** Delegated signing step 2 for Record Agreement Acceptance: submits the signed challenge and issues the request. */
    public CompletableFuture<RecordAgreementAcceptanceResponse> recordAgreementAcceptanceComplete(String agreementId, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/agreements/" + agreementId + "/accept", java.util.Map.of(), null, RecordAgreementAcceptanceResponse.class, userAction));
    }
}
