package co.dfns.sdk.vaults.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VaultHistoryIncomingTransfer(
    @JsonProperty("txHash") String txHash,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("index") String index,
    @JsonProperty("senders") List<String> senders,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("asset") Map<String, Object> asset
) {}
