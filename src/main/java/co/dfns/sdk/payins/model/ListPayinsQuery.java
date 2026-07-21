package co.dfns.sdk.payins.model;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ListPayinsQuery {
    private Long limit;
    private String paginationToken;
    private String walletId;
    private List<String> status;
    private List<String> provider;

    public ListPayinsQuery limit(Long limit) {
        this.limit = limit;
        return this;
    }

    public ListPayinsQuery paginationToken(String paginationToken) {
        this.paginationToken = paginationToken;
        return this;
    }

    public ListPayinsQuery walletId(String walletId) {
        this.walletId = walletId;
        return this;
    }

    public ListPayinsQuery status(List<String> status) {
        this.status = status;
        return this;
    }

    public ListPayinsQuery provider(List<String> provider) {
        this.provider = provider;
        return this;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        if (limit != null) map.put("limit", String.valueOf(limit));
        if (paginationToken != null) map.put("paginationToken", String.valueOf(paginationToken));
        if (walletId != null) map.put("walletId", String.valueOf(walletId));
        if (status != null) map.put("status", String.valueOf(status));
        if (provider != null) map.put("provider", String.valueOf(provider));
        return map;
    }
}
