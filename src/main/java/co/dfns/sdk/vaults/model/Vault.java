package co.dfns.sdk.vaults.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Vault(
    @JsonProperty("id") String id,
    @JsonProperty("orgId") String orgId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("name") String name,
    @JsonProperty("tags") List<String> tags,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("externalId") String externalId,
    @JsonProperty("dateCreated") String dateCreated,
    @JsonProperty("dateUpdated") String dateUpdated,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("addresses") List<VaultAddress> addresses
) {}
