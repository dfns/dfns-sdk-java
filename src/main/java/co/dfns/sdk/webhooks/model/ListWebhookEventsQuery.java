package co.dfns.sdk.webhooks.model;

import java.util.HashMap;
import java.util.Map;

public class ListWebhookEventsQuery {
    private String kind;
    private String deliveryFailed;
    private Long limit;
    private String paginationToken;

    public ListWebhookEventsQuery kind(String kind) {
        this.kind = kind;
        return this;
    }

    public ListWebhookEventsQuery deliveryFailed(String deliveryFailed) {
        this.deliveryFailed = deliveryFailed;
        return this;
    }

    public ListWebhookEventsQuery limit(Long limit) {
        this.limit = limit;
        return this;
    }

    public ListWebhookEventsQuery paginationToken(String paginationToken) {
        this.paginationToken = paginationToken;
        return this;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        if (kind != null) map.put("kind", String.valueOf(kind));
        if (deliveryFailed != null) map.put("deliveryFailed", String.valueOf(deliveryFailed));
        if (limit != null) map.put("limit", String.valueOf(limit));
        if (paginationToken != null) map.put("paginationToken", String.valueOf(paginationToken));
        return map;
    }
}
