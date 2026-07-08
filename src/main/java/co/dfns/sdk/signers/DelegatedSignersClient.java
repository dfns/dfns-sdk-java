package co.dfns.sdk.signers;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.signers.model.*;
import java.util.Map;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedSignersClient {
    private final DfnsHttpClient httpClient;

    public DelegatedSignersClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Delegated signing step 1 for Create Add Mac User Input: returns the challenge to sign out-of-band. */
    public UserActionChallenge createAddMacUserInputInit(String storeId, CreateAddMacUserInputRequest body) {
        return httpClient.createUserActionChallenge("POST", "/key-stores/" + storeId + "/add-mac-user/input", body);
    }

    /** Delegated signing step 2 for Create Add Mac User Input: submits the signed challenge and issues the request. */
    public Object createAddMacUserInputComplete(String storeId, CreateAddMacUserInputRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/key-stores/" + storeId + "/add-mac-user/input", java.util.Map.of(), body, Object.class, userAction);
    }

    /** Delegated signing step 1 for Create Clone Input: returns the challenge to sign out-of-band. */
    public UserActionChallenge createCloneInputInit(String storeId, CreateCloneInputRequest body) {
        return httpClient.createUserActionChallenge("POST", "/key-stores/" + storeId + "/clone/input", body);
    }

    /** Delegated signing step 2 for Create Clone Input: submits the signed challenge and issues the request. */
    public Object createCloneInputComplete(String storeId, CreateCloneInputRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/key-stores/" + storeId + "/clone/input", java.util.Map.of(), body, Object.class, userAction);
    }

    /** Delegated signing step 1 for Create Genesis Input: returns the challenge to sign out-of-band. */
    public UserActionChallenge createGenesisInputInit(String storeId, CreateGenesisInputRequest body) {
        return httpClient.createUserActionChallenge("POST", "/key-stores/" + storeId + "/genesis/input", body);
    }

    /** Delegated signing step 2 for Create Genesis Input: submits the signed challenge and issues the request. */
    public Object createGenesisInputComplete(String storeId, CreateGenesisInputRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/key-stores/" + storeId + "/genesis/input", java.util.Map.of(), body, Object.class, userAction);
    }

    /** Delegated signing step 1 for Create Onchain Sign Input: returns the challenge to sign out-of-band. */
    public UserActionChallenge createOnchainSignInputInit(String storeId, Map<String, Object> body) {
        return httpClient.createUserActionChallenge("POST", "/key-stores/" + storeId + "/onchain-sign/input", body);
    }

    /** Delegated signing step 2 for Create Onchain Sign Input: submits the signed challenge and issues the request. */
    public Object createOnchainSignInputComplete(String storeId, Map<String, Object> body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/key-stores/" + storeId + "/onchain-sign/input", java.util.Map.of(), body, Object.class, userAction);
    }

    /** Delegated signing step 1 for Create Proof Of Control Input: returns the challenge to sign out-of-band. */
    public UserActionChallenge createProofOfControlInputInit(String storeId, CreateProofOfControlInputRequest body) {
        return httpClient.createUserActionChallenge("POST", "/key-stores/" + storeId + "/proof-of-control/input", body);
    }

    /** Delegated signing step 2 for Create Proof Of Control Input: submits the signed challenge and issues the request. */
    public Object createProofOfControlInputComplete(String storeId, CreateProofOfControlInputRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/key-stores/" + storeId + "/proof-of-control/input", java.util.Map.of(), body, Object.class, userAction);
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
