package co.dfns.sdk.wallets.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GetWalletNftsResponse(
    @JsonProperty("walletId") String walletId,
    @JsonProperty("network") Network network,
    @JsonProperty("nfts") List<Object> nfts
) {}
