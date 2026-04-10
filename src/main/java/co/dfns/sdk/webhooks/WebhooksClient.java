package co.dfns.sdk.webhooks;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.webhooks.model.*;
import java.util.Map;
import java.util.List;
import co.dfns.sdk.PaginatedList;

public class WebhooksClient {
    private final DfnsHttpClient httpClient;

    public WebhooksClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Webhooks */
    public ListWebhooksResponse listWebhooks(ListWebhooksQuery query) {
        return httpClient.get("/webhooks", query.toMap(), ListWebhooksResponse.class);
    }

    /** Create Webhook */
    public Webhook createWebhook(CreateWebhookRequest body) {
        return httpClient.post("/webhooks", java.util.Map.of(), body, Webhook.class, true);
    }

    /** Get Webhook */
    public Webhook getWebhook(String webhookId) {
        return httpClient.get("/webhooks/" + webhookId, java.util.Map.of(), Webhook.class);
    }

    /** Update Webhook */
    public Webhook updateWebhook(String webhookId, UpdateWebhookRequest body) {
        return httpClient.put("/webhooks/" + webhookId, java.util.Map.of(), body, Webhook.class, true);
    }

    /** Delete Webhook */
    public DeleteWebhookResponse deleteWebhook(String webhookId) {
        return httpClient.delete("/webhooks/" + webhookId, java.util.Map.of(), null, DeleteWebhookResponse.class, true);
    }

    /** Ping Webhook */
    public PingWebhookResponse pingWebhook(String webhookId) {
        return httpClient.post("/webhooks/" + webhookId + "/ping", java.util.Map.of(), null, PingWebhookResponse.class, true);
    }

    /** Get Webhook Event */
    public WebhookEvent getWebhookEvent(String webhookId, String webhookEventId) {
        return httpClient.get("/webhooks/" + webhookId + "/events/" + webhookEventId, java.util.Map.of(), WebhookEvent.class);
    }

    /** List Webhook Events */
    public PaginatedList<WebhookEvent> listWebhookEvents(String webhookId, ListWebhookEventsQuery query) {
        return httpClient.get("/webhooks/" + webhookId + "/events", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<WebhookEvent>>() {});
    }
}
