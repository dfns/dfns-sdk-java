package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RecoverUserRequest(
    @JsonProperty("recovery") Map<String, Object> recovery,
    @JsonProperty("newCredentials") Map<String, Object> newCredentials
) {}
