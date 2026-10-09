package co.dfns.sdk.vaults.model;

import java.util.HashMap;
import java.util.Map;

public class ListVaultHistoryQuery {
    private Long limit;
    private String paginationToken;
    private Object network;
    private Object tid;
    private Object kind;

    public ListVaultHistoryQuery limit(Long limit) {
        this.limit = limit;
        return this;
    }

    public ListVaultHistoryQuery paginationToken(String paginationToken) {
        this.paginationToken = paginationToken;
        return this;
    }

    public ListVaultHistoryQuery network(Object network) {
        this.network = network;
        return this;
    }

    public ListVaultHistoryQuery tid(Object tid) {
        this.tid = tid;
        return this;
    }

    public ListVaultHistoryQuery kind(Object kind) {
        this.kind = kind;
        return this;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        if (limit != null) map.put("limit", String.valueOf(limit));
        if (paginationToken != null) map.put("paginationToken", String.valueOf(paginationToken));
        if (network != null) map.put("network", String.valueOf(network));
        if (tid != null) map.put("tid", String.valueOf(tid));
        if (kind != null) map.put("kind", String.valueOf(kind));
        return map;
    }
}
