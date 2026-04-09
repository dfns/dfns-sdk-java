package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CompleteUserLoginRequest(
    @JsonProperty("challengeIdentifier") String challengeIdentifier,
    @JsonProperty("firstFactor") FirstFactorAssertion firstFactor,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("secondFactor") SecondFactorAssertion secondFactor
) {}
