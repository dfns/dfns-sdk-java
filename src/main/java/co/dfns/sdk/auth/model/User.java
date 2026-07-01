package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record User(
    @JsonProperty("username") String username,
    @JsonProperty("name") String name,
    @JsonProperty("userId") String userId,
    @JsonProperty("kind") String kind,
    @JsonProperty("credentialUuid") String credentialUuid,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("orgId") String orgId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("tenantId") String tenantId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("permissions") List<String> permissions,
    @JsonProperty("isActive") Boolean isActive,
    @JsonProperty("isServiceAccount") Boolean isServiceAccount,
    @JsonProperty("isRegistered") Boolean isRegistered,
    @JsonProperty("isSSORequired") Boolean isSSORequired,
    @JsonProperty("permissionAssignments") List<Map<String, Object>> permissionAssignments
) {}
