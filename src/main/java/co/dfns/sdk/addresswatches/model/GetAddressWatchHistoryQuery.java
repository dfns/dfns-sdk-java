package co.dfns.sdk.addresswatches.model;

import java.util.HashMap;
import java.util.Map;

public class GetAddressWatchHistoryQuery {
    private Long limit;
    private String paginationToken;
    private String direction;
    private String kind;
    private String contract;

    public GetAddressWatchHistoryQuery limit(Long limit) {
        this.limit = limit;
        return this;
    }

    public GetAddressWatchHistoryQuery paginationToken(String paginationToken) {
        this.paginationToken = paginationToken;
        return this;
    }

    public GetAddressWatchHistoryQuery direction(String direction) {
        this.direction = direction;
        return this;
    }

    public GetAddressWatchHistoryQuery kind(String kind) {
        this.kind = kind;
        return this;
    }

    public GetAddressWatchHistoryQuery contract(String contract) {
        this.contract = contract;
        return this;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        if (limit != null) map.put("limit", String.valueOf(limit));
        if (paginationToken != null) map.put("paginationToken", String.valueOf(paginationToken));
        if (direction != null) map.put("direction", String.valueOf(direction));
        if (kind != null) map.put("kind", String.valueOf(kind));
        if (contract != null) map.put("contract", String.valueOf(contract));
        return map;
    }
}
