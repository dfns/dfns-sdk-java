package co.dfns.sdk.wallets.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ProxyARequestToTheCantonLedgerApiRequest(
    @JsonProperty("requestMethod") String requestMethod,
    @JsonProperty("resource") String resource,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("body") Map<String, Object> body
) {}
