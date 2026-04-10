package co.dfns.sdk.permissions.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AssignPermissionRequest(
    @JsonProperty("identityId") String identityId
) {}
