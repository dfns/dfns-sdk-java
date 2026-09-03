package co.dfns.sdk.wallets;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.wallets.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.Map;

public class WalletsClient {
    private final DfnsHttpClient httpClient;

    public WalletsClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Abort Transaction */
    public TransactionRequest abortTransaction(String walletId, String transactionId) {
        return httpClient.put("/wallets/" + walletId + "/transactions/" + transactionId + "/abort", java.util.Map.of(), null, TransactionRequest.class, true);
    }

    /** Abort Transfer */
    public TransferRequest abortTransfer(String walletId, String transferId) {
        return httpClient.put("/wallets/" + walletId + "/transfers/" + transferId + "/abort", java.util.Map.of(), null, TransferRequest.class, true);
    }

    /** Activate Wallet */
    public TransactionRequest activateWallet(String walletId, Object body) {
        return httpClient.post("/wallets/" + walletId + "/activate", java.util.Map.of(), body, TransactionRequest.class, true);
    }

    /** List Bulk Wallet Jobs */
    public PaginatedList<BulkWalletCreationJob> listBulkWalletJobs(ListBulkWalletJobsQuery query) {
        return httpClient.get("/wallets/bulk-create", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<BulkWalletCreationJob>>() {});
    }

    /** Bulk Create Wallets */
    public BulkWalletCreationJobHandle bulkCreateWallets(BulkCreateWalletsRequest body) {
        return httpClient.post("/wallets/bulk-create", java.util.Map.of(), body, BulkWalletCreationJobHandle.class, true);
    }

    /** Get Bulk Wallet Job */
    public BulkWalletCreationJob getBulkWalletJob(String jobId) {
        return httpClient.get("/wallets/bulk-create/" + jobId, java.util.Map.of(), BulkWalletCreationJob.class);
    }

    /** List Bulk Wallet Job Wallets */
    public PaginatedList<Wallet> listBulkWalletJobWallets(String jobId, ListBulkWalletJobWalletsQuery query) {
        return httpClient.get("/wallets/bulk-create/" + jobId + "/wallets", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Wallet>>() {});
    }

    /** List Transactions */
    public ListTransactionsResponse listTransactions(String walletId, ListTransactionsQuery query) {
        return httpClient.get("/wallets/" + walletId + "/transactions", query.toMap(), ListTransactionsResponse.class);
    }

    /** Sign and Broadcast Transaction */
    public TransactionRequest signAndBroadcastTransaction(String walletId, Object body) {
        return httpClient.post("/wallets/" + walletId + "/transactions", java.util.Map.of(), body, TransactionRequest.class, true);
    }

    /** Cancel Transaction */
    public TransactionRequest cancelTransaction(String walletId, String transactionId) {
        return httpClient.post("/wallets/" + walletId + "/transactions/" + transactionId + "/cancel", java.util.Map.of(), null, TransactionRequest.class, true);
    }

    /** Cancel Transfer */
    public TransactionRequest cancelTransfer(String walletId, String transferId) {
        return httpClient.post("/wallets/" + walletId + "/transfers/" + transferId + "/cancel", java.util.Map.of(), null, TransactionRequest.class, true);
    }

    /** Proxy a request to the Canton Ledger API */
    @SuppressWarnings("unchecked")
    public Map<String, Object> proxyARequestToTheCantonLedgerApi(String walletId, ProxyARequestToTheCantonLedgerApiRequest body) {
        return httpClient.post("/wallets/" + walletId + "/canton/ledger-api", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, false);
    }

    /** Speed Up Transaction */
    public TransactionRequest speedUpTransaction(String walletId, String transactionId) {
        return httpClient.post("/wallets/" + walletId + "/transactions/" + transactionId + "/speed-up", java.util.Map.of(), null, TransactionRequest.class, true);
    }

    /** Speed Up Transfer */
    public TransactionRequest speedUpTransfer(String walletId, String transferId) {
        return httpClient.post("/wallets/" + walletId + "/transfers/" + transferId + "/speed-up", java.util.Map.of(), null, TransactionRequest.class, true);
    }

    /** List Wallets */
    public PaginatedList<Wallet> listWallets(ListWalletsQuery query) {
        return httpClient.get("/wallets", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Wallet>>() {});
    }

