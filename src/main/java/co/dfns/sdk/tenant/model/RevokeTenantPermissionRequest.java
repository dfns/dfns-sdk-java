package co.dfns.sdk.tenant.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RevokeTenantPermissionRequest(
    @JsonProperty("identityId") String identityId
) {}
