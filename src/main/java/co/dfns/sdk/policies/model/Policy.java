package co.dfns.sdk.policies.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Policy(
    @JsonProperty("id") String id,
    @JsonProperty("name") String name,
    @JsonProperty("status") String status,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("dateCreated") String dateCreated,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("dateUpdated") String dateUpdated,
    @JsonProperty("activityKind") String activityKind,
    @JsonProperty("rule") Map<String, Object> rule,
    @JsonProperty("action") Object action,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("filters") Map<String, Object> filters
) {}
