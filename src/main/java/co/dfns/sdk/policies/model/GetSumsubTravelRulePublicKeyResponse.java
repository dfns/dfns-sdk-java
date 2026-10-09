package co.dfns.sdk.policies.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GetSumsubTravelRulePublicKeyResponse(
    @JsonProperty("kty") String kty,
    @JsonProperty("kid") String kid,
    @JsonProperty("n") String n,
    @JsonProperty("e") String e,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("use") String use
) {}
