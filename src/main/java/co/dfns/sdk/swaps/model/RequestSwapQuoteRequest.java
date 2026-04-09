package co.dfns.sdk.swaps.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RequestSwapQuoteRequest(
    @JsonProperty("provider") String provider,
    @JsonProperty("walletId") String walletId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("targetWalletId") String targetWalletId,
    @JsonProperty("sourceAsset") Object sourceAsset,
    @JsonProperty("targetAsset") Object targetAsset,
    @JsonProperty("slippageBps") double slippageBps
) {}
