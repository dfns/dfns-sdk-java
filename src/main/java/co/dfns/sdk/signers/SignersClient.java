package co.dfns.sdk.signers;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.signers.model.*;
import java.util.Map;

public class SignersClient {
    private final DfnsHttpClient httpClient;

    public SignersClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Create Add Mac User Input */
    public Object createAddMacUserInput(String storeId, CreateAddMacUserInputRequest body) {
        return httpClient.post("/key-stores/" + storeId + "/add-mac-user/input", java.util.Map.of(), body, Object.class, true);
    }

    /** Create Clone Input */
    public Object createCloneInput(String storeId, CreateCloneInputRequest body) {
        return httpClient.post("/key-stores/" + storeId + "/clone/input", java.util.Map.of(), body, Object.class, true);
    }

    /** Create Genesis Input */
    public Object createGenesisInput(String storeId, CreateGenesisInputRequest body) {
        return httpClient.post("/key-stores/" + storeId + "/genesis/input", java.util.Map.of(), body, Object.class, true);
    }

    /** Create Onchain Sign Input */
    public Object createOnchainSignInput(String storeId, Map<String, Object> body) {
        return httpClient.post("/key-stores/" + storeId + "/onchain-sign/input", java.util.Map.of(), body, Object.class, true);
    }

    /** Create Proof Of Control Input */
    public Object createProofOfControlInput(String storeId, CreateProofOfControlInputRequest body) {
        return httpClient.post("/key-stores/" + storeId + "/proof-of-control/input", java.util.Map.of(), body, Object.class, true);
    }

    /** List Key Stores */
    public ListKeyStoresResponse listKeyStores() {
        return httpClient.get("/key-stores", java.util.Map.of(), ListKeyStoresResponse.class);
    }

    /** List Signers */
    public ListSignersResponse listSigners() {
        return httpClient.get("/signers", java.util.Map.of(), ListSignersResponse.class);
    }

    /** Submit Add Mac User Output */
    public SubmitAddMacUserOutputResponse submitAddMacUserOutput(String storeId, SubmitAddMacUserOutputRequest body, byte[] file) {
        return httpClient.postMultipart("/key-stores/" + storeId + "/add-mac-user/output", java.util.Map.of(), body, file, SubmitAddMacUserOutputResponse.class, true);
    }

    /** Submit Clone Output */
    public SubmitCloneOutputResponse submitCloneOutput(String storeId, SubmitCloneOutputRequest body, byte[] file) {
        return httpClient.postMultipart("/key-stores/" + storeId + "/clone/output", java.util.Map.of(), body, file, SubmitCloneOutputResponse.class, true);
    }

    /** Submit Genesis Output */
    public SubmitGenesisOutputResponse submitGenesisOutput(String storeId, SubmitGenesisOutputRequest body, byte[] file) {
        return httpClient.postMultipart("/key-stores/" + storeId + "/genesis/output", java.util.Map.of(), body, file, SubmitGenesisOutputResponse.class, true);
    }

    /** Submit Onchain Sign Output */
    public SubmitOnchainSignOutputResponse submitOnchainSignOutput(String storeId, SubmitOnchainSignOutputRequest body, byte[] file) {
        return httpClient.postMultipart("/key-stores/" + storeId + "/onchain-sign/output", java.util.Map.of(), body, file, SubmitOnchainSignOutputResponse.class, true);
    }

    /** Submit Proof Of Control Output */
    public SubmitProofOfControlOutputResponse submitProofOfControlOutput(String storeId, SubmitProofOfControlOutputRequest body, byte[] file) {
        return httpClient.postMultipart("/key-stores/" + storeId + "/proof-of-control/output", java.util.Map.of(), body, file, SubmitProofOfControlOutputResponse.class, true);
    }
}
