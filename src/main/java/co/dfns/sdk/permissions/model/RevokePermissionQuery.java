package co.dfns.sdk.permissions.model;

import java.util.HashMap;
import java.util.Map;

public class RevokePermissionQuery {
    private Boolean force;

    public RevokePermissionQuery force(Boolean force) {
        this.force = force;
        return this;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        if (force != null) map.put("force", String.valueOf(force));
        return map;
    }
}
