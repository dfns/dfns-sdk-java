package co.dfns.sdk.wallets.model;

import java.util.HashMap;
import java.util.Map;

public class GetWalletHistoryQuery {
    private Long limit;
    private String paginationToken;
    private String direction;
    private String kind;
    private String contract;

    public GetWalletHistoryQuery limit(Long limit) {
        this.limit = limit;
        return this;
    }

    public GetWalletHistoryQuery paginationToken(String paginationToken) {
        this.paginationToken = paginationToken;
        return this;
    }

    public GetWalletHistoryQuery direction(String direction) {
        this.direction = direction;
        return this;
    }

    public GetWalletHistoryQuery kind(String kind) {
        this.kind = kind;
        return this;
    }

    public GetWalletHistoryQuery contract(String contract) {
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
