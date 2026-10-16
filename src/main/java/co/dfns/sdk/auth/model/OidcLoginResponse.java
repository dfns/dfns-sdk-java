package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OidcLoginResponse(
    @JsonProperty("token") String token,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("expiry") double expiry,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("identity") Map<String, Object> identity,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("credentialChallenge") Map<String, Object> credentialChallenge
) {}
