package co.dfns.sdk.feesponsors;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.feesponsors.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class FeeSponsorsAsyncClient {
    private final DfnsHttpClient httpClient;

    public FeeSponsorsAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Fee Sponsors */
    public CompletableFuture<PaginatedList<FeeSponsor>> listFeeSponsors(ListFeeSponsorsQuery query) {
        return httpClient.getAsync("/fee-sponsors", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<FeeSponsor>>() {});
    }

    /** Create Fee Sponsor */
    public CompletableFuture<FeeSponsor> createFeeSponsor(CreateFeeSponsorRequest body) {
        return httpClient.postAsync("/fee-sponsors", java.util.Map.of(), body, FeeSponsor.class, true);
    }

    /** Get Fee Sponsor */
    public CompletableFuture<FeeSponsor> getFeeSponsor(String feeSponsorId) {
        return httpClient.getAsync("/fee-sponsors/" + feeSponsorId, java.util.Map.of(), FeeSponsor.class);
    }

    /** Delete Fee Sponsor */
    public CompletableFuture<FeeSponsor> deleteFeeSponsor(String feeSponsorId) {
        return httpClient.deleteAsync("/fee-sponsors/" + feeSponsorId, java.util.Map.of(), null, FeeSponsor.class, true);
    }

    /** Deactivate Fee Sponsor */
    public CompletableFuture<FeeSponsor> deactivateFeeSponsor(String feeSponsorId) {
        return httpClient.putAsync("/fee-sponsors/" + feeSponsorId + "/deactivate", java.util.Map.of(), null, FeeSponsor.class, true);
    }

    /** Activate Fee Sponsor */
    public CompletableFuture<FeeSponsor> activateFeeSponsor(String feeSponsorId) {
        return httpClient.putAsync("/fee-sponsors/" + feeSponsorId + "/activate", java.util.Map.of(), null, FeeSponsor.class, true);
    }

    /** List Sponsored Fees */
    public CompletableFuture<ListSponsoredFeesResponse> listSponsoredFees(String feeSponsorId, ListSponsoredFeesQuery query) {
        return httpClient.getAsync("/fee-sponsors/" + feeSponsorId + "/fees", query.toMap(), ListSponsoredFeesResponse.class);
    }
}
