package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UpdateServiceAccountRequest(
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("name") String name,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("externalId") String externalId
) {}
