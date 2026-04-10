package co.dfns.sdk.staking.model;

import java.util.HashMap;
import java.util.Map;

public class ListStakeActionsQuery {
    private Long limit;
    private String paginationToken;

    public ListStakeActionsQuery limit(Long limit) {
        this.limit = limit;
        return this;
    }

    public ListStakeActionsQuery paginationToken(String paginationToken) {
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
