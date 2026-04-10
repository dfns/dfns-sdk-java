package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Credential(
    @JsonProperty("kind") String kind,
    @JsonProperty("credentialId") String credentialId,
    @JsonProperty("credentialUuid") String credentialUuid,
    @JsonProperty("dateCreated") String dateCreated,
    @JsonProperty("isActive") Boolean isActive,
    @JsonProperty("name") String name,
    @JsonProperty("publicKey") String publicKey,
    @JsonProperty("relyingPartyId") String relyingPartyId,
    @JsonProperty("origin") String origin
) {}