    /** Create Wallet */
    public Wallet createWallet(CreateWalletRequest body) {
        return httpClient.post("/wallets", java.util.Map.of(), body, Wallet.class, true);
    }

    /** Get Transaction */
    public TransactionRequest getTransaction(String walletId, String transactionId) {
        return httpClient.get("/wallets/" + walletId + "/transactions/" + transactionId, java.util.Map.of(), TransactionRequest.class);
    }

    /** Get Transfer */
    public TransferRequest getTransfer(String walletId, String transferId) {
        return httpClient.get("/wallets/" + walletId + "/transfers/" + transferId, java.util.Map.of(), TransferRequest.class);
    }

    /** Get Wallet */
    public Wallet getWallet(String walletId) {
        return httpClient.get("/wallets/" + walletId, java.util.Map.of(), Wallet.class);
    }

    /** Update Wallet */
    public Wallet updateWallet(String walletId, UpdateWalletRequest body) {
        return httpClient.put("/wallets/" + walletId, java.util.Map.of(), body, Wallet.class, true);
    }

    /** Get Wallet Assets */
    public GetWalletAssetsResponse getWalletAssets(String walletId, GetWalletAssetsQuery query) {
        return httpClient.get("/wallets/" + walletId + "/assets", query.toMap(), GetWalletAssetsResponse.class);
    }

    /** Get Wallet History */
    public GetWalletHistoryResponse getWalletHistory(String walletId, GetWalletHistoryQuery query) {
        return httpClient.get("/wallets/" + walletId + "/history", query.toMap(), GetWalletHistoryResponse.class);
    }

    /** Get Wallet Nfts */
    public GetWalletNftsResponse getWalletNfts(String walletId) {
        return httpClient.get("/wallets/" + walletId + "/nfts", java.util.Map.of(), GetWalletNftsResponse.class);
    }

    /** Import Wallet */
    public Wallet importWallet(ImportWalletRequest body) {
        return httpClient.post("/wallets/import", java.util.Map.of(), body, Wallet.class, true);
    }

    /** List Transfers */
    public ListTransfersResponse listTransfers(String walletId, ListTransfersQuery query) {
        return httpClient.get("/wallets/" + walletId + "/transfers", query.toMap(), ListTransfersResponse.class);
    }

    /** Transfer Asset */
    public TransferRequest transferAsset(String walletId, Object body) {
        return httpClient.post("/wallets/" + walletId + "/transfers", java.util.Map.of(), body, TransferRequest.class, true);
    }

    /** Tag Wallet */
    @SuppressWarnings("unchecked")
    public Map<String, Object> tagWallet(String walletId, TagWalletRequest body) {
        return httpClient.put("/wallets/" + walletId + "/tags", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, true);
    }

    /** Untag Wallet */
    @SuppressWarnings("unchecked")
    public Map<String, Object> untagWallet(String walletId, UntagWalletRequest body) {
        return httpClient.delete("/wallets/" + walletId + "/tags", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, true);
    }

    /** Get Offer */
    public Offer getOffer(String walletId, String offerId) {
        return httpClient.get("/wallets/" + walletId + "/offers/" + offerId, java.util.Map.of(), Offer.class);
    }

    /** List Offers */
    public PaginatedList<Offer> listOffers(String walletId, ListOffersQuery query) {
        return httpClient.get("/wallets/" + walletId + "/offers", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Offer>>() {});
    }

    /** Accept Offer */
    public Offer acceptOffer(String walletId, String offerId) {
        return httpClient.put("/wallets/" + walletId + "/offers/" + offerId + "/accept", java.util.Map.of(), null, Offer.class, true);
    }

    /** Reject Offer */
    public Offer rejectOffer(String walletId, String offerId) {
        return httpClient.put("/wallets/" + walletId + "/offers/" + offerId + "/reject", java.util.Map.of(), null, Offer.class, true);
    }

    /** List Org Wallet History */
    public Object listOrgWalletHistory(ListOrgWalletHistoryQuery query) {
        return httpClient.get("/wallets/all/history", query.toMap(), Object.class);
    }
}
