package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateUserActionChallengeRequest(
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("userActionServerKind") String userActionServerKind,
    @JsonProperty("userActionHttpMethod") String userActionHttpMethod,
    @JsonProperty("userActionHttpPath") String userActionHttpPath,
    @JsonProperty("userActionPayload") String userActionPayload
) {}
