package co.dfns.sdk.networks.model;

import java.util.HashMap;
import java.util.Map;

public class EstimateFeesQuery {
    private String network;

    public EstimateFeesQuery network(String network) {
        this.network = network;
        return this;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        if (network != null) map.put("network", String.valueOf(network));
        return map;
    }
}
