package co.dfns.sdk.signers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateAddMacUserInputRequest(
    @JsonProperty("kind") String kind,
    @JsonProperty("macTargetSerial") String macTargetSerial,
    @JsonProperty("hsmTargetSerial") String hsmTargetSerial
) {}
