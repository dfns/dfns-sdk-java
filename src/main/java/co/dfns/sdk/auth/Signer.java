package co.dfns.sdk.auth;

/**
 * Signs a user action challenge and returns a credential assertion.
 * Implement this interface to provide custom signing logic.
 */
@FunctionalInterface
public interface Signer {
    CredentialAssertion sign(UserActionChallenge challenge) throws Exception;
}
