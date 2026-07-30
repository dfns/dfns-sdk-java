package co.dfns.sdk.addresswatches.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GetAddressWatchBlockchainEventsResponse(
    @JsonProperty("items") List<AddressWatchBlockchainEvent> items,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("nextPageToken") String nextPageToken,
    @JsonProperty("addressWatchId") String addressWatchId,
    @JsonProperty("network") Network network
) {}
