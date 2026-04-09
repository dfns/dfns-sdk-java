package co.dfns.sdk.networks.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CantonValidator(
    @JsonProperty("id") String id,
    @JsonProperty("orgId") String orgId,
    @JsonProperty("network") String network,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("name") String name,
    @JsonProperty("kind") String kind,
    @JsonProperty("dateCreated") String dateCreated,
    @JsonProperty("partyHint") String partyHint
) {}
