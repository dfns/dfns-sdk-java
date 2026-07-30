package co.dfns.sdk.addresswatches.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AddressWatchBlockchainEvent(
    @JsonProperty("id") String id,
    @JsonProperty("addressWatchId") String addressWatchId,
    @JsonProperty("network") Network network,
    @JsonProperty("name") String name,
    @JsonProperty("blockNumber") double blockNumber,
    @JsonProperty("txHash") String txHash,
    @JsonProperty("index") String index,
    @JsonProperty("timestamp") String timestamp,
    @JsonProperty("status") String status,
    @JsonProperty("data") Map<String, Object> data
) {}
