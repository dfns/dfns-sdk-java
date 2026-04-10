package co.dfns.sdk.policies.model;

import java.util.HashMap;
import java.util.Map;

public class ListApprovalsQuery {
    private String limit;
    private String paginationToken;
    private String status;
    private String initiatorId;
    private String approverId;

    public ListApprovalsQuery limit(String limit) {
        this.limit = limit;
        return this;
    }

    public ListApprovalsQuery paginationToken(String paginationToken) {
        this.paginationToken = paginationToken;
        return this;
    }

    public ListApprovalsQuery status(String status) {
        this.status = status;
        return this;
    }

    public ListApprovalsQuery initiatorId(String initiatorId) {
        this.initiatorId = initiatorId;
        return this;
    }

    public ListApprovalsQuery approverId(String approverId) {
        this.approverId = approverId;
        return this;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        if (limit != null) map.put("limit", String.valueOf(limit));
        if (paginationToken != null) map.put("paginationToken", String.valueOf(paginationToken));
        if (status != null) map.put("status", String.valueOf(status));
        if (initiatorId != null) map.put("initiatorId", String.valueOf(initiatorId));
        if (approverId != null) map.put("approverId", String.valueOf(approverId));
        return map;
    }
}
