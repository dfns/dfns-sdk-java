package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SocialLoginRequest(
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("orgId") String orgId,
    @JsonProperty("socialLoginProviderKind") String socialLoginProviderKind,
    @JsonProperty("idToken") String idToken
) {}
