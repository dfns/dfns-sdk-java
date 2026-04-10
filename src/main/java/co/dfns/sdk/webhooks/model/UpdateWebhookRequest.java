package co.dfns.sdk.webhooks.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UpdateWebhookRequest(
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("url") String url,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("description") String description,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("events") List<Object> events,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("status") String status
) {}
