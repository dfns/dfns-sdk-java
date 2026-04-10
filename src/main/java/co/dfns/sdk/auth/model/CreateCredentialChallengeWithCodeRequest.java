package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateCredentialChallengeWithCodeRequest(
    @JsonProperty("credentialKind") String credentialKind,
    @JsonProperty("code") String code
) {}
