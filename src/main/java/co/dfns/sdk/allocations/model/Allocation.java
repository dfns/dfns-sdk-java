package co.dfns.sdk.allocations.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Allocation(
    @JsonProperty("id") String id,
    @JsonProperty("walletId") String walletId,
    @JsonProperty("protocol") String protocol,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("provider") String provider,
    @JsonProperty("amount") Object amount,
    @JsonProperty("rewards") Object rewards,
    @JsonProperty("dateCreated") String dateCreated
) {}
