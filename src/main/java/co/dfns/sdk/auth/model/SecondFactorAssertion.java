package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SecondFactorAssertion(
    @JsonProperty("kind") String kind,
    @JsonProperty("credentialAssertion") Map<String, Object> credentialAssertion
) {}
