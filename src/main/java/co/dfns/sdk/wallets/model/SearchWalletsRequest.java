package co.dfns.sdk.wallets.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SearchWalletsRequest(
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("q") String q,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("sort") Map<String, Object> sort,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("limit") long limit,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("paginationToken") String paginationToken,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("includeAssets") String includeAssets,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("matching") String matching,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("filters") Map<String, Object> filters
) {}
