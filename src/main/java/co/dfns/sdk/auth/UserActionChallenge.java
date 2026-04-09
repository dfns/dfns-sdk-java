package co.dfns.sdk.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Challenge returned by POST /auth/action/init that must be signed
 * before a user-action-protected endpoint can be called.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record UserActionChallenge(
    @JsonProperty("challenge") String challenge,
    @JsonProperty("challengeIdentifier") String challengeIdentifier,
    @JsonProperty("externalAuthenticationUrl") String externalAuthenticationUrl,
    @JsonProperty("allowCredentials") java.util.Map<String, Object> allowCredentials
) {}
