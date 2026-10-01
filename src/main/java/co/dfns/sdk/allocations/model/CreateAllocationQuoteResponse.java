package co.dfns.sdk.allocations.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateAllocationQuoteResponse(
    @JsonProperty("walletId") String walletId,
    @JsonProperty("protocol") String protocol,
    @JsonProperty("kind") String kind,
    @JsonProperty("sourceAsset") Object sourceAsset,
    @JsonProperty("targetAsset") Object targetAsset,
    @JsonProperty("estFillTime") long estFillTime,
    @JsonProperty("dateCreated") String dateCreated
) {}
