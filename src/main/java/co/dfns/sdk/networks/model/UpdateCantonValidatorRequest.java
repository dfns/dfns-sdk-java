package co.dfns.sdk.networks.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UpdateCantonValidatorRequest(
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("name") String name,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("validator") Map<String, Object> validator,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("ledger") Map<String, Object> ledger
) {}
