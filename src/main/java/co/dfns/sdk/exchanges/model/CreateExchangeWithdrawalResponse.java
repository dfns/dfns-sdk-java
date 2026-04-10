package co.dfns.sdk.exchanges.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateExchangeWithdrawalResponse(
    @JsonProperty("id") String id,
    @JsonProperty("exchangeId") String exchangeId,
    @JsonProperty("accountId") String accountId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("transferId") String transferId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("exchangeReference") String exchangeReference,
    @JsonProperty("kind") String kind,
    @JsonProperty("walletId") String walletId,
    @JsonProperty("requester") Requester requester,
    @JsonProperty("requestBody") Object requestBody,
    @JsonProperty("dateCreated") String dateCreated
) {}
