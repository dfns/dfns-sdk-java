package co.dfns.sdk.vaults.model;

import java.util.HashMap;
import java.util.Map;

public class ListVaultQuarantinesQuery {
    private Long limit;
    private String paginationToken;
    private String network;

    public ListVaultQuarantinesQuery limit(Long limit) {
        this.limit = limit;
        return this;
    }

    public ListVaultQuarantinesQuery paginationToken(String paginationToken) {
        this.paginationToken = paginationToken;
        return this;
    }

    public ListVaultQuarantinesQuery network(String network) {
        this.network = network;
        return this;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        if (limit != null) map.put("limit", String.valueOf(limit));
        if (paginationToken != null) map.put("paginationToken", String.valueOf(paginationToken));
        if (network != null) map.put("network", String.valueOf(network));
        return map;
    }
}
