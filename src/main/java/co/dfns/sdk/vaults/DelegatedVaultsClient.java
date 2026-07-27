package co.dfns.sdk.vaults;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.vaults.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.Map;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedVaultsClient {
    private final DfnsHttpClient httpClient;

    public DelegatedVaultsClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Vaults */
    public PaginatedList<Vault> listVaults(ListVaultsQuery query) {
        return httpClient.get("/vaults", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Vault>>() {});
    }

    /** Delegated signing step 1 for Create Vault: returns the challenge to sign out-of-band. */
    public UserActionChallenge createVaultInit(CreateVaultRequest body) {
        return httpClient.createUserActionChallenge("POST", "/vaults", body);
    }

    /** Delegated signing step 2 for Create Vault: submits the signed challenge and issues the request. */
    public Vault createVaultComplete(CreateVaultRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/vaults", java.util.Map.of(), body, Vault.class, userAction);
    }

    /** Delegated signing step 1 for Create Vault Address: returns the challenge to sign out-of-band. */
    public UserActionChallenge createVaultAddressInit(String vaultId, CreateVaultAddressRequest body) {
        return httpClient.createUserActionChallenge("POST", "/vaults/" + vaultId + "/addresses", body);
    }

    /** Delegated signing step 2 for Create Vault Address: submits the signed challenge and issues the request. */
    public VaultAddress createVaultAddressComplete(String vaultId, CreateVaultAddressRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/vaults/" + vaultId + "/addresses", java.util.Map.of(), body, VaultAddress.class, userAction);
    }

    /** Delegated signing step 1 for Create Vault Transfer: returns the challenge to sign out-of-band. */
    public UserActionChallenge createVaultTransferInit(String vaultId, CreateVaultTransferRequest body) {
        return httpClient.createUserActionChallenge("POST", "/vaults/" + vaultId + "/transfers", body);
    }

    /** Delegated signing step 2 for Create Vault Transfer: submits the signed challenge and issues the request. */
    public TransferRequest createVaultTransferComplete(String vaultId, CreateVaultTransferRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/vaults/" + vaultId + "/transfers", java.util.Map.of(), body, TransferRequest.class, userAction);
    }

    /** Get Vault */
    public Vault getVault(String vaultId) {
        return httpClient.get("/vaults/" + vaultId, java.util.Map.of(), Vault.class);
    }

    /** Delegated signing step 1 for Update Vault: returns the challenge to sign out-of-band. */
    public UserActionChallenge updateVaultInit(String vaultId, UpdateVaultRequest body) {
        return httpClient.createUserActionChallenge("PUT", "/vaults/" + vaultId, body);
    }

    /** Delegated signing step 2 for Update Vault: submits the signed challenge and issues the request. */
    public Vault updateVaultComplete(String vaultId, UpdateVaultRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/vaults/" + vaultId, java.util.Map.of(), body, Vault.class, userAction);
    }

    /** List Vault Assets */
    public ListVaultAssetsResponse listVaultAssets(String vaultId, ListVaultAssetsQuery query) {
        return httpClient.get("/vaults/" + vaultId + "/assets", query.toMap(), ListVaultAssetsResponse.class);
    }

    /** List Vault Balances */
    public PaginatedList<VaultBalanceEntry> listVaultBalances(String vaultId, ListVaultBalancesQuery query) {
        return httpClient.get("/vaults/" + vaultId + "/balances", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<VaultBalanceEntry>>() {});
    }

    /** Delegated signing step 1 for Release Quarantine: returns the challenge to sign out-of-band. */
    public UserActionChallenge releaseQuarantineInit(String vaultId, String quarantineId, ReleaseQuarantineRequest body) {
        return httpClient.createUserActionChallenge("POST", "/vaults/" + vaultId + "/quarantines/" + quarantineId + "/release", body);
    }

    /** Delegated signing step 2 for Release Quarantine: submits the signed challenge and issues the request. */
    public ReleaseQuarantineResponse releaseQuarantineComplete(String vaultId, String quarantineId, ReleaseQuarantineRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/vaults/" + vaultId + "/quarantines/" + quarantineId + "/release", java.util.Map.of(), body, ReleaseQuarantineResponse.class, userAction);
    }

    /** Delegated signing step 1 for Tag Vault: returns the challenge to sign out-of-band. */
    public UserActionChallenge tagVaultInit(String vaultId, TagVaultRequest body) {
        return httpClient.createUserActionChallenge("PUT", "/vaults/" + vaultId + "/tags", body);
    }

    /** Delegated signing step 2 for Tag Vault: submits the signed challenge and issues the request. */
    @SuppressWarnings("unchecked")
    public Map<String, Object> tagVaultComplete(String vaultId, TagVaultRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/vaults/" + vaultId + "/tags", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, userAction);
    }

    /** Delegated signing step 1 for Untag Vault: returns the challenge to sign out-of-band. */
    public UserActionChallenge untagVaultInit(String vaultId, UntagVaultRequest body) {
        return httpClient.createUserActionChallenge("DELETE", "/vaults/" + vaultId + "/tags", body);
    }

    /** Delegated signing step 2 for Untag Vault: submits the signed challenge and issues the request. */
    @SuppressWarnings("unchecked")
    public Map<String, Object> untagVaultComplete(String vaultId, UntagVaultRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("DELETE", "/vaults/" + vaultId + "/tags", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, userAction);
    }
}
