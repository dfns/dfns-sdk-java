package co.dfns.sdk.wallets.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BulkWalletCreationJob(
    @JsonProperty("id") String id,
    @JsonProperty("orgId") String orgId,
    @JsonProperty("status") String status,
    @JsonProperty("network") Network network,
    @JsonProperty("namePrefix") String namePrefix,
    @JsonProperty("tags") List<String> tags,
    @JsonProperty("totalCount") long totalCount,
    @JsonProperty("completedCount") long completedCount,
    @JsonProperty("keystoreId") String keystoreId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("masterKeyId") String masterKeyId,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("reason") String reason,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("nextRetryDate") String nextRetryDate,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("nextRetryAttempt") long nextRetryAttempt,
    @JsonProperty("dateCreated") String dateCreated,
    @JsonProperty("dateUpdated") String dateUpdated,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("dateCompleted") String dateCompleted
) {}
