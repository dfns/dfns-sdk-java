package co.dfns.sdk.payins.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ListPayinBalancesResponse(
    @JsonProperty("items") List<Map<String, Object>> items
) {}
