package co.dfns.sdk.agreements.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GetLatestAgreementsResponse(
    @JsonProperty("latestAgreements") List<Agreement> latestAgreements
) {}
