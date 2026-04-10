package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CompleteEndUserRegistrationWithWalletsResponse(
    @JsonProperty("credential") Map<String, Object> credential,
    @JsonProperty("user") Map<String, Object> user,
    @JsonProperty("authentication") Map<String, Object> authentication,
    @JsonProperty("wallets") List<Wallet> wallets
) {}
