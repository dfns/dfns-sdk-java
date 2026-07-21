package co.dfns.sdk.payins.model;

import java.util.HashMap;
import java.util.Map;

public class GetPayinRecipientQuery {
    private String provider;
    private String walletId;
    private String currency;

    public GetPayinRecipientQuery provider(String provider) {
        this.provider = provider;
        return this;
    }

    public GetPayinRecipientQuery walletId(String walletId) {
        this.walletId = walletId;
        return this;
    }

    public GetPayinRecipientQuery currency(String currency) {
        this.currency = currency;
        return this;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        if (provider != null) map.put("provider", String.valueOf(provider));
        if (walletId != null) map.put("walletId", String.valueOf(walletId));
        if (currency != null) map.put("currency", String.valueOf(currency));
        return map;
    }
}
