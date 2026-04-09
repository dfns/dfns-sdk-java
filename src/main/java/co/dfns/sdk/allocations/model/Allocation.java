package co.dfns.sdk.allocations.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Allocation(
    @JsonProperty("id") String id,
    @JsonProperty("walletId") String walletId,
    @JsonProperty("protocol") String protocol,
    @JsonProperty("amount") Object amount,
    @JsonProperty("rewards") Object rewards,
    @JsonProperty("dateCreated") String dateCreated
) {}
