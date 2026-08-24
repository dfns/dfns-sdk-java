package co.dfns.sdk.signers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateGenesisInputRequest(
    @JsonProperty("kind") String kind,
    @JsonProperty("numProvisioners") long numProvisioners,
    @JsonProperty("numOperational") long numOperational,
    @JsonProperty("numSecp256k1") long numSecp256k1,
    @JsonProperty("numEd25519") long numEd25519,
    @JsonProperty("hsmGenesisSerial") String hsmGenesisSerial,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("macGenesisSerial") String macGenesisSerial,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("hsmGenesisFirmwareVersion") String hsmGenesisFirmwareVersion,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("debugOptions") Map<String, Object> debugOptions
) {}
