package co.dfns.sdk.wallets.model;

import java.util.HashMap;
import java.util.Map;

public class ListOrgWalletHistoryQuery {
    private Long limit;
    private String paginationToken;
    private String startTime;
    private String endTime;

    public ListOrgWalletHistoryQuery limit(Long limit) {
        this.limit = limit;
        return this;
    }

    public ListOrgWalletHistoryQuery paginationToken(String paginationToken) {
        this.paginationToken = paginationToken;
        return this;
    }

    public ListOrgWalletHistoryQuery startTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public ListOrgWalletHistoryQuery endTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        if (limit != null) map.put("limit", String.valueOf(limit));
        if (paginationToken != null) map.put("paginationToken", String.valueOf(paginationToken));
        if (startTime != null) map.put("startTime", String.valueOf(startTime));
        if (endTime != null) map.put("endTime", String.valueOf(endTime));
        return map;
    }
}
