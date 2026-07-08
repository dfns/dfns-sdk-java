package co.dfns.sdk.vaults.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VaultNetWorth(
    @JsonProperty("available") Map<String, Object> available,
    @JsonProperty("quarantined") Map<String, Object> quarantined,
    @JsonProperty("locked") Map<String, Object> locked,
    @JsonProperty("total") Map<String, Object> total
) {}
