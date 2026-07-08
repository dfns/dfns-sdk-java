package co.dfns.sdk.webhooks;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.webhooks.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.Map;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedWebhooksClient {
    private final DfnsHttpClient httpClient;

    public DelegatedWebhooksClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Webhooks */
    public PaginatedList<Webhook> listWebhooks(ListWebhooksQuery query) {
        return httpClient.get("/webhooks", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Webhook>>() {});
    }

    /** Delegated signing step 1 for Create Webhook: returns the challenge to sign out-of-band. */
    public UserActionChallenge createWebhookInit(CreateWebhookRequest body) {
        return httpClient.createUserActionChallenge("POST", "/webhooks", body);
    }

    /** Delegated signing step 2 for Create Webhook: submits the signed challenge and issues the request. */
    public WebhookWithSecret createWebhookComplete(CreateWebhookRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/webhooks", java.util.Map.of(), body, WebhookWithSecret.class, userAction);
    }

    /** Get Webhook */
    public Webhook getWebhook(String webhookId) {
        return httpClient.get("/webhooks/" + webhookId, java.util.Map.of(), Webhook.class);
    }

    /** Delegated signing step 1 for Update Webhook: returns the challenge to sign out-of-band. */
    public UserActionChallenge updateWebhookInit(String webhookId, UpdateWebhookRequest body) {
        return httpClient.createUserActionChallenge("PUT", "/webhooks/" + webhookId, body);
    }

    /** Delegated signing step 2 for Update Webhook: submits the signed challenge and issues the request. */
    public Webhook updateWebhookComplete(String webhookId, UpdateWebhookRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/webhooks/" + webhookId, java.util.Map.of(), body, Webhook.class, userAction);
    }

    /** Delegated signing step 1 for Delete Webhook: returns the challenge to sign out-of-band. */
    public UserActionChallenge deleteWebhookInit(String webhookId) {
        return httpClient.createUserActionChallenge("DELETE", "/webhooks/" + webhookId, null);
    }

    /** Delegated signing step 2 for Delete Webhook: submits the signed challenge and issues the request. */
    public DeleteWebhookResponse deleteWebhookComplete(String webhookId, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("DELETE", "/webhooks/" + webhookId, java.util.Map.of(), null, DeleteWebhookResponse.class, userAction);
    }

    /** Delegated signing step 1 for Ping Webhook: returns the challenge to sign out-of-band. */
    public UserActionChallenge pingWebhookInit(String webhookId) {
        return httpClient.createUserActionChallenge("POST", "/webhooks/" + webhookId + "/ping", null);
    }

    /** Delegated signing step 2 for Ping Webhook: submits the signed challenge and issues the request. */
    public PingWebhookResponse pingWebhookComplete(String webhookId, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/webhooks/" + webhookId + "/ping", java.util.Map.of(), null, PingWebhookResponse.class, userAction);
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
