package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateRegistrationChallengeRequest(
    @JsonProperty("orgId") String orgId,
    @JsonProperty("username") String username,
    @JsonProperty("registrationCode") String registrationCode
) {}
