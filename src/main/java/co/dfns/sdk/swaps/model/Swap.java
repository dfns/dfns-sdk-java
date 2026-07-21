package co.dfns.sdk.swaps.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Swap(
    @JsonProperty("id") String id,
    @JsonProperty("quoteId") String quoteId,
    @JsonProperty("reference") Object reference,
    @JsonProperty("walletId") String walletId,
    @JsonProperty("targetWalletId") String targetWalletId,
    @JsonProperty("status") String status,
    @JsonProperty("provider") String provider,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("feeSponsorId") String feeSponsorId,
    @JsonProperty("quotedSourceAsset") Object quotedSourceAsset,
    @JsonProperty("quotedTargetAsset") Object quotedTargetAsset,
    @JsonProperty("slippageBps") double slippageBps,
    @JsonProperty("dateCreated") String dateCreated,
    @JsonProperty("requestBody") Object requestBody,
    @JsonProperty("requester") Requester requester,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("failureReason") String failureReason,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("protocolStatus") String protocolStatus
) {}
