package co.dfns.sdk.policies.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateApprovalDecisionRequest(
    @JsonProperty("value") String value,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("reason") String reason
) {}
