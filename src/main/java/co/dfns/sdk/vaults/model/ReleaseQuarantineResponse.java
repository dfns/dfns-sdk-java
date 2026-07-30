package co.dfns.sdk.vaults.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ReleaseQuarantineResponse(
    @JsonProperty("status") String status
) {}
