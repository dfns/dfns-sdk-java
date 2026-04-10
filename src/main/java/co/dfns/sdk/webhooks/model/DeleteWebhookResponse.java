package co.dfns.sdk.webhooks.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DeleteWebhookResponse(
    @JsonProperty("deleted") String deleted
) {}
