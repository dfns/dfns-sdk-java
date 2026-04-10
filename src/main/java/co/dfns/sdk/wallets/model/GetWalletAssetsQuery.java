package co.dfns.sdk.wallets.model;

import java.util.HashMap;
import java.util.Map;

public class GetWalletAssetsQuery {
    private String netWorth;

    public GetWalletAssetsQuery netWorth(String netWorth) {
        this.netWorth = netWorth;
        return this;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        if (netWorth != null) map.put("netWorth", String.valueOf(netWorth));
        return map;
    }
}
