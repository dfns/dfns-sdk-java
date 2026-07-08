package co.dfns.sdk.vaults.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VaultAsset(
    @JsonProperty("kind") String kind,
    @JsonProperty("network") String network,
    @JsonProperty("tid") String tid,
    @JsonProperty("decimals") double decimals,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("symbol") String symbol,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("verified") Boolean verified,
    @JsonProperty("availableBalance") String availableBalance,
    @JsonProperty("quarantinedBalance") String quarantinedBalance,
    @JsonProperty("lockedBalance") String lockedBalance,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("quotes") Map<String, Object> quotes
) {}
