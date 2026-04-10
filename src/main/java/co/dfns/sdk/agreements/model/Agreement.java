package co.dfns.sdk.agreements.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Agreement(
    @JsonProperty("id") String id,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("agreementUrl") String agreementUrl,
    @JsonProperty("details") String details,
    @JsonProperty("agreementType") String agreementType
) {}
