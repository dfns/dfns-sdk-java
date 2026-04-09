package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateUserRequest(
    @JsonProperty("email") String email,
    @JsonProperty("kind") String kind,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("publicKey") String publicKey,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("externalId") String externalId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("isSSORequired") Boolean isSSORequired
) {}
