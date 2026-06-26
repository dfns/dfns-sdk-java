package co.dfns.sdk.auth.model;

import java.util.HashMap;
import java.util.Map;

public class DeleteServiceAccountQuery {
    private Object force;

    public DeleteServiceAccountQuery force(Object force) {
        this.force = force;
        return this;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        if (force != null) map.put("force", String.valueOf(force));
        return map;
    }
}
