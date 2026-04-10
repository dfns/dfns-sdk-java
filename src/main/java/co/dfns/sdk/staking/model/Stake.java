package co.dfns.sdk.staking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Stake(
    @JsonProperty("id") String id,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("provider") String provider,
    @JsonProperty("walletId") String walletId,
    @JsonProperty("status") String status,
    @JsonProperty("requester") Requester requester,
    @JsonProperty("requestBody") Object requestBody,
    @JsonProperty("dateCreated") String dateCreated,
    @JsonProperty("protocol") String protocol,
    @JsonProperty("data") Map<String, Object> data
) {}
