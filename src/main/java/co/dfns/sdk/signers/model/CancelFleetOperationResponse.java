package co.dfns.sdk.signers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CancelFleetOperationResponse(
    @JsonProperty("groupId") String groupId,
    @JsonProperty("storeId") String storeId,
    @JsonProperty("orgId") String orgId,
    @JsonProperty("status") String status,
    @JsonProperty("createdBy") String createdBy,
    @JsonProperty("submittedBy") Object submittedBy,
    @JsonProperty("dateSubmitted") Object dateSubmitted,
    @JsonProperty("reviewedBy") Object reviewedBy,
    @JsonProperty("dateReviewed") Object dateReviewed,
    @JsonProperty("canceledBy") Object canceledBy,
    @JsonProperty("dateCanceled") Object dateCanceled,
    @JsonProperty("reason") Object reason,
    @JsonProperty("dateCreated") String dateCreated,
    @JsonProperty("operations") List<Map<String, Object>> operations
) {}
