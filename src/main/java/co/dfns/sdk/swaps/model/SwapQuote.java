package co.dfns.sdk.swaps.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SwapQuote(
    @JsonProperty("id") String id,
    @JsonProperty("walletId") String walletId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("targetWalletId") String targetWalletId,
    @JsonProperty("provider") String provider,
    @JsonProperty("sourceAsset") Object sourceAsset,
    @JsonProperty("targetAsset") Object targetAsset,
    @JsonProperty("slippageBps") long slippageBps,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("fee") String fee,
    @JsonProperty("dateCreated") String dateCreated,
    @JsonProperty("requestBody") Object requestBody,
    @JsonProperty("requester") Requester requester
) {}
