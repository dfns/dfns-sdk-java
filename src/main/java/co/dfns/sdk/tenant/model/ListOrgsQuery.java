package co.dfns.sdk.tenant.model;

import java.util.HashMap;
import java.util.Map;

public class ListOrgsQuery {
    private Long limit;
    private String paginationToken;
    private Object status;

    public ListOrgsQuery limit(Long limit) {
        this.limit = limit;
        return this;
    }

    public ListOrgsQuery paginationToken(String paginationToken) {
        this.paginationToken = paginationToken;
        return this;
    }

    public ListOrgsQuery status(Object status) {
        this.status = status;
        return this;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        if (limit != null) map.put("limit", String.valueOf(limit));
        if (paginationToken != null) map.put("paginationToken", String.valueOf(paginationToken));
        if (status != null) map.put("status", String.valueOf(status));
        return map;
    }
}
