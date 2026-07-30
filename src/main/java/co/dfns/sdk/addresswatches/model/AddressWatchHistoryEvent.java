package co.dfns.sdk.addresswatches.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AddressWatchHistoryEvent(
    @JsonProperty("direction") String direction,
    @JsonProperty("network") Network network,
    @JsonProperty("blockNumber") double blockNumber,
    @JsonProperty("txHash") String txHash,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("index") String index,
    @JsonProperty("timestamp") String timestamp,
    @JsonProperty("status") String status,
    @JsonProperty("metadata") Map<String, Object> metadata,
    @JsonProperty("kind") String kind,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("from") String from,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("to") String to,
    @JsonProperty("value") String value,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("fee") String fee,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("memo") String memo,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("liquidityPool") String liquidityPool,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("balanceId") String balanceId,
    @JsonProperty("symbol") String symbol,
    @JsonProperty("decimals") double decimals,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("verified") Boolean verified,
    @JsonProperty("addressWatchId") String addressWatchId
) {}
