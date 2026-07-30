package co.dfns.sdk.signers;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.signers.model.*;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class SignersAsyncClient {
    private final DfnsHttpClient httpClient;

    public SignersAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Cancel Fleet Operation */
    public CompletableFuture<CancelFleetOperationResponse> cancelFleetOperation(String storeId, CancelFleetOperationRequest body) {
        return httpClient.postAsync("/key-stores/" + storeId + "/fleet-operations/cancel", java.util.Map.of(), body, CancelFleetOperationResponse.class, true);
    }

    /** Create Add Mac User Input */
    public CompletableFuture<Object> createAddMacUserInput(String storeId, CreateAddMacUserInputRequest body) {
        return httpClient.postAsync("/key-stores/" + storeId + "/add-mac-user/input", java.util.Map.of(), body, Object.class, true);
    }

    /** Create Add Provisioner Input */
    public CompletableFuture<Object> createAddProvisionerInput(String storeId, CreateAddProvisionerInputRequest body) {
        return httpClient.postAsync("/key-stores/" + storeId + "/add-provisioner/input", java.util.Map.of(), body, Object.class, true);
    }

    /** Create Clone Input */
    public CompletableFuture<Object> createCloneInput(String storeId, CreateCloneInputRequest body) {
        return httpClient.postAsync("/key-stores/" + storeId + "/clone/input", java.util.Map.of(), body, Object.class, true);
    }

    /** Create Genesis Input */
    public CompletableFuture<Object> createGenesisInput(String storeId, CreateGenesisInputRequest body) {
        return httpClient.postAsync("/key-stores/" + storeId + "/genesis/input", java.util.Map.of(), body, Object.class, true);
    }

    /** Create Key Harvest Input */
    public CompletableFuture<Object> createKeyHarvestInput(String storeId, CreateKeyHarvestInputRequest body) {
        return httpClient.postAsync("/key-stores/" + storeId + "/key-harvest/input", java.util.Map.of(), body, Object.class, true);
    }

    /** Create Onchain Sign Input */
    public CompletableFuture<Object> createOnchainSignInput(String storeId, Map<String, Object> body) {
        return httpClient.postAsync("/key-stores/" + storeId + "/onchain-sign/input", java.util.Map.of(), body, Object.class, true);
    }

    /** Create Proof Of Control Input */
    public CompletableFuture<Object> createProofOfControlInput(String storeId, CreateProofOfControlInputRequest body) {
        return httpClient.postAsync("/key-stores/" + storeId + "/proof-of-control/input", java.util.Map.of(), body, Object.class, true);
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
