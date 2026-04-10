package co.dfns.sdk.webhooks.model;

import java.util.HashMap;
import java.util.Map;

public class ListWebhooksQuery {
    private Long limit;
    private String paginationToken;

    public ListWebhooksQuery limit(Long limit) {
        this.limit = limit;
        return this;
    }

    public ListWebhooksQuery paginationToken(String paginationToken) {
        this.paginationToken = paginationToken;
        return this;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        if (limit != null) map.put("limit", String.valueOf(limit));
        if (paginationToken != null) map.put("paginationToken", String.valueOf(paginationToken));
        return map;
    }
}
