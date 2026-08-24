package co.dfns.sdk.vaults;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.vaults.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.Map;

public class VaultsClient {
    private final DfnsHttpClient httpClient;

    public VaultsClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** List Vaults */
    public PaginatedList<Vault> listVaults(ListVaultsQuery query) {
        return httpClient.get("/vaults", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Vault>>() {});
    }

    /** Create Vault */
    public Vault createVault(CreateVaultRequest body) {
        return httpClient.post("/vaults", java.util.Map.of(), body, Vault.class, true);
    }

    /** Create Vault Address */
    public VaultAddress createVaultAddress(String vaultId, CreateVaultAddressRequest body) {
        return httpClient.post("/vaults/" + vaultId + "/addresses", java.util.Map.of(), body, VaultAddress.class, true);
    }

    /** List Vault Locks */
    public PaginatedList<VaultLock> listVaultLocks(String vaultId, ListVaultLocksQuery query) {
        return httpClient.get("/vaults/" + vaultId + "/locks", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<VaultLock>>() {});
    }

    /** Create Vault Lock */
    public VaultLockRequest createVaultLock(String vaultId, CreateVaultLockRequest body) {
        return httpClient.post("/vaults/" + vaultId + "/locks", java.util.Map.of(), body, VaultLockRequest.class, true);
    }

    /** Create Vault Transfer */
    public TransferRequest createVaultTransfer(String vaultId, CreateVaultTransferRequest body) {
        return httpClient.post("/vaults/" + vaultId + "/transfers", java.util.Map.of(), body, TransferRequest.class, true);
    }

    /** Get Vault Lock */
    public VaultLock getVaultLock(String vaultId, String lockId) {
        return httpClient.get("/vaults/" + vaultId + "/locks/" + lockId, java.util.Map.of(), VaultLock.class);
    }

    /** Delete Vault Lock */
    public VaultLock deleteVaultLock(String vaultId, String lockId) {
        return httpClient.delete("/vaults/" + vaultId + "/locks/" + lockId, java.util.Map.of(), null, VaultLock.class, true);
    }

    /** Get Vault */
    public Vault getVault(String vaultId) {
        return httpClient.get("/vaults/" + vaultId, java.util.Map.of(), Vault.class);
    }

    /** Update Vault */
    public Vault updateVault(String vaultId, UpdateVaultRequest body) {
        return httpClient.put("/vaults/" + vaultId, java.util.Map.of(), body, Vault.class, true);
    }

    /** List Vault Assets */
    public ListVaultAssetsResponse listVaultAssets(String vaultId, ListVaultAssetsQuery query) {
        return httpClient.get("/vaults/" + vaultId + "/assets", query.toMap(), ListVaultAssetsResponse.class);
    }

    /** List Vault Balances */
    public PaginatedList<VaultBalanceEntry> listVaultBalances(String vaultId, ListVaultBalancesQuery query) {
        return httpClient.get("/vaults/" + vaultId + "/balances", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<VaultBalanceEntry>>() {});
    }

    /** Release Quarantine */
    public VaultReleaseQuarantineRequest releaseQuarantine(String vaultId, String quarantineId, ReleaseQuarantineRequest body) {
        return httpClient.post("/vaults/" + vaultId + "/quarantines/" + quarantineId + "/release", java.util.Map.of(), body, VaultReleaseQuarantineRequest.class, true);
    }

    /** Tag Vault */
    @SuppressWarnings("unchecked")
    public Map<String, Object> tagVault(String vaultId, TagVaultRequest body) {
        return httpClient.put("/vaults/" + vaultId + "/tags", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, true);
    }

    /** Untag Vault */
    @SuppressWarnings("unchecked")
    public Map<String, Object> untagVault(String vaultId, UntagVaultRequest body) {
        return httpClient.delete("/vaults/" + vaultId + "/tags", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, true);
    }
}
