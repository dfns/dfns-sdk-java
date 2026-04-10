package co.dfns.sdk.agreements.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GetLatestUnacceptedAgreementResponse(
    @JsonProperty("latestAgreement") Agreement latestAgreement
) {}
