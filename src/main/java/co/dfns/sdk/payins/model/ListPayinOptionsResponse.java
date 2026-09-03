package co.dfns.sdk.payins.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ListPayinOptionsResponse(
    @JsonProperty("assets") List<String> assets,
    @JsonProperty("currencies") List<Map<String, Object>> currencies
) {}
