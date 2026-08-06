package co.dfns.sdk.vaults.model;

import java.util.HashMap;
import java.util.Map;

public class ListVaultLocksQuery {
    private Long limit;
    private String paginationToken;
    private String network;
    private String tid;

    public ListVaultLocksQuery limit(Long limit) {
        this.limit = limit;
        return this;
    }

    public ListVaultLocksQuery paginationToken(String paginationToken) {
        this.paginationToken = paginationToken;
        return this;
    }

    public ListVaultLocksQuery network(String network) {
        this.network = network;
        return this;
    }

    public ListVaultLocksQuery tid(String tid) {
        this.tid = tid;
        return this;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        if (limit != null) map.put("limit", String.valueOf(limit));
        if (paginationToken != null) map.put("paginationToken", String.valueOf(paginationToken));
        if (network != null) map.put("network", String.valueOf(network));
        if (tid != null) map.put("tid", String.valueOf(tid));
        return map;
    }
}
