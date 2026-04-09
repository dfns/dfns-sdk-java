package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateCredentialCodeResponse(
    @JsonProperty("code") String code,
    @JsonProperty("expiration") String expiration
) {}
