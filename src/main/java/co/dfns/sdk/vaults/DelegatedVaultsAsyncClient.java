package co.dfns.sdk.vaults;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.vaults.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedVaultsAsyncClient {
    private final DfnsHttpClient httpClient;

    public DelegatedVaultsAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Vaults */
    public CompletableFuture<PaginatedList<Vault>> listVaults(ListVaultsQuery query) {
        return httpClient.getAsync("/vaults", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Vault>>() {});
    }

    /** Delegated signing step 1 for Create Vault: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createVaultInit(CreateVaultRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/vaults", body);
    }

    /** Delegated signing step 2 for Create Vault: submits the signed challenge and issues the request. */
    public CompletableFuture<Vault> createVaultComplete(CreateVaultRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/vaults", java.util.Map.of(), body, Vault.class, userAction));
    }

    /** Delegated signing step 1 for Create Vault Address: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createVaultAddressInit(String vaultId, CreateVaultAddressRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/vaults/" + vaultId + "/addresses", body);
    }

    /** Delegated signing step 2 for Create Vault Address: submits the signed challenge and issues the request. */
    public CompletableFuture<VaultAddress> createVaultAddressComplete(String vaultId, CreateVaultAddressRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/vaults/" + vaultId + "/addresses", java.util.Map.of(), body, VaultAddress.class, userAction));
    }

    /** List Vault Locks */
    public CompletableFuture<PaginatedList<VaultLock>> listVaultLocks(String vaultId, ListVaultLocksQuery query) {
        return httpClient.getAsync("/vaults/" + vaultId + "/locks", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<VaultLock>>() {});
    }

    /** Delegated signing step 1 for Create Vault Lock: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createVaultLockInit(String vaultId, CreateVaultLockRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/vaults/" + vaultId + "/locks", body);
    }

    /** Delegated signing step 2 for Create Vault Lock: submits the signed challenge and issues the request. */
    public CompletableFuture<VaultLock> createVaultLockComplete(String vaultId, CreateVaultLockRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/vaults/" + vaultId + "/locks", java.util.Map.of(), body, VaultLock.class, userAction));
    }

    /** Delegated signing step 1 for Create Vault Transfer: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createVaultTransferInit(String vaultId, CreateVaultTransferRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/vaults/" + vaultId + "/transfers", body);
    }

    /** Delegated signing step 2 for Create Vault Transfer: submits the signed challenge and issues the request. */
    public CompletableFuture<TransferRequest> createVaultTransferComplete(String vaultId, CreateVaultTransferRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/vaults/" + vaultId + "/transfers", java.util.Map.of(), body, TransferRequest.class, userAction));
    }

    /** Get Vault */
    public CompletableFuture<Vault> getVault(String vaultId) {
        return httpClient.getAsync("/vaults/" + vaultId, java.util.Map.of(), Vault.class);
    }

    /** Delegated signing step 1 for Update Vault: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> updateVaultInit(String vaultId, UpdateVaultRequest body) {
        return httpClient.createUserActionChallengeAsync("PUT", "/vaults/" + vaultId, body);
    }

    /** Delegated signing step 2 for Update Vault: submits the signed challenge and issues the request. */
    public CompletableFuture<Vault> updateVaultComplete(String vaultId, UpdateVaultRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("PUT", "/vaults/" + vaultId, java.util.Map.of(), body, Vault.class, userAction));
    }

    /** Get Vault Lock */
    public CompletableFuture<VaultLock> getVaultLock(String vaultId, String lockId) {
        return httpClient.getAsync("/vaults/" + vaultId + "/locks/" + lockId, java.util.Map.of(), VaultLock.class);
    }

    /** List Vault Assets */
    public CompletableFuture<ListVaultAssetsResponse> listVaultAssets(String vaultId, ListVaultAssetsQuery query) {
        return httpClient.getAsync("/vaults/" + vaultId + "/assets", query.toMap(), ListVaultAssetsResponse.class);
    }

    /** List Vault Balances */
    public CompletableFuture<PaginatedList<VaultBalanceEntry>> listVaultBalances(String vaultId, ListVaultBalancesQuery query) {
        return httpClient.getAsync("/vaults/" + vaultId + "/balances", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<VaultBalanceEntry>>() {});
    }

    /** Delegated signing step 1 for Release Quarantine: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> releaseQuarantineInit(String vaultId, String quarantineId, ReleaseQuarantineRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/vaults/" + vaultId + "/quarantines/" + quarantineId + "/release", body);
    }

    /** Delegated signing step 2 for Release Quarantine: submits the signed challenge and issues the request. */
    public CompletableFuture<VaultReleaseQuarantineRequest> releaseQuarantineComplete(String vaultId, String quarantineId, ReleaseQuarantineRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/vaults/" + vaultId + "/quarantines/" + quarantineId + "/release", java.util.Map.of(), body, VaultReleaseQuarantineRequest.class, userAction));
    }

    /** Delegated signing step 1 for Release Vault Lock: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> releaseVaultLockInit(String vaultId, String lockId) {
        return httpClient.createUserActionChallengeAsync("POST", "/vaults/" + vaultId + "/locks/" + lockId + "/release", null);
    }

    /** Delegated signing step 2 for Release Vault Lock: submits the signed challenge and issues the request. */
    public CompletableFuture<VaultLock> releaseVaultLockComplete(String vaultId, String lockId, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/vaults/" + vaultId + "/locks/" + lockId + "/release", java.util.Map.of(), null, VaultLock.class, userAction));
    }

    /** Delegated signing step 1 for Tag Vault: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> tagVaultInit(String vaultId, TagVaultRequest body) {
        return httpClient.createUserActionChallengeAsync("PUT", "/vaults/" + vaultId + "/tags", body);
    }

    /** Delegated signing step 2 for Tag Vault: submits the signed challenge and issues the request. */
    @SuppressWarnings("unchecked")
    public CompletableFuture<Map<String, Object>> tagVaultComplete(String vaultId, TagVaultRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("PUT", "/vaults/" + vaultId + "/tags", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, userAction));
    }

    /** Delegated signing step 1 for Untag Vault: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> untagVaultInit(String vaultId, UntagVaultRequest body) {
        return httpClient.createUserActionChallengeAsync("DELETE", "/vaults/" + vaultId + "/tags", body);
    }

    /** Delegated signing step 2 for Untag Vault: submits the signed challenge and issues the request. */
    @SuppressWarnings("unchecked")
    public CompletableFuture<Map<String, Object>> untagVaultComplete(String vaultId, UntagVaultRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("DELETE", "/vaults/" + vaultId + "/tags", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, userAction));
    }
}
