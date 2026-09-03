package co.dfns.sdk.wallets;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.wallets.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class WalletsAsyncClient {
    private final DfnsHttpClient httpClient;

    public WalletsAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Abort Transaction */
    public CompletableFuture<TransactionRequest> abortTransaction(String walletId, String transactionId) {
        return httpClient.putAsync("/wallets/" + walletId + "/transactions/" + transactionId + "/abort", java.util.Map.of(), null, TransactionRequest.class, true);
    }

    /** Abort Transfer */
    public CompletableFuture<TransferRequest> abortTransfer(String walletId, String transferId) {
        return httpClient.putAsync("/wallets/" + walletId + "/transfers/" + transferId + "/abort", java.util.Map.of(), null, TransferRequest.class, true);
    }

    /** Activate Wallet */
    public CompletableFuture<TransactionRequest> activateWallet(String walletId, Object body) {
        return httpClient.postAsync("/wallets/" + walletId + "/activate", java.util.Map.of(), body, TransactionRequest.class, true);
    }

    /** List Bulk Wallet Jobs */
    public CompletableFuture<PaginatedList<BulkWalletCreationJob>> listBulkWalletJobs(ListBulkWalletJobsQuery query) {
        return httpClient.getAsync("/wallets/bulk-create", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<BulkWalletCreationJob>>() {});
    }

    /** Bulk Create Wallets */
    public CompletableFuture<BulkWalletCreationJobHandle> bulkCreateWallets(BulkCreateWalletsRequest body) {
        return httpClient.postAsync("/wallets/bulk-create", java.util.Map.of(), body, BulkWalletCreationJobHandle.class, true);
    }

    /** Get Bulk Wallet Job */
    public CompletableFuture<BulkWalletCreationJob> getBulkWalletJob(String jobId) {
        return httpClient.getAsync("/wallets/bulk-create/" + jobId, java.util.Map.of(), BulkWalletCreationJob.class);
    }

    /** List Bulk Wallet Job Wallets */
    public CompletableFuture<PaginatedList<Wallet>> listBulkWalletJobWallets(String jobId, ListBulkWalletJobWalletsQuery query) {
        return httpClient.getAsync("/wallets/bulk-create/" + jobId + "/wallets", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Wallet>>() {});
    }

    /** List Transactions */
    public CompletableFuture<ListTransactionsResponse> listTransactions(String walletId, ListTransactionsQuery query) {
        return httpClient.getAsync("/wallets/" + walletId + "/transactions", query.toMap(), ListTransactionsResponse.class);
    }

    /** Sign and Broadcast Transaction */
    public CompletableFuture<TransactionRequest> signAndBroadcastTransaction(String walletId, Object body) {
        return httpClient.postAsync("/wallets/" + walletId + "/transactions", java.util.Map.of(), body, TransactionRequest.class, true);
    }

    /** Cancel Transaction */
    public CompletableFuture<TransactionRequest> cancelTransaction(String walletId, String transactionId) {
        return httpClient.postAsync("/wallets/" + walletId + "/transactions/" + transactionId + "/cancel", java.util.Map.of(), null, TransactionRequest.class, true);
    }

    /** Cancel Transfer */
    public CompletableFuture<TransactionRequest> cancelTransfer(String walletId, String transferId) {
        return httpClient.postAsync("/wallets/" + walletId + "/transfers/" + transferId + "/cancel", java.util.Map.of(), null, TransactionRequest.class, true);
    }

    /** Proxy a request to the Canton Ledger API */
    @SuppressWarnings("unchecked")
    public CompletableFuture<Map<String, Object>> proxyARequestToTheCantonLedgerApi(String walletId, ProxyARequestToTheCantonLedgerApiRequest body) {
        return httpClient.postAsync("/wallets/" + walletId + "/canton/ledger-api", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, false);
    }

    /** Speed Up Transaction */
    public CompletableFuture<TransactionRequest> speedUpTransaction(String walletId, String transactionId) {
        return httpClient.postAsync("/wallets/" + walletId + "/transactions/" + transactionId + "/speed-up", java.util.Map.of(), null, TransactionRequest.class, true);
    }

    /** Speed Up Transfer */
    public CompletableFuture<TransactionRequest> speedUpTransfer(String walletId, String transferId) {
        return httpClient.postAsync("/wallets/" + walletId + "/transfers/" + transferId + "/speed-up", java.util.Map.of(), null, TransactionRequest.class, true);
    }

    /** List Wallets */
    public CompletableFuture<PaginatedList<Wallet>> listWallets(ListWalletsQuery query) {
        return httpClient.getAsync("/wallets", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Wallet>>() {});
    }

    /** Create Wallet */
    public CompletableFuture<Wallet> createWallet(CreateWalletRequest body) {
        return httpClient.postAsync("/wallets", java.util.Map.of(), body, Wallet.class, true);
    }

    /** Get Transaction */
    public CompletableFuture<TransactionRequest> getTransaction(String walletId, String transactionId) {
        return httpClient.getAsync("/wallets/" + walletId + "/transactions/" + transactionId, java.util.Map.of(), TransactionRequest.class);
    }

    /** Get Transfer */
    public CompletableFuture<TransferRequest> getTransfer(String walletId, String transferId) {
        return httpClient.getAsync("/wallets/" + walletId + "/transfers/" + transferId, java.util.Map.of(), TransferRequest.class);
    }

    /** Get Wallet */
    public CompletableFuture<Wallet> getWallet(String walletId) {
        return httpClient.getAsync("/wallets/" + walletId, java.util.Map.of(), Wallet.class);
    }

    /** Update Wallet */
    public CompletableFuture<Wallet> updateWallet(String walletId, UpdateWalletRequest body) {
        return httpClient.putAsync("/wallets/" + walletId, java.util.Map.of(), body, Wallet.class, true);
    }

    /** Get Wallet Assets */
    public CompletableFuture<GetWalletAssetsResponse> getWalletAssets(String walletId, GetWalletAssetsQuery query) {
        return httpClient.getAsync("/wallets/" + walletId + "/assets", query.toMap(), GetWalletAssetsResponse.class);
    }

    /** Get Wallet History */
    public CompletableFuture<GetWalletHistoryResponse> getWalletHistory(String walletId, GetWalletHistoryQuery query) {
        return httpClient.getAsync("/wallets/" + walletId + "/history", query.toMap(), GetWalletHistoryResponse.class);
    }

    /** Get Wallet Nfts */
    public CompletableFuture<GetWalletNftsResponse> getWalletNfts(String walletId) {
        return httpClient.getAsync("/wallets/" + walletId + "/nfts", java.util.Map.of(), GetWalletNftsResponse.class);
    }

    /** Import Wallet */
    public CompletableFuture<Wallet> importWallet(ImportWalletRequest body) {
        return httpClient.postAsync("/wallets/import", java.util.Map.of(), body, Wallet.class, true);
    }

    /** List Transfers */
    public CompletableFuture<ListTransfersResponse> listTransfers(String walletId, ListTransfersQuery query) {
        return httpClient.getAsync("/wallets/" + walletId + "/transfers", query.toMap(), ListTransfersResponse.class);
    }

    /** Transfer Asset */
    public CompletableFuture<TransferRequest> transferAsset(String walletId, Object body) {
        return httpClient.postAsync("/wallets/" + walletId + "/transfers", java.util.Map.of(), body, TransferRequest.class, true);
    }

    /** Tag Wallet */
    @SuppressWarnings("unchecked")
    public CompletableFuture<Map<String, Object>> tagWallet(String walletId, TagWalletRequest body) {
        return httpClient.putAsync("/wallets/" + walletId + "/tags", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, true);
    }

    /** Untag Wallet */
    @SuppressWarnings("unchecked")
    public CompletableFuture<Map<String, Object>> untagWallet(String walletId, UntagWalletRequest body) {
        return httpClient.deleteAsync("/wallets/" + walletId + "/tags", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, true);
    }

    /** Get Offer */
    public CompletableFuture<Offer> getOffer(String walletId, String offerId) {
        return httpClient.getAsync("/wallets/" + walletId + "/offers/" + offerId, java.util.Map.of(), Offer.class);
    }

    /** List Offers */
    public CompletableFuture<PaginatedList<Offer>> listOffers(String walletId, ListOffersQuery query) {
        return httpClient.getAsync("/wallets/" + walletId + "/offers", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Offer>>() {});
    }

    /** Accept Offer */
    public CompletableFuture<Offer> acceptOffer(String walletId, String offerId) {
        return httpClient.putAsync("/wallets/" + walletId + "/offers/" + offerId + "/accept", java.util.Map.of(), null, Offer.class, true);
    }

    /** Reject Offer */
    public CompletableFuture<Offer> rejectOffer(String walletId, String offerId) {
        return httpClient.putAsync("/wallets/" + walletId + "/offers/" + offerId + "/reject", java.util.Map.of(), null, Offer.class, true);
    }

    /** List Org Wallet History */
    public CompletableFuture<Object> listOrgWalletHistory(ListOrgWalletHistoryQuery query) {
        return httpClient.getAsync("/wallets/all/history", query.toMap(), Object.class);
    }
}
