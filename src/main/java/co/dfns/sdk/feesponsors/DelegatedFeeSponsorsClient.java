package co.dfns.sdk.feesponsors;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.feesponsors.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.Map;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedFeeSponsorsClient {
    private final DfnsHttpClient httpClient;

    public DelegatedFeeSponsorsClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Fee Sponsors */
    public PaginatedList<FeeSponsor> listFeeSponsors(ListFeeSponsorsQuery query) {
        return httpClient.get("/fee-sponsors", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<FeeSponsor>>() {});
    }

    /** Delegated signing step 1 for Create Fee Sponsor: returns the challenge to sign out-of-band. */
    public UserActionChallenge createFeeSponsorInit(CreateFeeSponsorRequest body) {
        return httpClient.createUserActionChallenge("POST", "/fee-sponsors", body);
    }

    /** Delegated signing step 2 for Create Fee Sponsor: submits the signed challenge and issues the request. */
    public FeeSponsor createFeeSponsorComplete(CreateFeeSponsorRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/fee-sponsors", java.util.Map.of(), body, FeeSponsor.class, userAction);
    }

    /** Get Fee Sponsor */
    public FeeSponsor getFeeSponsor(String feeSponsorId) {
        return httpClient.get("/fee-sponsors/" + feeSponsorId, java.util.Map.of(), FeeSponsor.class);
    }

    /** Delegated signing step 1 for Delete Fee Sponsor: returns the challenge to sign out-of-band. */
    public UserActionChallenge deleteFeeSponsorInit(String feeSponsorId) {
        return httpClient.createUserActionChallenge("DELETE", "/fee-sponsors/" + feeSponsorId, null);
    }

    /** Delegated signing step 2 for Delete Fee Sponsor: submits the signed challenge and issues the request. */
    public FeeSponsor deleteFeeSponsorComplete(String feeSponsorId, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("DELETE", "/fee-sponsors/" + feeSponsorId, java.util.Map.of(), null, FeeSponsor.class, userAction);
    }

    /** Delegated signing step 1 for Deactivate Fee Sponsor: returns the challenge to sign out-of-band. */
    public UserActionChallenge deactivateFeeSponsorInit(String feeSponsorId) {
        return httpClient.createUserActionChallenge("PUT", "/fee-sponsors/" + feeSponsorId + "/deactivate", null);
    }

    /** Delegated signing step 2 for Deactivate Fee Sponsor: submits the signed challenge and issues the request. */
    public FeeSponsor deactivateFeeSponsorComplete(String feeSponsorId, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/fee-sponsors/" + feeSponsorId + "/deactivate", java.util.Map.of(), null, FeeSponsor.class, userAction);
    }

    /** Delegated signing step 1 for Activate Fee Sponsor: returns the challenge to sign out-of-band. */
    public UserActionChallenge activateFeeSponsorInit(String feeSponsorId) {
        return httpClient.createUserActionChallenge("PUT", "/fee-sponsors/" + feeSponsorId + "/activate", null);
    }

    /** Delegated signing step 2 for Activate Fee Sponsor: submits the signed challenge and issues the request. */
    public FeeSponsor activateFeeSponsorComplete(String feeSponsorId, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/fee-sponsors/" + feeSponsorId + "/activate", java.util.Map.of(), null, FeeSponsor.class, userAction);
    }

    /** List Sponsored Fees */
    public ListSponsoredFeesResponse listSponsoredFees(String feeSponsorId, ListSponsoredFeesQuery query) {
        return httpClient.get("/fee-sponsors/" + feeSponsorId + "/fees", query.toMap(), ListSponsoredFeesResponse.class);
    }
}
