package co.dfns.sdk.payins.model;

import java.util.HashMap;
import java.util.Map;

public class ListPayinAccountsQuery {
    private String provider;

    public ListPayinAccountsQuery provider(String provider) {
        this.provider = provider;
        return this;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        if (provider != null) map.put("provider", String.valueOf(provider));
        return map;
    }
}
