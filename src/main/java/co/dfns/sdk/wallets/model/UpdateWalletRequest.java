package co.dfns.sdk.wallets.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UpdateWalletRequest(
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("name") Object name,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("externalId") Object externalId
) {}
