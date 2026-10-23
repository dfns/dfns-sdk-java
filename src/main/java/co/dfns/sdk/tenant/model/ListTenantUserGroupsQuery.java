package co.dfns.sdk.tenant.model;

import java.util.HashMap;
import java.util.Map;

public class ListTenantUserGroupsQuery {
    private Long limit;
    private String paginationToken;

    public ListTenantUserGroupsQuery limit(Long limit) {
        this.limit = limit;
        return this;
    }

    public ListTenantUserGroupsQuery paginationToken(String paginationToken) {
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
