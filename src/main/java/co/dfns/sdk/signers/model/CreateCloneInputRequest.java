package co.dfns.sdk.signers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateCloneInputRequest(
    @JsonProperty("kind") String kind,
    @JsonProperty("hsmSourceSerial") String hsmSourceSerial,
    @JsonProperty("hsmTargetSerial") String hsmTargetSerial,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("macTargetSerial") String macTargetSerial
) {}
