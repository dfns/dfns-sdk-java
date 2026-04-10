package co.dfns.sdk.agreements;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.agreements.model.*;
import java.util.Map;

public class AgreementsClient {
    private final DfnsHttpClient httpClient;

    public AgreementsClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Get Latest Unaccepted Agreement */
    public GetLatestUnacceptedAgreementResponse getLatestUnacceptedAgreement(GetLatestUnacceptedAgreementQuery query) {
        return httpClient.get("/agreements/latest-unaccepted", query.toMap(), GetLatestUnacceptedAgreementResponse.class);
    }

    /** Record Agreement Acceptance */
    public RecordAgreementAcceptanceResponse recordAgreementAcceptance(String agreementId) {
        return httpClient.post("/agreements/" + agreementId + "/accept", java.util.Map.of(), null, RecordAgreementAcceptanceResponse.class, true);
    }
}
