package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateRecoveryChallengeRequest(
    @JsonProperty("username") String username,
    @JsonProperty("verificationCode") String verificationCode,
    @JsonProperty("orgId") String orgId,
    @JsonProperty("credentialId") String credentialId
) {}
