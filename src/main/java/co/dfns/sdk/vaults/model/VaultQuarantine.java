package co.dfns.sdk.vaults.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VaultQuarantine(
    @JsonProperty("id") String id,
    @JsonProperty("vaultId") String vaultId,
    @JsonProperty("network") String network,
    @JsonProperty("transactionHash") String transactionHash,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("kytResult") Object kytResult,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("dateReleased") String dateReleased,
    @JsonProperty("dateCreated") String dateCreated
) {}
