package co.dfns.sdk.permissions.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AssignPermissionResponse(
    @JsonProperty("id") String id,
    @JsonProperty("permissionId") String permissionId,
    @JsonProperty("identityId") String identityId,
    @JsonProperty("isImmutable") Boolean isImmutable,
    @JsonProperty("dateCreated") String dateCreated,
    @JsonProperty("dateUpdated") String dateUpdated
) {}
