package co.dfns.sdk.policies.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LookupSumsubTravelRuleVaspRequest(
    @JsonProperty("network") Network network,
    @JsonProperty("walletAddress") String walletAddress
) {}
