package co.dfns.sdk.permissions.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreatePermissionRequest(
    @JsonProperty("name") String name,
    @JsonProperty("operations") List<Object> operations
) {}
