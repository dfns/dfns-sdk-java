package co.dfns.sdk.tenant.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UserGroupMember(
    @JsonProperty("userId") String userId,
    @JsonProperty("username") String username,
    @JsonProperty("kind") String kind,
    @JsonProperty("isActive") Boolean isActive,
    @JsonProperty("isArchived") Boolean isArchived,
    @JsonProperty("isServiceAccount") Boolean isServiceAccount,
    @JsonProperty("dateAdded") String dateAdded
) {}
