package co.dfns.sdk.allocations.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Cancel0fnsOrderPlacementResponse(
    @JsonProperty("transactionId") String transactionId
) {}
