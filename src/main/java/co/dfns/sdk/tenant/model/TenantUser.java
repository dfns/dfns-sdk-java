package co.dfns.sdk.tenant.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TenantUser(
    @JsonProperty("id") String id,
    @JsonProperty("kind") String kind,
    @JsonProperty("username") String username,
    @JsonProperty("isRegistered") Boolean isRegistered,
    @JsonProperty("isActive") Boolean isActive,
    @JsonProperty("isSSORequired") Boolean isSSORequired,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("externalId") String externalId,
    @JsonProperty("permissions") List<Map<String, Object>> permissions,
    @JsonProperty("orgs") List<Map<String, Object>> orgs
) {}
