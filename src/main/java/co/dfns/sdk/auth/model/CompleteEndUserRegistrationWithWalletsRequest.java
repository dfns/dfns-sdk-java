package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CompleteEndUserRegistrationWithWalletsRequest(
    @JsonProperty("firstFactorCredential") FirstFactorAttestation firstFactorCredential,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("secondFactorCredential") SecondFactorAttestation secondFactorCredential,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("recoveryCredential") RecoveryKeyAttestation recoveryCredential,
    @JsonProperty("wallets") List<Map<String, Object>> wallets
) {}
