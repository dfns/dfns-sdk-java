package co.dfns.sdk.networks;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.networks.model.*;
import java.util.Map;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.concurrent.CompletableFuture;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedNetworksAsyncClient {
    private final DfnsHttpClient httpClient;

    public DelegatedNetworksAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Estimate Fees */
    public CompletableFuture<Object> estimateFees(EstimateFeesQuery query) {
        return httpClient.getAsync("/networks/fees", query.toMap(), Object.class);
    }

    /** Call Function */
    @SuppressWarnings("unchecked")
    public CompletableFuture<Map<String, Object>> callFunction(String network, CallFunctionRequest body) {
        return httpClient.postAsync("/networks/" + network + "/call-function", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, false);
    }

    /** Get Canton Validator */
    public CompletableFuture<CantonValidator> getCantonValidator(String network, String validatorId) {
        return httpClient.getAsync("/networks/" + network + "/validators/" + validatorId, java.util.Map.of(), CantonValidator.class);
    }

    /** Delegated signing step 1 for Update Canton Validator: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> updateCantonValidatorInit(String network, String validatorId, UpdateCantonValidatorRequest body) {
        return httpClient.createUserActionChallengeAsync("PUT", "/networks/" + network + "/validators/" + validatorId, body);
    }

    /** Delegated signing step 2 for Update Canton Validator: submits the signed challenge and issues the request. */
    public CompletableFuture<CantonValidator> updateCantonValidatorComplete(String network, String validatorId, UpdateCantonValidatorRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("PUT", "/networks/" + network + "/validators/" + validatorId, java.util.Map.of(), body, CantonValidator.class, userAction));
    }

    /** Delegated signing step 1 for Delete Canton Validator: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> deleteCantonValidatorInit(String network, String validatorId) {
        return httpClient.createUserActionChallengeAsync("DELETE", "/networks/" + network + "/validators/" + validatorId, null);
    }

    /** Delegated signing step 2 for Delete Canton Validator: submits the signed challenge and issues the request. */
    public CompletableFuture<CantonValidator> deleteCantonValidatorComplete(String network, String validatorId, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("DELETE", "/networks/" + network + "/validators/" + validatorId, java.util.Map.of(), null, CantonValidator.class, userAction));
    }

    /** List Canton Validators */
    public CompletableFuture<PaginatedList<CantonValidator>> listCantonValidators(String network, ListCantonValidatorsQuery query) {
        return httpClient.getAsync("/networks/" + network + "/validators", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<CantonValidator>>() {});
    }

    /** Delegated signing step 1 for Create Canton Validator: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createCantonValidatorInit(String network, Object body) {
        return httpClient.createUserActionChallengeAsync("POST", "/networks/" + network + "/validators", body);
    }

    /** Delegated signing step 2 for Create Canton Validator: submits the signed challenge and issues the request. */
    public CompletableFuture<CantonValidator> createCantonValidatorComplete(String network, Object body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/networks/" + network + "/validators", java.util.Map.of(), body, CantonValidator.class, userAction));
    }
}
