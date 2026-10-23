package co.dfns.sdk.tenant.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RemoveTenantUserGroupMembersRequest(
    @JsonProperty("userIds") List<String> userIds
) {}
