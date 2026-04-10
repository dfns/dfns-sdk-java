package co.dfns.sdk.signers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ListSignersResponse(
    @JsonProperty("clusters") List<Map<String, Object>> clusters
) {}
