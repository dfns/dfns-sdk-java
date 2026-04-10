package co.dfns.sdk.wallets.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GetWalletAssetsResponse(
    @JsonProperty("walletId") String walletId,
    @JsonProperty("network") Network network,
    @JsonProperty("assets") List<Object> assets,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("netWorth") Map<String, Object> netWorth
) {}
