package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InitiateSsoLoginRequest(
    @JsonProperty("orgId") String orgId,
    @JsonProperty("clientId") String clientId,
    @JsonProperty("redirectUri") String redirectUri
) {}
