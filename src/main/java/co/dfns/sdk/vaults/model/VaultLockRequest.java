package co.dfns.sdk.vaults.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VaultLockRequest(
    @JsonProperty("id") String id,
    @JsonProperty("vaultId") String vaultId,
    @JsonProperty("network") String network,
    @JsonProperty("tid") String tid,
    @JsonProperty("amount") String amount,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("externalId") String externalId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("reason") String reason,
    @JsonProperty("requester") Map<String, Object> requester,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("rejectionReason") String rejectionReason,
    @JsonProperty("status") String status,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("approvalId") String approvalId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("lockId") String lockId,
    @JsonProperty("dateCreated") String dateCreated
) {}
