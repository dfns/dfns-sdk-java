package co.dfns.sdk.networks.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CallFunctionRequest(
    @JsonProperty("contract") String contract,
    @JsonProperty("abi") Map<String, Object> abi,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("calldata") Map<String, Object> calldata
) {}
