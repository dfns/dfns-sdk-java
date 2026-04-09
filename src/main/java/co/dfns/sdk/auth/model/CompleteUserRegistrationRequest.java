package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CompleteUserRegistrationRequest(
    @JsonProperty("firstFactorCredential") FirstFactorAttestation firstFactorCredential,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("secondFactorCredential") SecondFactorAttestation secondFactorCredential,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("recoveryCredential") RecoveryKeyAttestation recoveryCredential
) {}
