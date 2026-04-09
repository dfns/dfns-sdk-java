package co.dfns.sdk.webhooks.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateWebhookRequest(
    @JsonProperty("url") String url,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("status") String status,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("description") String description,
    @JsonProperty("events") List<Object> events
) {}
