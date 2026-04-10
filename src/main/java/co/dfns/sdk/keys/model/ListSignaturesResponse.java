package co.dfns.sdk.keys.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ListSignaturesResponse(
    @JsonProperty("items") List<SignatureRequest> items,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("nextPageToken") String nextPageToken,
    @JsonProperty("keyId") String keyId
) {}
