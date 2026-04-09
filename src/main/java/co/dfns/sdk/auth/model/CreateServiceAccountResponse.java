package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateServiceAccountResponse(
    @JsonProperty("userInfo") Map<String, Object> userInfo,
    @JsonProperty("accessTokens") List<PersonalAccessToken> accessTokens
) {}
