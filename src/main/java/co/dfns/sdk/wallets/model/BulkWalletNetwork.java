package co.dfns.sdk.wallets.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BulkWalletNetwork {
    Ethereum("Ethereum"),
    EthereumSepolia("EthereumSepolia"),
    EthereumHolesky("EthereumHolesky"),
    EthereumHoodi("EthereumHoodi"),
    Bsc("Bsc"),
    BscTestnet("BscTestnet"),
    Base("Base"),
    BaseSepolia("BaseSepolia"),
    ArbitrumOne("ArbitrumOne"),
    ArbitrumSepolia("ArbitrumSepolia"),
    Optimism("Optimism"),
    OptimismSepolia("OptimismSepolia"),
    Tron("Tron"),
    TronNile("TronNile"),
    Solana("Solana"),
    SolanaDevnet("SolanaDevnet"),
    UNKNOWN(null);


    private final String value;

    BulkWalletNetwork(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static BulkWalletNetwork fromValue(String value) {
        for (BulkWalletNetwork e : values()) {
            if (e.value != null && e.value.equals(value)) return e;
        }
        return UNKNOWN;
    }
}
