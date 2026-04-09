package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateUserActionChallengeResponse(
    @JsonProperty("challenge") String challenge,
    @JsonProperty("challengeIdentifier") String challengeIdentifier,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("rp") Map<String, Object> rp,
    @JsonProperty("supportedCredentialKinds") List<Map<String, Object>> supportedCredentialKinds,
    @JsonProperty("userVerification") String userVerification,
    @JsonProperty("attestation") String attestation,
    @JsonProperty("allowCredentials") Map<String, Object> allowCredentials,
    @JsonProperty("externalAuthenticationUrl") String externalAuthenticationUrl
) {}
