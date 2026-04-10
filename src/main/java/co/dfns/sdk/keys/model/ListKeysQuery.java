package co.dfns.sdk.keys.model;

import java.util.HashMap;
import java.util.Map;

public class ListKeysQuery {
    private Long limit;
    private String paginationToken;
    private String owner;

    public ListKeysQuery limit(Long limit) {
        this.limit = limit;
        return this;
    }

    public ListKeysQuery paginationToken(String paginationToken) {
        this.paginationToken = paginationToken;
        return this;
    }

    public ListKeysQuery owner(String owner) {
        this.owner = owner;
        return this;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        if (limit != null) map.put("limit", String.valueOf(limit));
        if (paginationToken != null) map.put("paginationToken", String.valueOf(paginationToken));
        if (owner != null) map.put("owner", String.valueOf(owner));
        return map;
    }
}
