package co.dfns.sdk.permissions.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Permission(
    @JsonProperty("id") String id,
    @JsonProperty("name") String name,
    @JsonProperty("operations") List<String> operations,
    @JsonProperty("status") String status,
    @JsonProperty("isImmutable") Boolean isImmutable,
    @JsonProperty("isArchived") Boolean isArchived,
    @JsonProperty("dateCreated") String dateCreated,
    @JsonProperty("dateUpdated") String dateUpdated
) {}
