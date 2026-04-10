package co.dfns.sdk.staking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record StakeAction(
    @JsonProperty("id") String id,
    @JsonProperty("stakeId") String stakeId,
    @JsonProperty("status") String status,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("transactionId") String transactionId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("signatureId") String signatureId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("transactionHash") String transactionHash,
    @JsonProperty("kind") String kind,
    @JsonProperty("requester") Requester requester,
    @JsonProperty("requestBody") Object requestBody,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("failureReason") String failureReason,
    @JsonProperty("dateCreated") String dateCreated
) {}
