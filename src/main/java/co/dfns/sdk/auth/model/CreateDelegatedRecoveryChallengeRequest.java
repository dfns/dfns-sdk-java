package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateDelegatedRecoveryChallengeRequest(
    @JsonProperty("username") String username,
    @JsonProperty("credentialId") String credentialId
) {}
