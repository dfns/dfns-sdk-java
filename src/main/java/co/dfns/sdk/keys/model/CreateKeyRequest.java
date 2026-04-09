package co.dfns.sdk.keys.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateKeyRequest(
    @JsonProperty("scheme") KeyScheme scheme,
    @JsonProperty("curve") KeyCurve curve,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("name") String name,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("masterKey") Boolean masterKey,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("deriveFrom") Map<String, Object> deriveFrom,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("storeId") String storeId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("delegateTo") String delegateTo,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("delayDelegation") Boolean delayDelegation
) {}
