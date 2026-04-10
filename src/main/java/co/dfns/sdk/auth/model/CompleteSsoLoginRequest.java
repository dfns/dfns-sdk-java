package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CompleteSsoLoginRequest(
    @JsonProperty("code") String code,
    @JsonProperty("state") String state
) {}
