package co.dfns.sdk.exchanges.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DeleteExchangeResponse(
    @JsonProperty("deleted") String deleted
) {}
