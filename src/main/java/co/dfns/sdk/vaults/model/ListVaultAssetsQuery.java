package co.dfns.sdk.vaults.model;

import java.util.HashMap;
import java.util.Map;

public class ListVaultAssetsQuery {
    private Object showUnverified;
    private String network;

    public ListVaultAssetsQuery showUnverified(Object showUnverified) {
        this.showUnverified = showUnverified;
        return this;
    }

    public ListVaultAssetsQuery network(String network) {
        this.network = network;
        return this;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        if (showUnverified != null) map.put("showUnverified", String.valueOf(showUnverified));
        if (network != null) map.put("network", String.valueOf(network));
        return map;
    }
}
