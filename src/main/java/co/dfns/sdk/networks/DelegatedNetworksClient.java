package co.dfns.sdk.networks;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.networks.model.*;
import java.util.Map;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedNetworksClient {
    private final DfnsHttpClient httpClient;

    public DelegatedNetworksClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Estimate Fees */
    public Object estimateFees(EstimateFeesQuery query) {
        return httpClient.get("/networks/fees", query.toMap(), Object.class);
    }

    /** Call Function */
    @SuppressWarnings("unchecked")
    public Map<String, Object> callFunction(String network, CallFunctionRequest body) {
        return httpClient.post("/networks/" + network + "/call-function", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, false);
    }

    /** Get Canton Validator */
    public CantonValidator getCantonValidator(String network, String validatorId) {
        return httpClient.get("/networks/" + network + "/validators/" + validatorId, java.util.Map.of(), CantonValidator.class);
    }

    /** Delegated signing step 1 for Update Canton Validator: returns the challenge to sign out-of-band. */
    public UserActionChallenge updateCantonValidatorInit(String network, String validatorId, UpdateCantonValidatorRequest body) {
        return httpClient.createUserActionChallenge("PUT", "/networks/" + network + "/validators/" + validatorId, body);
    }

    /** Delegated signing step 2 for Update Canton Validator: submits the signed challenge and issues the request. */
    public CantonValidator updateCantonValidatorComplete(String network, String validatorId, UpdateCantonValidatorRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/networks/" + network + "/validators/" + validatorId, java.util.Map.of(), body, CantonValidator.class, userAction);
    }

    /** Delegated signing step 1 for Delete Canton Validator: returns the challenge to sign out-of-band. */
    public UserActionChallenge deleteCantonValidatorInit(String network, String validatorId) {
        return httpClient.createUserActionChallenge("DELETE", "/networks/" + network + "/validators/" + validatorId, null);
    }

    /** Delegated signing step 2 for Delete Canton Validator: submits the signed challenge and issues the request. */
    public CantonValidator deleteCantonValidatorComplete(String network, String validatorId, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("DELETE", "/networks/" + network + "/validators/" + validatorId, java.util.Map.of(), null, CantonValidator.class, userAction);
    }

    /** List Canton Validators */
    public PaginatedList<CantonValidator> listCantonValidators(String network, ListCantonValidatorsQuery query) {
        return httpClient.get("/networks/" + network + "/validators", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<CantonValidator>>() {});
    }

    /** Delegated signing step 1 for Create Canton Validator: returns the challenge to sign out-of-band. */
    public UserActionChallenge createCantonValidatorInit(String network, Object body) {
        return httpClient.createUserActionChallenge("POST", "/networks/" + network + "/validators", body);
    }

    /** Delegated signing step 2 for Create Canton Validator: submits the signed challenge and issues the request. */
    public CantonValidator createCantonValidatorComplete(String network, Object body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/networks/" + network + "/validators", java.util.Map.of(), body, CantonValidator.class, userAction);
    }
}
