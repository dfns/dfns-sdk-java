package co.dfns.sdk.webhooks;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.webhooks.model.*;
import java.util.Map;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.concurrent.CompletableFuture;

public class WebhooksAsyncClient {
    private final DfnsHttpClient httpClient;

    public WebhooksAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Webhooks */
    public CompletableFuture<ListWebhooksResponse> listWebhooks(ListWebhooksQuery query) {
        return httpClient.getAsync("/webhooks", query.toMap(), ListWebhooksResponse.class);
    }

    /** Create Webhook */
    public CompletableFuture<Webhook> createWebhook(CreateWebhookRequest body) {
        return httpClient.postAsync("/webhooks", java.util.Map.of(), body, Webhook.class, true);
    }

    /** Get Webhook */
    public CompletableFuture<Webhook> getWebhook(String webhookId) {
        return httpClient.getAsync("/webhooks/" + webhookId, java.util.Map.of(), Webhook.class);
    }

    /** Update Webhook */
    public CompletableFuture<Webhook> updateWebhook(String webhookId, UpdateWebhookRequest body) {
        return httpClient.putAsync("/webhooks/" + webhookId, java.util.Map.of(), body, Webhook.class, true);
    }

    /** Delete Webhook */
    public CompletableFuture<DeleteWebhookResponse> deleteWebhook(String webhookId) {
        return httpClient.deleteAsync("/webhooks/" + webhookId, java.util.Map.of(), null, DeleteWebhookResponse.class, true);
    }

    /** Ping Webhook */
    public CompletableFuture<PingWebhookResponse> pingWebhook(String webhookId) {
        return httpClient.postAsync("/webhooks/" + webhookId + "/ping", java.util.Map.of(), null, PingWebhookResponse.class, true);
    }

    /** Get Webhook Event */
    public CompletableFuture<WebhookEvent> getWebhookEvent(String webhookId, String webhookEventId) {
        return httpClient.getAsync("/webhooks/" + webhookId + "/events/" + webhookEventId, java.util.Map.of(), WebhookEvent.class);
    }

    /** List Webhook Events */
    public CompletableFuture<PaginatedList<WebhookEvent>> listWebhookEvents(String webhookId, ListWebhookEventsQuery query) {
        return httpClient.getAsync("/webhooks/" + webhookId + "/events", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<WebhookEvent>>() {});
    }
}
