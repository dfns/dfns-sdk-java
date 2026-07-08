package co.dfns.sdk.agreements;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.agreements.model.*;
import java.util.Map;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedAgreementsClient {
    private final DfnsHttpClient httpClient;

    public DelegatedAgreementsClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Get Latest Unaccepted Agreement */
    public GetLatestUnacceptedAgreementResponse getLatestUnacceptedAgreement(GetLatestUnacceptedAgreementQuery query) {
        return httpClient.get("/agreements/latest-unaccepted", query.toMap(), GetLatestUnacceptedAgreementResponse.class);
    }

    /** Delegated signing step 1 for Record Agreement Acceptance: returns the challenge to sign out-of-band. */
    public UserActionChallenge recordAgreementAcceptanceInit(String agreementId) {
        return httpClient.createUserActionChallenge("POST", "/agreements/" + agreementId + "/accept", null);
    }

    /** Delegated signing step 2 for Record Agreement Acceptance: submits the signed challenge and issues the request. */
    public RecordAgreementAcceptanceResponse recordAgreementAcceptanceComplete(String agreementId, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/agreements/" + agreementId + "/accept", java.util.Map.of(), null, RecordAgreementAcceptanceResponse.class, userAction);
    }
}
