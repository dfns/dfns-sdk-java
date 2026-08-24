package co.dfns.sdk.addresswatches;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.addresswatches.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedAddressWatchesAsyncClient {
    private final DfnsHttpClient httpClient;

    public DelegatedAddressWatchesAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Address Watches */
    public CompletableFuture<PaginatedList<AddressWatch>> listAddressWatches(ListAddressWatchesQuery query) {
        return httpClient.getAsync("/address-watches", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<AddressWatch>>() {});
    }

    /** Delegated signing step 1 for Create Address Watch: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createAddressWatchInit(CreateAddressWatchRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/address-watches", body);
    }

    /** Delegated signing step 2 for Create Address Watch: submits the signed challenge and issues the request. */
    public CompletableFuture<AddressWatch> createAddressWatchComplete(CreateAddressWatchRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/address-watches", java.util.Map.of(), body, AddressWatch.class, userAction));
    }

    /** Get Address Watch */
    public CompletableFuture<AddressWatch> getAddressWatch(String addressWatchId) {
        return httpClient.getAsync("/address-watches/" + addressWatchId, java.util.Map.of(), AddressWatch.class);
    }

    /** Delegated signing step 1 for Delete Address Watch: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> deleteAddressWatchInit(String addressWatchId) {
        return httpClient.createUserActionChallengeAsync("DELETE", "/address-watches/" + addressWatchId, null);
    }

    /** Delegated signing step 2 for Delete Address Watch: submits the signed challenge and issues the request. */
    public CompletableFuture<AddressWatch> deleteAddressWatchComplete(String addressWatchId, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("DELETE", "/address-watches/" + addressWatchId, java.util.Map.of(), null, AddressWatch.class, userAction));
    }

    /** Get Address Watch Assets */
    public CompletableFuture<GetAddressWatchAssetsResponse> getAddressWatchAssets(String addressWatchId, GetAddressWatchAssetsQuery query) {
        return httpClient.getAsync("/address-watches/" + addressWatchId + "/assets", query.toMap(), GetAddressWatchAssetsResponse.class);
    }

    /** Get Address Watch Blockchain Events */
    public CompletableFuture<GetAddressWatchBlockchainEventsResponse> getAddressWatchBlockchainEvents(String addressWatchId, GetAddressWatchBlockchainEventsQuery query) {
        return httpClient.getAsync("/address-watches/" + addressWatchId + "/blockchain-events", query.toMap(), GetAddressWatchBlockchainEventsResponse.class);
    }

    /** Get Address Watch History */
    public CompletableFuture<GetAddressWatchHistoryResponse> getAddressWatchHistory(String addressWatchId, GetAddressWatchHistoryQuery query) {
        return httpClient.getAsync("/address-watches/" + addressWatchId + "/history", query.toMap(), GetAddressWatchHistoryResponse.class);
    }
}
