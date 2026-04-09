package co.dfns.sdk.keys.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Key(
    @JsonProperty("id") String id,
    @JsonProperty("scheme") KeyScheme scheme,
    @JsonProperty("curve") KeyCurve curve,
    @JsonProperty("publicKey") String publicKey,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("masterKey") Boolean masterKey,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("derivedFrom") Map<String, Object> derivedFrom,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("name") String name,
    @JsonProperty("status") String status,
    @JsonProperty("custodial") Boolean custodial,
    @JsonProperty("dateCreated") String dateCreated,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("imported") Boolean imported,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("exported") Boolean exported,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("dateExported") String dateExported,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("dateDeleted") String dateDeleted
) {}
