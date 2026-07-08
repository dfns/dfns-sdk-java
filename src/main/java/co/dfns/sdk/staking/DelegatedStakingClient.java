package co.dfns.sdk.staking;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.staking.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.Map;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedStakingClient {
    private final DfnsHttpClient httpClient;

    public DelegatedStakingClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Stakes */
    public PaginatedList<Stake> listStakes(ListStakesQuery query) {
        return httpClient.get("/staking/stakes", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Stake>>() {});
    }

    /** Delegated signing step 1 for Create Stake: returns the challenge to sign out-of-band. */
    public UserActionChallenge createStakeInit(Object body) {
        return httpClient.createUserActionChallenge("POST", "/staking/stakes", body);
    }

    /** Delegated signing step 2 for Create Stake: submits the signed challenge and issues the request. */
    public Stake createStakeComplete(Object body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/staking/stakes", java.util.Map.of(), body, Stake.class, userAction);
    }

    /** List Stake Actions */
    public PaginatedList<StakeAction> listStakeActions(String stakeId, ListStakeActionsQuery query) {
        return httpClient.get("/staking/stakes/" + stakeId + "/actions", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<StakeAction>>() {});
    }

    /** Delegated signing step 1 for Create Stake Action: returns the challenge to sign out-of-band. */
    public UserActionChallenge createStakeActionInit(String stakeId, Object body) {
        return httpClient.createUserActionChallenge("POST", "/staking/stakes/" + stakeId + "/actions", body);
    }

    /** Delegated signing step 2 for Create Stake Action: submits the signed challenge and issues the request. */
    public Stake createStakeActionComplete(String stakeId, Object body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/staking/stakes/" + stakeId + "/actions", java.util.Map.of(), body, Stake.class, userAction);
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
