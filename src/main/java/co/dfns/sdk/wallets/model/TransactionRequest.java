package co.dfns.sdk.wallets.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TransactionRequest(
    @JsonProperty("id") String id,
    @JsonProperty("walletId") String walletId,
    @JsonProperty("network") Network network,
    @JsonProperty("requester") Requester requester,
    @JsonProperty("requestBody") Object requestBody,
    @JsonProperty("status") String status,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("reason") String reason,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("txHash") String txHash,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("fee") String fee,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("approvalId") String approvalId,
    @JsonProperty("dateRequested") String dateRequested,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("datePolicyResolved") String datePolicyResolved,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("dateBroadcasted") String dateBroadcasted,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("dateConfirmed") String dateConfirmed,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("externalId") String externalId
) {}
