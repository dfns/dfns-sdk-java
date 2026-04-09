package co.dfns.sdk.exchanges.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateExchangeRequest(
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("name") String name,
    @JsonProperty("kind") String kind,
    @JsonProperty("readConfiguration") Map<String, Object> readConfiguration,
    @JsonProperty("writeConfiguration") Map<String, Object> writeConfiguration
) {}
