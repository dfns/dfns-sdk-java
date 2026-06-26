package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateLoginChallengeRequest(
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("username") String username,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("orgId") String orgId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("tenantId") String tenantId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("loginCode") String loginCode
) {}
