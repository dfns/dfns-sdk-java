package co.dfns.sdk.addresswatches.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AddressWatchNetwork {
    ArbitrumOne("ArbitrumOne"),
    ArbitrumSepolia("ArbitrumSepolia"),
    ArcTestnet("ArcTestnet"),
    Areum("Areum"),
    AvalancheC("AvalancheC"),
    AvalancheCFuji("AvalancheCFuji"),
    Base("Base"),
    BaseSepolia("BaseSepolia"),
    Berachain("Berachain"),
    BerachainBepolia("BerachainBepolia"),
    Bob("Bob"),
    BobSepolia("BobSepolia"),
    Bsc("Bsc"),
    BscTestnet("BscTestnet"),
    Celo("Celo"),
    CeloAlfajores("CeloAlfajores"),
    Codex("Codex"),
    CodexSepolia("CodexSepolia"),
    Ethereum("Ethereum"),
    EthereumClassic("EthereumClassic"),
    EthereumClassicMordor("EthereumClassicMordor"),
    EthereumSepolia("EthereumSepolia"),
    EthereumHoodi("EthereumHoodi"),
    FlareC("FlareC"),
    FlareCCoston2("FlareCCoston2"),
    FlowEvm("FlowEvm"),
    FlowEvmTestnet("FlowEvmTestnet"),
    Ink("Ink"),
    InkSepolia("InkSepolia"),
    Optimism("Optimism"),
    OptimismSepolia("OptimismSepolia"),
    Plasma("Plasma"),
    PlasmaTestnet("PlasmaTestnet"),
    Plume("Plume"),
    PlumeSepolia("PlumeSepolia"),
    Polygon("Polygon"),
    PolygonAmoy("PolygonAmoy"),
    Rayls("Rayls"),
    RaylsTestnet("RaylsTestnet"),
    Robinhood("Robinhood"),
    RobinhoodSepolia("RobinhoodSepolia"),
    SeiAtlantic2("SeiAtlantic2"),
    SeiPacific1("SeiPacific1"),
    Solana("Solana"),
    SolanaDevnet("SolanaDevnet"),
    Sonic("Sonic"),
    SonicTestnet("SonicTestnet"),
    Tempo("Tempo"),
    TempoModerato("TempoModerato"),
    Tsc("Tsc"),
    TscTestnet1("TscTestnet1"),
    Xdc("Xdc"),
    XdcApothem("XdcApothem"),
    XLayer("XLayer"),
    XLayerSepolia("XLayerSepolia"),
    UNKNOWN(null);


    private final String value;

    AddressWatchNetwork(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static AddressWatchNetwork fromValue(String value) {
        for (AddressWatchNetwork e : values()) {
            if (e.value != null && e.value.equals(value)) return e;
        }
        return UNKNOWN;
    }
}
