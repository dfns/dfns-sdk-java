package co.dfns.sdk.payouts.model;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ListPayoutsQuery {
    private Long limit;
    private String paginationToken;
    private String walletId;
    private List<String> status;
    private List<String> provider;

    public ListPayoutsQuery limit(Long limit) {
        this.limit = limit;
        return this;
    }

    public ListPayoutsQuery paginationToken(String paginationToken) {
        this.paginationToken = paginationToken;
        return this;
    }

    public ListPayoutsQuery walletId(String walletId) {
        this.walletId = walletId;
        return this;
    }

    public ListPayoutsQuery status(List<String> status) {
        this.status = status;
        return this;
    }

    public ListPayoutsQuery provider(List<String> provider) {
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
