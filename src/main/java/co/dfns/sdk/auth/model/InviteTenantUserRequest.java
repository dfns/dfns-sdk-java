package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InviteTenantUserRequest(
    @JsonProperty("email") String email,
    @JsonProperty("kind") String kind
) {}
