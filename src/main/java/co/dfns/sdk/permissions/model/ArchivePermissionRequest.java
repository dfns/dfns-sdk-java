package co.dfns.sdk.permissions.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ArchivePermissionRequest(
    @JsonProperty("isArchived") Boolean isArchived
) {}
