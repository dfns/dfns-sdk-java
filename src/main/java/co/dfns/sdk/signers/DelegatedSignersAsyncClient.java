package co.dfns.sdk.signers;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.signers.model.*;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedSignersAsyncClient {
    private final DfnsHttpClient httpClient;

    public DelegatedSignersAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Delegated signing step 1 for Cancel Fleet Operation: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> cancelFleetOperationInit(String storeId, CancelFleetOperationRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/key-stores/" + storeId + "/fleet-operations/cancel", body);
    }

    /** Delegated signing step 2 for Cancel Fleet Operation: submits the signed challenge and issues the request. */
    public CompletableFuture<CancelFleetOperationResponse> cancelFleetOperationComplete(String storeId, CancelFleetOperationRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/key-stores/" + storeId + "/fleet-operations/cancel", java.util.Map.of(), body, CancelFleetOperationResponse.class, userAction));
    }

    /** Delegated signing step 1 for Create Add Mac User Input: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createAddMacUserInputInit(String storeId, CreateAddMacUserInputRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/key-stores/" + storeId + "/add-mac-user/input", body);
    }

    /** Delegated signing step 2 for Create Add Mac User Input: submits the signed challenge and issues the request. */
    public CompletableFuture<Object> createAddMacUserInputComplete(String storeId, CreateAddMacUserInputRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/key-stores/" + storeId + "/add-mac-user/input", java.util.Map.of(), body, Object.class, userAction));
    }

    /** Delegated signing step 1 for Create Add Provisioner Input: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createAddProvisionerInputInit(String storeId, CreateAddProvisionerInputRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/key-stores/" + storeId + "/add-provisioner/input", body);
    }

    /** Delegated signing step 2 for Create Add Provisioner Input: submits the signed challenge and issues the request. */
    public CompletableFuture<Object> createAddProvisionerInputComplete(String storeId, CreateAddProvisionerInputRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/key-stores/" + storeId + "/add-provisioner/input", java.util.Map.of(), body, Object.class, userAction));
    }

    /** Delegated signing step 1 for Create Clone Input: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createCloneInputInit(String storeId, CreateCloneInputRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/key-stores/" + storeId + "/clone/input", body);
    }

    /** Delegated signing step 2 for Create Clone Input: submits the signed challenge and issues the request. */
    public CompletableFuture<Object> createCloneInputComplete(String storeId, CreateCloneInputRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/key-stores/" + storeId + "/clone/input", java.util.Map.of(), body, Object.class, userAction));
    }

    /** Delegated signing step 1 for Create Genesis Input: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createGenesisInputInit(String storeId, CreateGenesisInputRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/key-stores/" + storeId + "/genesis/input", body);
    }

    /** Delegated signing step 2 for Create Genesis Input: submits the signed challenge and issues the request. */
    public CompletableFuture<Object> createGenesisInputComplete(String storeId, CreateGenesisInputRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/key-stores/" + storeId + "/genesis/input", java.util.Map.of(), body, Object.class, userAction));
    }

    /** Delegated signing step 1 for Create Key Harvest Input: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createKeyHarvestInputInit(String storeId, CreateKeyHarvestInputRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/key-stores/" + storeId + "/key-harvest/input", body);
    }

    /** Delegated signing step 2 for Create Key Harvest Input: submits the signed challenge and issues the request. */
    public CompletableFuture<Object> createKeyHarvestInputComplete(String storeId, CreateKeyHarvestInputRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/key-stores/" + storeId + "/key-harvest/input", java.util.Map.of(), body, Object.class, userAction));
    }

    /** Delegated signing step 1 for Create Onchain Sign Input: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createOnchainSignInputInit(String storeId, Map<String, Object> body) {
        return httpClient.createUserActionChallengeAsync("POST", "/key-stores/" + storeId + "/onchain-sign/input", body);
    }

    /** Delegated signing step 2 for Create Onchain Sign Input: submits the signed challenge and issues the request. */
    public CompletableFuture<Object> createOnchainSignInputComplete(String storeId, Map<String, Object> body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/key-stores/" + storeId + "/onchain-sign/input", java.util.Map.of(), body, Object.class, userAction));
    }

    /** Delegated signing step 1 for Create Proof Of Control Input: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createProofOfControlInputInit(String storeId, CreateProofOfControlInputRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/key-stores/" + storeId + "/proof-of-control/input", body);
    }

    /** Delegated signing step 2 for Create Proof Of Control Input: submits the signed challenge and issues the request. */
    public CompletableFuture<Object> createProofOfControlInputComplete(String storeId, CreateProofOfControlInputRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/key-stores/" + storeId + "/proof-of-control/input", java.util.Map.of(), body, Object.class, userAction));
    }

    /** List Key Stores */
    public CompletableFuture<ListKeyStoresResponse> listKeyStores() {
        return httpClient.getAsync("/key-stores", java.util.Map.of(), ListKeyStoresResponse.class);
    }

    /** List Signers */
    public CompletableFuture<ListSignersResponse> listSigners() {
        return httpClient.getAsync("/signers", java.util.Map.of(), ListSignersResponse.class);
    }

    /** Submit Add Mac User Output */
    public CompletableFuture<SubmitAddMacUserOutputResponse> submitAddMacUserOutput(String storeId, SubmitAddMacUserOutputRequest body, byte[] file) {
        return httpClient.postMultipartAsync("/key-stores/" + storeId + "/add-mac-user/output", java.util.Map.of(), body, file, SubmitAddMacUserOutputResponse.class, true);
    }

    /** Submit Add Provisioner Output */
    public CompletableFuture<SubmitAddProvisionerOutputResponse> submitAddProvisionerOutput(String storeId, SubmitAddProvisionerOutputRequest body, byte[] file) {
        return httpClient.postMultipartAsync("/key-stores/" + storeId + "/add-provisioner/output", java.util.Map.of(), body, file, SubmitAddProvisionerOutputResponse.class, true);
    }

    /** Submit Clone Output */
    public CompletableFuture<SubmitCloneOutputResponse> submitCloneOutput(String storeId, SubmitCloneOutputRequest body, byte[] file) {
        return httpClient.postMultipartAsync("/key-stores/" + storeId + "/clone/output", java.util.Map.of(), body, file, SubmitCloneOutputResponse.class, true);
    }

    /** Submit Genesis Output */
    public CompletableFuture<SubmitGenesisOutputResponse> submitGenesisOutput(String storeId, SubmitGenesisOutputRequest body, byte[] file) {
        return httpClient.postMultipartAsync("/key-stores/" + storeId + "/genesis/output", java.util.Map.of(), body, file, SubmitGenesisOutputResponse.class, true);
    }

    /** Submit Key Harvest Output */
    public CompletableFuture<SubmitKeyHarvestOutputResponse> submitKeyHarvestOutput(String storeId, SubmitKeyHarvestOutputRequest body, byte[] file) {
        return httpClient.postMultipartAsync("/key-stores/" + storeId + "/key-harvest/output", java.util.Map.of(), body, file, SubmitKeyHarvestOutputResponse.class, true);
    }

    /** Submit Onchain Sign Output */
    public CompletableFuture<SubmitOnchainSignOutputResponse> submitOnchainSignOutput(String storeId, SubmitOnchainSignOutputRequest body, byte[] file) {
        return httpClient.postMultipartAsync("/key-stores/" + storeId + "/onchain-sign/output", java.util.Map.of(), body, file, SubmitOnchainSignOutputResponse.class, true);
    }

    /** Submit Proof Of Control Output */
    public CompletableFuture<SubmitProofOfControlOutputResponse> submitProofOfControlOutput(String storeId, SubmitProofOfControlOutputRequest body, byte[] file) {
        return httpClient.postMultipartAsync("/key-stores/" + storeId + "/proof-of-control/output", java.util.Map.of(), body, file, SubmitProofOfControlOutputResponse.class, true);
    }
}
