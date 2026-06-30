package co.dfns.sdk.signers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubmitOnchainSignOutputRequest(
    @JsonProperty("fileChecksum") String fileChecksum,
    @JsonProperty("outputJson") Map<String, Object> outputJson
) {}
