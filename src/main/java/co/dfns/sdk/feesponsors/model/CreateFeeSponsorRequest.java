package co.dfns.sdk.feesponsors.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateFeeSponsorRequest(
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("name") String name,
    @JsonProperty("walletId") String walletId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("allowEndUser") Boolean allowEndUser
) {}
