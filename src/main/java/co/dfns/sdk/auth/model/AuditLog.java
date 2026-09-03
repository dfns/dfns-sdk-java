package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AuditLog(
    @JsonProperty("id") Object id,
    @JsonProperty("action") String action,
    @JsonProperty("actionToken") String actionToken,
    @JsonProperty("userId") Object userId,
    @JsonProperty("username") Object username,
    @JsonProperty("datePerformed") String datePerformed,
    @JsonProperty("dateSigned") String dateSigned,
    @JsonProperty("dateResolved") String dateResolved,
    @JsonProperty("responseStatus") Object responseStatus,
    @JsonProperty("responseError") Object responseError,
    @JsonProperty("firstFactorCredential") Map<String, Object> firstFactorCredential
) {}
