package co.dfns.sdk.signers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateKeyHarvestInputRequest(
    @JsonProperty("kind") String kind,
    @JsonProperty("hsmTargetSerial") String hsmTargetSerial,
    @JsonProperty("macTargetSerial") String macTargetSerial,
    @JsonProperty("macTargetUsername") String macTargetUsername,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("numSecp256k1") long numSecp256k1,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("numEd25519") long numEd25519
) {}
