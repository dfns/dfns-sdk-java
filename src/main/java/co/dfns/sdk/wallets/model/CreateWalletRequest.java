package co.dfns.sdk.wallets.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateWalletRequest(
    @JsonProperty("network") Network network,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("name") String name,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("signingKey") Map<String, Object> signingKey,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("delegateTo") String delegateTo,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("delayDelegation") Boolean delayDelegation,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("externalId") String externalId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("tags") List<String> tags
) {}
