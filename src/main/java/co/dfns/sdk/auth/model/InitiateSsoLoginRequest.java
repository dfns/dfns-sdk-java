package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InitiateSsoLoginRequest(
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("orgId") String orgId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("tenantId") String tenantId,
    @JsonProperty("clientId") String clientId,
    @JsonProperty("redirectUri") String redirectUri
) {}
