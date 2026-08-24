package co.dfns.sdk.addresswatches;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.addresswatches.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.Map;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedAddressWatchesClient {
    private final DfnsHttpClient httpClient;

    public DelegatedAddressWatchesClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Address Watches */
    public PaginatedList<AddressWatch> listAddressWatches(ListAddressWatchesQuery query) {
        return httpClient.get("/address-watches", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<AddressWatch>>() {});
    }

    /** Delegated signing step 1 for Create Address Watch: returns the challenge to sign out-of-band. */
    public UserActionChallenge createAddressWatchInit(CreateAddressWatchRequest body) {
        return httpClient.createUserActionChallenge("POST", "/address-watches", body);
    }

    /** Delegated signing step 2 for Create Address Watch: submits the signed challenge and issues the request. */
    public AddressWatch createAddressWatchComplete(CreateAddressWatchRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/address-watches", java.util.Map.of(), body, AddressWatch.class, userAction);
    }

    /** Get Address Watch */
    public AddressWatch getAddressWatch(String addressWatchId) {
        return httpClient.get("/address-watches/" + addressWatchId, java.util.Map.of(), AddressWatch.class);
    }

    /** Delegated signing step 1 for Delete Address Watch: returns the challenge to sign out-of-band. */
    public UserActionChallenge deleteAddressWatchInit(String addressWatchId) {
        return httpClient.createUserActionChallenge("DELETE", "/address-watches/" + addressWatchId, null);
    }

    /** Delegated signing step 2 for Delete Address Watch: submits the signed challenge and issues the request. */
    public AddressWatch deleteAddressWatchComplete(String addressWatchId, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("DELETE", "/address-watches/" + addressWatchId, java.util.Map.of(), null, AddressWatch.class, userAction);
    }

    /** Get Address Watch Assets */
    public GetAddressWatchAssetsResponse getAddressWatchAssets(String addressWatchId, GetAddressWatchAssetsQuery query) {
        return httpClient.get("/address-watches/" + addressWatchId + "/assets", query.toMap(), GetAddressWatchAssetsResponse.class);
    }

    /** Get Address Watch Blockchain Events */
    public GetAddressWatchBlockchainEventsResponse getAddressWatchBlockchainEvents(String addressWatchId, GetAddressWatchBlockchainEventsQuery query) {
        return httpClient.get("/address-watches/" + addressWatchId + "/blockchain-events", query.toMap(), GetAddressWatchBlockchainEventsResponse.class);
    }

    /** Get Address Watch History */
    public GetAddressWatchHistoryResponse getAddressWatchHistory(String addressWatchId, GetAddressWatchHistoryQuery query) {
        return httpClient.get("/address-watches/" + addressWatchId + "/history", query.toMap(), GetAddressWatchHistoryResponse.class);
    }
}
