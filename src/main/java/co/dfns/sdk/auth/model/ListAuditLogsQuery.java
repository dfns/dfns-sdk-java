package co.dfns.sdk.auth.model;

import java.util.HashMap;
import java.util.Map;

public class ListAuditLogsQuery {
    private String startTime;
    private String endTime;
    private String userId;

    public ListAuditLogsQuery startTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public ListAuditLogsQuery endTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    public ListAuditLogsQuery userId(String userId) {
        this.userId = userId;
        return this;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        if (startTime != null) map.put("startTime", String.valueOf(startTime));
        if (endTime != null) map.put("endTime", String.valueOf(endTime));
        if (userId != null) map.put("userId", String.valueOf(userId));
        return map;
    }
}
