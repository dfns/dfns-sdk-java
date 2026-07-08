package co.dfns.sdk.payins.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GetPayinRecipientResponse(
    @JsonProperty("provider") String provider,
    @JsonProperty("walletId") String walletId,
    @JsonProperty("currency") String currency,
    @JsonProperty("status") String status,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("recipientAddressId") String recipientAddressId
) {}
