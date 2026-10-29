package co.dfns.sdk.wallets.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BulkWalletNetwork {
    Adi("Adi"),
    ArbitrumOne("ArbitrumOne"),
    Arc("Arc"),
    Areum("Areum"),
    AvalancheC("AvalancheC"),
    Base("Base"),
    Bob("Bob"),
    Bsc("Bsc"),
    Berachain("Berachain"),
    Besu("Besu"),
    Besu2("Besu2"),
    Besu3("Besu3"),
    Besu4("Besu4"),
    Besu5("Besu5"),
    Besu6("Besu6"),
    Celo("Celo"),
    Codex("Codex"),
    Ethereum("Ethereum"),
    EthereumClassic("EthereumClassic"),
    FantomOpera("FantomOpera"),
    FlareC("FlareC"),
    FlowEvm("FlowEvm"),
    HyperEvm("HyperEvm"),
    Ink("Ink"),
    Monad("Monad"),
    Optimism("Optimism"),
    Plasma("Plasma"),
    Plume("Plume"),
    Polygon("Polygon"),
    Race("Race"),
    Rayls("Rayls"),
    Robinhood("Robinhood"),
    SeiPacific1("SeiPacific1"),
    Sonic("Sonic"),
    Tempo("Tempo"),
    Tsc("Tsc"),
    Xdc("Xdc"),
    XLayer("XLayer"),
    EthereumSepolia("EthereumSepolia"),
    EthereumHolesky("EthereumHolesky"),
    EthereumHoodi("EthereumHoodi"),
    BscTestnet("BscTestnet"),
    BaseSepolia("BaseSepolia"),
    ArbitrumSepolia("ArbitrumSepolia"),
    OptimismSepolia("OptimismSepolia"),
    Tron("Tron"),
    TronNile("TronNile"),
    Solana("Solana"),
    SolanaDevnet("SolanaDevnet"),
    Bitcoin("Bitcoin"),
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
