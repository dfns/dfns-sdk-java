package co.dfns.sdk.permissions.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UpdatePermissionRequest(
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("name") String name,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("operations") List<Object> operations
) {}
