package co.dfns.sdk.payins.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RequestPayinQuoteResponse(
    @JsonProperty("provider") String provider,
    @JsonProperty("currency") String currency,
    @JsonProperty("network") Network network,
    @JsonProperty("tid") String tid,
    @JsonProperty("timestamp") String timestamp,
    @JsonProperty("quotes") List<Map<String, Object>> quotes
) {}
