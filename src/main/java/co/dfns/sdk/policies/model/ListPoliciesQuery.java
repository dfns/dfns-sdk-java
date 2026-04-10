package co.dfns.sdk.policies.model;

import java.util.HashMap;
import java.util.Map;

public class ListPoliciesQuery {
    private String limit;
    private String paginationToken;
    private String status;

    public ListPoliciesQuery limit(String limit) {
        this.limit = limit;
        return this;
    }

    public ListPoliciesQuery paginationToken(String paginationToken) {
        this.paginationToken = paginationToken;
        return this;
    }

    public ListPoliciesQuery status(String status) {
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
