package co.dfns.sdk.networks.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ReindexTransactionResponse(
    @JsonProperty("success") String success
) {}
