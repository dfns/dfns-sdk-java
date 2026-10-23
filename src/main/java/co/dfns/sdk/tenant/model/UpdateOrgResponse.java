package co.dfns.sdk.tenant.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UpdateOrgResponse(
    @JsonProperty("org") Map<String, Object> org
) {}
