package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FirstFactorAttestation(
    @JsonProperty("credentialKind") String credentialKind,
    @JsonProperty("credentialInfo") Map<String, Object> credentialInfo,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("credentialName") String credentialName
) {}
