package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RecoveryKeyAttestation(
    @JsonProperty("credentialKind") String credentialKind,
    @JsonProperty("credentialInfo") Map<String, Object> credentialInfo,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("encryptedPrivateKey") String encryptedPrivateKey,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("credentialName") String credentialName
) {}
