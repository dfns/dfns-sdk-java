package co.dfns.sdk.feesponsors.model;

import java.util.HashMap;
import java.util.Map;

public class ListSponsoredFeesQuery {
    private String limit;
    private String paginationToken;

    public ListSponsoredFeesQuery limit(String limit) {
        this.limit = limit;
        return this;
    }

    public ListSponsoredFeesQuery paginationToken(String paginationToken) {
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
