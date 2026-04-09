package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateDelegatedRegistrationChallengeResponse(
    @JsonProperty("user") Map<String, Object> user,
    @JsonProperty("temporaryAuthenticationToken") String temporaryAuthenticationToken,
    @JsonProperty("challenge") String challenge,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("rp") Map<String, Object> rp,
    @JsonProperty("supportedCredentialKinds") Map<String, Object> supportedCredentialKinds,
    @JsonProperty("authenticatorSelection") Map<String, Object> authenticatorSelection,
    @JsonProperty("attestation") String attestation,
    @JsonProperty("pubKeyCredParams") List<Map<String, Object>> pubKeyCredParams,
    @JsonProperty("excludeCredentials") List<Map<String, Object>> excludeCredentials,
    @JsonProperty("otpUrl") String otpUrl
) {}
