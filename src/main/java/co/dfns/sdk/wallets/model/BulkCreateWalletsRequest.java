package co.dfns.sdk.wallets.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BulkCreateWalletsRequest(
    @JsonProperty("network") BulkWalletNetwork network,
    @JsonProperty("count") long count,
    @JsonProperty("name") String name,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("tags") List<String> tags,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("keystoreId") String keystoreId
) {}
