package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreatePersonalAccessTokenRequest(
    @JsonProperty("name") String name,
    @JsonProperty("publicKey") String publicKey,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("permissionId") String permissionId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("externalId") String externalId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("daysValid") long daysValid,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("secondsValid") long secondsValid
) {}
