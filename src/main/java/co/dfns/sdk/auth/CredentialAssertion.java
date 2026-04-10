package co.dfns.sdk.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Credential assertion returned by a {@link Signer} after signing a challenge.
 * Sent as the firstFactor when completing user action signing.
 */
public record CredentialAssertion(
    @JsonProperty("kind") String kind,
    @JsonProperty("credentialAssertion") CredentialAssertionData credentialAssertion
) {
    public record CredentialAssertionData(
        @JsonProperty("credId") String credId,
        @JsonProperty("clientData") String clientData,
        @JsonProperty("signature") String signature
    ) {}
}
