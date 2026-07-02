package co.dfns.sdk.keys.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SignatureRequest(
    @JsonProperty("id") String id,
    @JsonProperty("keyId") String keyId,
    @JsonProperty("requester") Requester requester,
    @JsonProperty("requestBody") Object requestBody,
    @JsonProperty("status") String status,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("reason") String reason,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("signature") Map<String, Object> signature,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("signatures") List<Map<String, Object>> signatures,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("signedData") String signedData,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("network") Network network,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("txHash") String txHash,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("fee") String fee,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("approvalId") String approvalId,
    @JsonProperty("dateRequested") String dateRequested,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("datePolicyResolved") String datePolicyResolved,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("dateSigned") String dateSigned,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("dateConfirmed") String dateConfirmed,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("externalId") String externalId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("details") Map<String, Object> details
) {}
