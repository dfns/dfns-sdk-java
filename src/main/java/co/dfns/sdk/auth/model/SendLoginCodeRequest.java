package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SendLoginCodeRequest(
    @JsonProperty("username") String username,
    @JsonProperty("orgId") String orgId
) {}
