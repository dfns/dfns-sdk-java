package co.dfns.sdk.vaults.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VaultBalanceEntry(
    @JsonProperty("id") String id,
    @JsonProperty("kind") String kind,
    @JsonProperty("network") String network,
    @JsonProperty("tid") String tid,
    @JsonProperty("amount") String amount,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("transferId") String transferId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("quarantineId") String quarantineId
) {}
