package co.dfns.sdk.wallets.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ImportWalletRequest(
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("name") String name,
    @JsonProperty("curve") KeyCurve curve,
    @JsonProperty("protocol") Object protocol,
    @JsonProperty("minSigners") long minSigners,
    @JsonProperty("encryptedKeyShares") List<Map<String, Object>> encryptedKeyShares,
    @JsonProperty("network") Network network,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("externalId") String externalId
) {}
