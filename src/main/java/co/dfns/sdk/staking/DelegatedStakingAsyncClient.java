package co.dfns.sdk.staking;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.staking.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedStakingAsyncClient {
    private final DfnsHttpClient httpClient;

    public DelegatedStakingAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Stakes */
    public CompletableFuture<PaginatedList<Stake>> listStakes(ListStakesQuery query) {
        return httpClient.getAsync("/staking/stakes", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Stake>>() {});
    }

    /** Delegated signing step 1 for Create Stake: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createStakeInit(Object body) {
        return httpClient.createUserActionChallengeAsync("POST", "/staking/stakes", body);
    }

    /** Delegated signing step 2 for Create Stake: submits the signed challenge and issues the request. */
    public CompletableFuture<Stake> createStakeComplete(Object body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/staking/stakes", java.util.Map.of(), body, Stake.class, userAction));
    }

    /** List Stake Actions */
    public CompletableFuture<PaginatedList<StakeAction>> listStakeActions(String stakeId, ListStakeActionsQuery query) {
        return httpClient.getAsync("/staking/stakes/" + stakeId + "/actions", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<StakeAction>>() {});
    }

    /** Delegated signing step 1 for Create Stake Action: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createStakeActionInit(String stakeId, Object body) {
        return httpClient.createUserActionChallengeAsync("POST", "/staking/stakes/" + stakeId + "/actions", body);
    }

    /** Delegated signing step 2 for Create Stake Action: submits the signed challenge and issues the request. */
    public CompletableFuture<Stake> createStakeActionComplete(String stakeId, Object body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/staking/stakes/" + stakeId + "/actions", java.util.Map.of(), body, Stake.class, userAction));
    }

    /** Get Stakes */
    public CompletableFuture<Stake> getStakes(String stakeId, GetStakesQuery query) {
        return httpClient.getAsync("/staking/stakes/" + stakeId, query.toMap(), Stake.class);
    }

    /** Get Stake Rewards */
    public CompletableFuture<GetStakeRewardsResponse> getStakeRewards(String stakeId) {
        return httpClient.getAsync("/staking/stakes/" + stakeId + "/rewards", java.util.Map.of(), GetStakeRewardsResponse.class);
    }
}
