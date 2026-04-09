package co.dfns.sdk.keys.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DelegateKeyRequest(
    @JsonProperty("delegateTo") String delegateTo
) {}
