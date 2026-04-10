package co.dfns.sdk.staking;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.staking.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.Map;

public class StakingClient {
    private final DfnsHttpClient httpClient;

    public StakingClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Stakes */
    public PaginatedList<Stake> listStakes(ListStakesQuery query) {
        return httpClient.get("/staking/stakes", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Stake>>() {});
    }

    /** Create Stake */
    public Stake createStake(Object body) {
        return httpClient.post("/staking/stakes", java.util.Map.of(), body, Stake.class, true);
    }

    /** List Stake Actions */
    public PaginatedList<StakeAction> listStakeActions(String stakeId, ListStakeActionsQuery query) {
        return httpClient.get("/staking/stakes/" + stakeId + "/actions", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<StakeAction>>() {});
    }

    /** Create Stake Action */
    public Stake createStakeAction(String stakeId, Object body) {
        return httpClient.post("/staking/stakes/" + stakeId + "/actions", java.util.Map.of(), body, Stake.class, true);
    }

    /** Get Stakes */
    public Stake getStakes(String stakeId, GetStakesQuery query) {
        return httpClient.get("/staking/stakes/" + stakeId, query.toMap(), Stake.class);
    }

    /** Get Stake Rewards */
    public GetStakeRewardsResponse getStakeRewards(String stakeId) {
        return httpClient.get("/staking/stakes/" + stakeId + "/rewards", java.util.Map.of(), GetStakeRewardsResponse.class);
    }
}
