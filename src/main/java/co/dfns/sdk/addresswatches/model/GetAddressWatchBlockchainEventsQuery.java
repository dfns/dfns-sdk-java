package co.dfns.sdk.addresswatches.model;

import java.util.HashMap;
import java.util.Map;

public class GetAddressWatchBlockchainEventsQuery {
    private Long limit;
    private String paginationToken;
    private String name;
    private String contract;
    private String txHash;

    public GetAddressWatchBlockchainEventsQuery limit(Long limit) {
        this.limit = limit;
        return this;
    }

    public GetAddressWatchBlockchainEventsQuery paginationToken(String paginationToken) {
        this.paginationToken = paginationToken;
        return this;
    }

    public GetAddressWatchBlockchainEventsQuery name(String name) {
        this.name = name;
        return this;
    }

    public GetAddressWatchBlockchainEventsQuery contract(String contract) {
        this.contract = contract;
        return this;
    }

    public GetAddressWatchBlockchainEventsQuery txHash(String txHash) {
        this.txHash = txHash;
        return this;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        if (limit != null) map.put("limit", String.valueOf(limit));
        if (paginationToken != null) map.put("paginationToken", String.valueOf(paginationToken));
        if (name != null) map.put("name", String.valueOf(name));
        if (contract != null) map.put("contract", String.valueOf(contract));
        if (txHash != null) map.put("txHash", String.valueOf(txHash));
        return map;
    }
}
