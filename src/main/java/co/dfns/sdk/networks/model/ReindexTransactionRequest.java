package co.dfns.sdk.networks.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ReindexTransactionRequest(
    @JsonProperty("txHash") String txHash
) {}
