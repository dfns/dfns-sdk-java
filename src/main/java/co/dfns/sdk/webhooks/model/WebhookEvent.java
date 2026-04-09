package co.dfns.sdk.webhooks.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WebhookEvent(
    @JsonProperty("id") String id,
    @JsonProperty("date") String date,
    @JsonProperty("kind") String kind,
    @JsonProperty("data") Map<String, Object> data,
    @JsonProperty("status") String status,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("error") String error,
    @JsonProperty("timestampSent") long timestampSent
) {}
