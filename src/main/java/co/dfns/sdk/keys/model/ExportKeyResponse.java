package co.dfns.sdk.keys.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ExportKeyResponse(
    @JsonProperty("publicKey") String publicKey,
    @JsonProperty("protocol") Object protocol,
    @JsonProperty("curve") String curve,
    @JsonProperty("minSigners") double minSigners,
    @JsonProperty("encryptedKeyShares") List<Map<String, Object>> encryptedKeyShares
) {}
