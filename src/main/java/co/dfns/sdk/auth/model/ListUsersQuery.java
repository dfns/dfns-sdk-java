package co.dfns.sdk.auth.model;

import java.util.HashMap;
import java.util.Map;

public class ListUsersQuery {
    private Long limit;
    private String paginationToken;
    private String kind;

    public ListUsersQuery limit(Long limit) {
        this.limit = limit;
        return this;
    }

    public ListUsersQuery paginationToken(String paginationToken) {
        this.paginationToken = paginationToken;
        return this;
    }

    public ListUsersQuery kind(String kind) {
        this.kind = kind;
        return this;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        if (limit != null) map.put("limit", String.valueOf(limit));
        if (paginationToken != null) map.put("paginationToken", String.valueOf(paginationToken));
        if (kind != null) map.put("kind", String.valueOf(kind));
        return map;
    }
}
