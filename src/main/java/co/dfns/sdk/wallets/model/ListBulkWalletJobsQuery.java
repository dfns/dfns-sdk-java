package co.dfns.sdk.wallets.model;

import java.util.HashMap;
import java.util.Map;

public class ListBulkWalletJobsQuery {
    private Long limit;
    private String paginationToken;
    private String status;

    public ListBulkWalletJobsQuery limit(Long limit) {
        this.limit = limit;
        return this;
    }

    public ListBulkWalletJobsQuery paginationToken(String paginationToken) {
        this.paginationToken = paginationToken;
        return this;
    }

    public ListBulkWalletJobsQuery status(String status) {
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
