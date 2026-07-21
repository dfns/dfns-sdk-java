package co.dfns.sdk.vaults.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VaultAddress(
    @JsonProperty("walletId") String walletId,
    @JsonProperty("network") String network,
    @JsonProperty("address") String address
) {}
