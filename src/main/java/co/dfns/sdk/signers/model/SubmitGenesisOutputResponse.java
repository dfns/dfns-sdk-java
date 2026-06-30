package co.dfns.sdk.signers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubmitGenesisOutputResponse(
    @JsonProperty("message") String message
) {}
