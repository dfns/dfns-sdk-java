package co.dfns.sdk.wallets.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Wallet(
    @JsonProperty("id") String id,
    @JsonProperty("network") Network network,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("address") String address,
    @JsonProperty("signingKey") Map<String, Object> signingKey,
    @JsonProperty("status") String status,
    @JsonProperty("dateCreated") String dateCreated,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("dateDeleted") String dateDeleted,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("name") String name,
    @JsonProperty("custodial") Boolean custodial,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("externalId") String externalId,
    @JsonProperty("tags") List<String> tags,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("validatorId") String validatorId
) {}
