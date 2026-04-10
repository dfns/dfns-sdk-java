package co.dfns.sdk.staking;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.staking.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class StakingAsyncClient {
    private final DfnsHttpClient httpClient;

    public StakingAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Stakes */
    public CompletableFuture<PaginatedList<Stake>> listStakes(ListStakesQuery query) {
        return httpClient.getAsync("/staking/stakes", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Stake>>() {});
    }

    /** Create Stake */
    public CompletableFuture<Stake> createStake(Object body) {
        return httpClient.postAsync("/staking/stakes", java.util.Map.of(), body, Stake.class, true);
    }

    /** List Stake Actions */
    public CompletableFuture<PaginatedList<StakeAction>> listStakeActions(String stakeId, ListStakeActionsQuery query) {
        return httpClient.getAsync("/staking/stakes/" + stakeId + "/actions", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<StakeAction>>() {});
    }

    /** Create Stake Action */
    public CompletableFuture<Stake> createStakeAction(String stakeId, Object body) {
        return httpClient.postAsync("/staking/stakes/" + stakeId + "/actions", java.util.Map.of(), body, Stake.class, true);
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
