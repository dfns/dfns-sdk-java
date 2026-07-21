package co.dfns.sdk.vaults.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ListVaultAssetsResponse(
    @JsonProperty("items") List<VaultAsset> items,
    @JsonProperty("netWorth") VaultNetWorth netWorth
) {}
