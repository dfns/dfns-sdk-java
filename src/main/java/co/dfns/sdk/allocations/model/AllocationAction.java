package co.dfns.sdk.allocations.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AllocationAction(
    @JsonProperty("id") String id,
    @JsonProperty("allocationId") String allocationId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("externalId") String externalId,
    @JsonProperty("kind") String kind,
    @JsonProperty("status") String status,
    @JsonProperty("requester") Requester requester,
    @JsonProperty("requestBody") Object requestBody,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("failureReason") String failureReason,
    @JsonProperty("dateCreated") String dateCreated
) {}
