package co.dfns.sdk.signers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateProofOfControlInputRequest(
    @JsonProperty("walletIds") List<String> walletIds
) {}
