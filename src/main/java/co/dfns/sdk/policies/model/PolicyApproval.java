package co.dfns.sdk.policies.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PolicyApproval(
    @JsonProperty("id") String id,
    @JsonProperty("initiatorId") String initiatorId,
    @JsonProperty("activity") Object activity,
    @JsonProperty("status") String status,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("expirationDate") String expirationDate,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("dateCreated") String dateCreated,
    @JsonProperty("dateUpdated") String dateUpdated,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("dateResolved") String dateResolved,
    @JsonProperty("policyEvaluations") List<Map<String, Object>> policyEvaluations,
    @JsonProperty("decisions") List<Map<String, Object>> decisions
) {}
