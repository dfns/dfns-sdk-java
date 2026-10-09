package co.dfns.sdk.vaults.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VaultHistoryEvent(
    @JsonProperty("id") String id,
    @JsonProperty("vaultId") String vaultId,
    @JsonProperty("walletId") String walletId,
    @JsonProperty("timestamp") String timestamp,
    @JsonProperty("network") Network network,
    @JsonProperty("tid") String tid,
    @JsonProperty("amount") String amount,
    @JsonProperty("kind") String kind,
    @JsonProperty("status") String status,
    @JsonProperty("quarantine") VaultQuarantine quarantine,
    @JsonProperty("incomingTransfer") VaultHistoryIncomingTransfer incomingTransfer
) {}
