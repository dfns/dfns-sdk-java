package co.dfns.sdk.webhooks;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.webhooks.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedWebhooksAsyncClient {
    private final DfnsHttpClient httpClient;

    public DelegatedWebhooksAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Webhooks */
    public CompletableFuture<PaginatedList<Webhook>> listWebhooks(ListWebhooksQuery query) {
        return httpClient.getAsync("/webhooks", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Webhook>>() {});
    }

    /** Delegated signing step 1 for Create Webhook: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createWebhookInit(CreateWebhookRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/webhooks", body);
    }

    /** Delegated signing step 2 for Create Webhook: submits the signed challenge and issues the request. */
    public CompletableFuture<WebhookWithSecret> createWebhookComplete(CreateWebhookRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/webhooks", java.util.Map.of(), body, WebhookWithSecret.class, userAction));
    }

    /** Get Webhook */
    public CompletableFuture<Webhook> getWebhook(String webhookId) {
        return httpClient.getAsync("/webhooks/" + webhookId, java.util.Map.of(), Webhook.class);
    }

    /** Delegated signing step 1 for Update Webhook: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> updateWebhookInit(String webhookId, UpdateWebhookRequest body) {
        return httpClient.createUserActionChallengeAsync("PUT", "/webhooks/" + webhookId, body);
    }

    /** Delegated signing step 2 for Update Webhook: submits the signed challenge and issues the request. */
    public CompletableFuture<Webhook> updateWebhookComplete(String webhookId, UpdateWebhookRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("PUT", "/webhooks/" + webhookId, java.util.Map.of(), body, Webhook.class, userAction));
    }

    /** Delegated signing step 1 for Delete Webhook: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> deleteWebhookInit(String webhookId) {
        return httpClient.createUserActionChallengeAsync("DELETE", "/webhooks/" + webhookId, null);
    }

    /** Delegated signing step 2 for Delete Webhook: submits the signed challenge and issues the request. */
    public CompletableFuture<DeleteWebhookResponse> deleteWebhookComplete(String webhookId, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("DELETE", "/webhooks/" + webhookId, java.util.Map.of(), null, DeleteWebhookResponse.class, userAction));
    }

    /** Delegated signing step 1 for Ping Webhook: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> pingWebhookInit(String webhookId) {
        return httpClient.createUserActionChallengeAsync("POST", "/webhooks/" + webhookId + "/ping", null);
    }

    /** Delegated signing step 2 for Ping Webhook: submits the signed challenge and issues the request. */
    public CompletableFuture<PingWebhookResponse> pingWebhookComplete(String webhookId, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/webhooks/" + webhookId + "/ping", java.util.Map.of(), null, PingWebhookResponse.class, userAction));
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
