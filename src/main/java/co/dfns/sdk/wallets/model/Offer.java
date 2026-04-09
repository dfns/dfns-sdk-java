package co.dfns.sdk.wallets.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Offer(
    @JsonProperty("id") String id,
    @JsonProperty("orgId") String orgId,
    @JsonProperty("walletId") String walletId,
    @JsonProperty("network") Network network,
    @JsonProperty("kind") String kind,
    @JsonProperty("metadata") Map<String, Object> metadata,
    @JsonProperty("txHash") String txHash,
    @JsonProperty("status") String status,
    @JsonProperty("from") String from,
    @JsonProperty("to") String to,
    @JsonProperty("value") String value,
    @JsonProperty("timestamp") String timestamp,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("expiresAt") String expiresAt,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("memo") String memo,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("settlementTransactionId") String settlementTransactionId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("dateSettled") String dateSettled
) {}
