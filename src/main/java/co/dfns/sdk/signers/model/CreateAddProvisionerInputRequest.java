package co.dfns.sdk.signers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateAddProvisionerInputRequest(
    @JsonProperty("kind") String kind,
    @JsonProperty("yubikeySerial") String yubikeySerial,
    @JsonProperty("hsmTargetSerial") String hsmTargetSerial
) {}
