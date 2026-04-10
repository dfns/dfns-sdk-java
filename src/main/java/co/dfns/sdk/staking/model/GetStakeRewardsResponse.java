package co.dfns.sdk.staking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GetStakeRewardsResponse(
    @JsonProperty("symbol") String symbol,
    @JsonProperty("balance") String balance
) {}
