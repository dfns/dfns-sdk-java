package co.dfns.sdk.vaults.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateVaultTransferRequest(
    @JsonProperty("network") String network,
    @JsonProperty("tid") String tid,
    @JsonProperty("to") String to,
    @JsonProperty("amount") String amount,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("externalId") String externalId
) {}
