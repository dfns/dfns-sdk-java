package co.dfns.sdk.swaps.model;

import java.util.HashMap;
import java.util.Map;

public class ListSwapsQuery {
    private Long limit;
    private String paginationToken;

    public ListSwapsQuery limit(Long limit) {
        this.limit = limit;
        return this;
    }

    public ListSwapsQuery paginationToken(String paginationToken) {
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
