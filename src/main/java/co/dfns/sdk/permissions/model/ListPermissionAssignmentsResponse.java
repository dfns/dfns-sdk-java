package co.dfns.sdk.permissions.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ListPermissionAssignmentsResponse(
    @JsonProperty("items") List<Map<String, Object>> items,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("nextPageToken") String nextPageToken
) {}
