package co.dfns.sdk.wallets.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Requester(
    @JsonProperty("userId") String userId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("tokenId") String tokenId
) {}
