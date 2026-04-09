package co.dfns.sdk.payouts.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RequestPayoutQuoteResponse(
    @JsonProperty("provider") String provider,
    @JsonProperty("asset") Object asset,
    @JsonProperty("timestamp") String timestamp,
    @JsonProperty("quotes") List<Map<String, Object>> quotes
) {}
