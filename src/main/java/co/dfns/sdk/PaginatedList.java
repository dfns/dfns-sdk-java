package co.dfns.sdk;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Generic paginated response wrapper for list endpoints. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PaginatedList<T>(
    @JsonProperty("items") List<T> items,
    @JsonProperty("nextPageToken") String nextPageToken
) {}
