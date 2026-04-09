package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GetApplicationResponse(
    @JsonProperty("appId") String appId,
    @JsonProperty("kind") String kind,
    @JsonProperty("orgId") String orgId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("expectedRpId") String expectedRpId,
    @JsonProperty("name") String name,
    @JsonProperty("isActive") Boolean isActive,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("expectedOrigin") String expectedOrigin,
    @JsonProperty("permissionAssignments") List<Map<String, Object>> permissionAssignments,
    @JsonProperty("accessTokens") List<PersonalAccessToken> accessTokens
) {}
