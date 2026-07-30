package co.dfns.sdk.addresswatches.model;

import java.util.HashMap;
import java.util.Map;

public class GetAddressWatchAssetsQuery {
    private String netWorth;

    public GetAddressWatchAssetsQuery netWorth(String netWorth) {
        this.netWorth = netWorth;
        return this;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        if (netWorth != null) map.put("netWorth", String.valueOf(netWorth));
        return map;
    }
}
