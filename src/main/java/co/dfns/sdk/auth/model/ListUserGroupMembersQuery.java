package co.dfns.sdk.auth.model;

import java.util.HashMap;
import java.util.Map;

public class ListUserGroupMembersQuery {
    private Long limit;
    private String paginationToken;

    public ListUserGroupMembersQuery limit(Long limit) {
        this.limit = limit;
        return this;
    }

    public ListUserGroupMembersQuery paginationToken(String paginationToken) {
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
