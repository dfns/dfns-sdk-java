package co.dfns.sdk.feesponsors;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.feesponsors.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedFeeSponsorsAsyncClient {
    private final DfnsHttpClient httpClient;

    public DelegatedFeeSponsorsAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Fee Sponsors */
    public CompletableFuture<PaginatedList<FeeSponsor>> listFeeSponsors(ListFeeSponsorsQuery query) {
        return httpClient.getAsync("/fee-sponsors", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<FeeSponsor>>() {});
    }

    /** Delegated signing step 1 for Create Fee Sponsor: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createFeeSponsorInit(CreateFeeSponsorRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/fee-sponsors", body);
    }

    /** Delegated signing step 2 for Create Fee Sponsor: submits the signed challenge and issues the request. */
    public CompletableFuture<FeeSponsor> createFeeSponsorComplete(CreateFeeSponsorRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/fee-sponsors", java.util.Map.of(), body, FeeSponsor.class, userAction));
    }

    /** Get Fee Sponsor */
    public CompletableFuture<FeeSponsor> getFeeSponsor(String feeSponsorId) {
        return httpClient.getAsync("/fee-sponsors/" + feeSponsorId, java.util.Map.of(), FeeSponsor.class);
    }

    /** Delegated signing step 1 for Delete Fee Sponsor: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> deleteFeeSponsorInit(String feeSponsorId) {
        return httpClient.createUserActionChallengeAsync("DELETE", "/fee-sponsors/" + feeSponsorId, null);
    }

    /** Delegated signing step 2 for Delete Fee Sponsor: submits the signed challenge and issues the request. */
    public CompletableFuture<FeeSponsor> deleteFeeSponsorComplete(String feeSponsorId, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("DELETE", "/fee-sponsors/" + feeSponsorId, java.util.Map.of(), null, FeeSponsor.class, userAction));
    }

    /** Delegated signing step 1 for Deactivate Fee Sponsor: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> deactivateFeeSponsorInit(String feeSponsorId) {
        return httpClient.createUserActionChallengeAsync("PUT", "/fee-sponsors/" + feeSponsorId + "/deactivate", null);
    }

    /** Delegated signing step 2 for Deactivate Fee Sponsor: submits the signed challenge and issues the request. */
    public CompletableFuture<FeeSponsor> deactivateFeeSponsorComplete(String feeSponsorId, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("PUT", "/fee-sponsors/" + feeSponsorId + "/deactivate", java.util.Map.of(), null, FeeSponsor.class, userAction));
    }

    /** Delegated signing step 1 for Activate Fee Sponsor: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> activateFeeSponsorInit(String feeSponsorId) {
        return httpClient.createUserActionChallengeAsync("PUT", "/fee-sponsors/" + feeSponsorId + "/activate", null);
    }

    /** Delegated signing step 2 for Activate Fee Sponsor: submits the signed challenge and issues the request. */
    public CompletableFuture<FeeSponsor> activateFeeSponsorComplete(String feeSponsorId, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("PUT", "/fee-sponsors/" + feeSponsorId + "/activate", java.util.Map.of(), null, FeeSponsor.class, userAction));
    }

    /** List Sponsored Fees */
    public CompletableFuture<ListSponsoredFeesResponse> listSponsoredFees(String feeSponsorId, ListSponsoredFeesQuery query) {
        return httpClient.getAsync("/fee-sponsors/" + feeSponsorId + "/fees", query.toMap(), ListSponsoredFeesResponse.class);
    }
}
