package co.dfns.sdk.agreements;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.agreements.model.*;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class AgreementsAsyncClient {
    private final DfnsHttpClient httpClient;

    public AgreementsAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Get Latest Unaccepted Agreement */
    public CompletableFuture<GetLatestUnacceptedAgreementResponse> getLatestUnacceptedAgreement(GetLatestUnacceptedAgreementQuery query) {
        return httpClient.getAsync("/agreements/latest-unaccepted", query.toMap(), GetLatestUnacceptedAgreementResponse.class);
    }

    /** Record Agreement Acceptance */
    public CompletableFuture<RecordAgreementAcceptanceResponse> recordAgreementAcceptance(String agreementId) {
        return httpClient.postAsync("/agreements/" + agreementId + "/accept", java.util.Map.of(), null, RecordAgreementAcceptanceResponse.class, true);
    }
}
