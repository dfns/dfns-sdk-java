package co.dfns.sdk.vaults.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VaultReleaseQuarantineRequest(
    @JsonProperty("id") String id,
    @JsonProperty("vaultId") String vaultId,
    @JsonProperty("quarantineId") String quarantineId,
    @JsonProperty("network") String network,
    @JsonProperty("transactionHash") String transactionHash,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("kytResult") Object kytResult,
    @JsonProperty("requester") Map<String, Object> requester,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("reason") String reason,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("rejectionReason") String rejectionReason,
    @JsonProperty("status") String status,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("approvalId") String approvalId,
    @JsonProperty("dateCreated") String dateCreated
) {}
