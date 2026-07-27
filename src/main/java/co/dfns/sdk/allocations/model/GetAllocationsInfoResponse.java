package co.dfns.sdk.allocations.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GetAllocationsInfoResponse(
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("0fns") Map<String, Object> ofns,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("SkySusds") Map<String, Object> skySusds,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("GauntletUsdcPrime") Map<String, Object> gauntletUsdcPrime,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("SteakhouseUsdt") Map<String, Object> steakhouseUsdt,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("GauntletUsdcPrimeBase") Map<String, Object> gauntletUsdcPrimeBase,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("SteakhouseUsdcBase") Map<String, Object> steakhouseUsdcBase,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("SentoraPyusdMain") Map<String, Object> sentoraPyusdMain
) {}
