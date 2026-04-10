package co.dfns.sdk.wallets.model;

import java.util.HashMap;
import java.util.Map;

public class ListWalletsQuery {
    private Long limit;
    private String paginationToken;
    private String owner;
    private String ownerId;
    private String ownerUsername;

    public ListWalletsQuery limit(Long limit) {
        this.limit = limit;
        return this;
    }

    public ListWalletsQuery paginationToken(String paginationToken) {
        this.paginationToken = paginationToken;
        return this;
    }

    public ListWalletsQuery owner(String owner) {
        this.owner = owner;
        return this;
    }

    public ListWalletsQuery ownerId(String ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public ListWalletsQuery ownerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
        return this;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        if (limit != null) map.put("limit", String.valueOf(limit));
        if (paginationToken != null) map.put("paginationToken", String.valueOf(paginationToken));
        if (owner != null) map.put("owner", String.valueOf(owner));
        if (ownerId != null) map.put("ownerId", String.valueOf(ownerId));
        if (ownerUsername != null) map.put("ownerUsername", String.valueOf(ownerUsername));
        return map;
    }
}
