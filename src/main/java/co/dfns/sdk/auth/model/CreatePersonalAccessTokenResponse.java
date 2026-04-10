package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreatePersonalAccessTokenResponse(
    @JsonProperty("accessToken") String accessToken,
    @JsonProperty("dateCreated") String dateCreated,
    @JsonProperty("credId") String credId,
    @JsonProperty("isActive") Boolean isActive,
    @JsonProperty("kind") String kind,
    @JsonProperty("linkedUserId") String linkedUserId,
    @JsonProperty("linkedAppId") String linkedAppId,
    @JsonProperty("name") String name,
    @JsonProperty("orgId") String orgId,
    @JsonProperty("publicKey") String publicKey,
    @JsonProperty("tokenId") String tokenId,
    @JsonProperty("permissionAssignments") List<Map<String, Object>> permissionAssignments
) {}
