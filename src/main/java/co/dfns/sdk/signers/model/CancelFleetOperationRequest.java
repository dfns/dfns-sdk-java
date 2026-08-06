package co.dfns.sdk.signers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CancelFleetOperationRequest(
    @JsonProperty("groupId") String groupId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("reason") String reason
) {}
