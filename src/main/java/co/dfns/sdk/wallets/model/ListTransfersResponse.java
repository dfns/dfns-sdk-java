package co.dfns.sdk.wallets.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ListTransfersResponse(
    @JsonProperty("items") List<TransferRequest> items,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("nextPageToken") String nextPageToken,
    @JsonProperty("walletId") String walletId
) {}
