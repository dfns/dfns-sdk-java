package co.dfns.sdk.agreements.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RecordAgreementAcceptanceResponse(
    @JsonProperty("agreementId") String agreementId,
    @JsonProperty("userId") String userId,
    @JsonProperty("dateAccepted") String dateAccepted
) {}
