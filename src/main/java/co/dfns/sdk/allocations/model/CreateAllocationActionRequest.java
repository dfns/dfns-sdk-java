package co.dfns.sdk.allocations.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateAllocationActionRequest(
    @JsonProperty("kind") String kind,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("externalId") String externalId,
    @JsonProperty("sourceAsset") Map<String, Object> sourceAsset,
    @JsonProperty("targetAsset") Map<String, Object> targetAsset,
    @JsonProperty("slippageBps") double slippageBps
) {}
