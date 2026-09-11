package co.dfns.sdk.vaults.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VaultLock(
    @JsonProperty("id") String id,
    @JsonProperty("vaultId") String vaultId,
    @JsonProperty("network") String network,
    @JsonProperty("tid") String tid,
    @JsonProperty("amount") String amount,
    @JsonProperty("owner") String owner,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("externalId") String externalId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("reason") String reason,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("replacesLockId") String replacesLockId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("replacedByLockId") String replacedByLockId,
    @JsonProperty("dateCreated") String dateCreated,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("dateDeleted") String dateDeleted
) {}
