package co.dfns.sdk.allocations.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateAllocationQuoteRequest(
    @JsonProperty("walletId") String walletId,
    @JsonProperty("protocol") String protocol,
    @JsonProperty("kind") String kind,
    @JsonProperty("sourceAsset") Map<String, Object> sourceAsset,
    @JsonProperty("targetAsset") Map<String, Object> targetAsset
) {}
