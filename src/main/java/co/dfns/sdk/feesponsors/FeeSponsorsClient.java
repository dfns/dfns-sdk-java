package co.dfns.sdk.feesponsors;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.feesponsors.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.Map;

public class FeeSponsorsClient {
    private final DfnsHttpClient httpClient;

    public FeeSponsorsClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Fee Sponsors */
    public PaginatedList<FeeSponsor> listFeeSponsors(ListFeeSponsorsQuery query) {
        return httpClient.get("/fee-sponsors", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<FeeSponsor>>() {});
    }

    /** Create Fee Sponsor */
    public FeeSponsor createFeeSponsor(CreateFeeSponsorRequest body) {
        return httpClient.post("/fee-sponsors", java.util.Map.of(), body, FeeSponsor.class, true);
    }

    /** Get Fee Sponsor */
    public FeeSponsor getFeeSponsor(String feeSponsorId) {
        return httpClient.get("/fee-sponsors/" + feeSponsorId, java.util.Map.of(), FeeSponsor.class);
    }

    /** Delete Fee Sponsor */
    public FeeSponsor deleteFeeSponsor(String feeSponsorId) {
        return httpClient.delete("/fee-sponsors/" + feeSponsorId, java.util.Map.of(), null, FeeSponsor.class, true);
    }

    /** Deactivate Fee Sponsor */
    public FeeSponsor deactivateFeeSponsor(String feeSponsorId) {
        return httpClient.put("/fee-sponsors/" + feeSponsorId + "/deactivate", java.util.Map.of(), null, FeeSponsor.class, true);
    }

    /** Activate Fee Sponsor */
    public FeeSponsor activateFeeSponsor(String feeSponsorId) {
        return httpClient.put("/fee-sponsors/" + feeSponsorId + "/activate", java.util.Map.of(), null, FeeSponsor.class, true);
    }

    /** List Sponsored Fees */
    public ListSponsoredFeesResponse listSponsoredFees(String feeSponsorId, ListSponsoredFeesQuery query) {
        return httpClient.get("/fee-sponsors/" + feeSponsorId + "/fees", query.toMap(), ListSponsoredFeesResponse.class);
    }
}
