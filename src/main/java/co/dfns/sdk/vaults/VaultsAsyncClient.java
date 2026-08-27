package co.dfns.sdk.vaults;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.vaults.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class VaultsAsyncClient {
    private final DfnsHttpClient httpClient;

    public VaultsAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Vaults */
    public CompletableFuture<PaginatedList<Vault>> listVaults(ListVaultsQuery query) {
        return httpClient.getAsync("/vaults", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Vault>>() {});
    }

    /** Create Vault */
    public CompletableFuture<Vault> createVault(CreateVaultRequest body) {
        return httpClient.postAsync("/vaults", java.util.Map.of(), body, Vault.class, true);
    }

    /** Create Vault Address */
    public CompletableFuture<VaultAddress> createVaultAddress(String vaultId, CreateVaultAddressRequest body) {
        return httpClient.postAsync("/vaults/" + vaultId + "/addresses", java.util.Map.of(), body, VaultAddress.class, true);
    }

    /** List Vault Locks */
    public CompletableFuture<PaginatedList<VaultLock>> listVaultLocks(String vaultId, ListVaultLocksQuery query) {
        return httpClient.getAsync("/vaults/" + vaultId + "/locks", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<VaultLock>>() {});
    }

    /** Create Vault Lock */
    public CompletableFuture<VaultLock> createVaultLock(String vaultId, CreateVaultLockRequest body) {
        return httpClient.postAsync("/vaults/" + vaultId + "/locks", java.util.Map.of(), body, VaultLock.class, true);
    }

    /** Create Vault Transfer */
    public CompletableFuture<TransferRequest> createVaultTransfer(String vaultId, CreateVaultTransferRequest body) {
        return httpClient.postAsync("/vaults/" + vaultId + "/transfers", java.util.Map.of(), body, TransferRequest.class, true);
    }

    /** Get Vault */
    public CompletableFuture<Vault> getVault(String vaultId) {
        return httpClient.getAsync("/vaults/" + vaultId, java.util.Map.of(), Vault.class);
    }

    /** Update Vault */
    public CompletableFuture<Vault> updateVault(String vaultId, UpdateVaultRequest body) {
        return httpClient.putAsync("/vaults/" + vaultId, java.util.Map.of(), body, Vault.class, true);
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

    /** Release Quarantine */
    public CompletableFuture<VaultReleaseQuarantineRequest> releaseQuarantine(String vaultId, String quarantineId, ReleaseQuarantineRequest body) {
        return httpClient.postAsync("/vaults/" + vaultId + "/quarantines/" + quarantineId + "/release", java.util.Map.of(), body, VaultReleaseQuarantineRequest.class, true);
    }

    /** Release Vault Lock */
    public CompletableFuture<VaultLock> releaseVaultLock(String vaultId, String lockId) {
        return httpClient.postAsync("/vaults/" + vaultId + "/locks/" + lockId + "/release", java.util.Map.of(), null, VaultLock.class, true);
    }

    /** Tag Vault */
    @SuppressWarnings("unchecked")
    public CompletableFuture<Map<String, Object>> tagVault(String vaultId, TagVaultRequest body) {
        return httpClient.putAsync("/vaults/" + vaultId + "/tags", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, true);
    }

    /** Untag Vault */
    @SuppressWarnings("unchecked")
    public CompletableFuture<Map<String, Object>> untagVault(String vaultId, UntagVaultRequest body) {
        return httpClient.deleteAsync("/vaults/" + vaultId + "/tags", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, true);
    }
}
