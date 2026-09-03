package co.dfns.sdk.wallets;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.wallets.model.*;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedWalletsAsyncClient {
    private final DfnsHttpClient httpClient;

    public DelegatedWalletsAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Delegated signing step 1 for Abort Transaction: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> abortTransactionInit(String walletId, String transactionId) {
        return httpClient.createUserActionChallengeAsync("PUT", "/wallets/" + walletId + "/transactions/" + transactionId + "/abort", null);
    }

    /** Delegated signing step 2 for Abort Transaction: submits the signed challenge and issues the request. */
    public CompletableFuture<TransactionRequest> abortTransactionComplete(String walletId, String transactionId, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("PUT", "/wallets/" + walletId + "/transactions/" + transactionId + "/abort", java.util.Map.of(), null, TransactionRequest.class, userAction));
    }

    /** Delegated signing step 1 for Abort Transfer: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> abortTransferInit(String walletId, String transferId) {
        return httpClient.createUserActionChallengeAsync("PUT", "/wallets/" + walletId + "/transfers/" + transferId + "/abort", null);
    }

    /** Delegated signing step 2 for Abort Transfer: submits the signed challenge and issues the request. */
    public CompletableFuture<TransferRequest> abortTransferComplete(String walletId, String transferId, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("PUT", "/wallets/" + walletId + "/transfers/" + transferId + "/abort", java.util.Map.of(), null, TransferRequest.class, userAction));
    }

    /** Delegated signing step 1 for Activate Wallet: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> activateWalletInit(String walletId, Object body) {
        return httpClient.createUserActionChallengeAsync("POST", "/wallets/" + walletId + "/activate", body);
    }

    /** Delegated signing step 2 for Activate Wallet: submits the signed challenge and issues the request. */
    public CompletableFuture<TransactionRequest> activateWalletComplete(String walletId, Object body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/wallets/" + walletId + "/activate", java.util.Map.of(), body, TransactionRequest.class, userAction));
    }

    /** List Bulk Wallet Jobs */
    public CompletableFuture<PaginatedList<BulkWalletCreationJob>> listBulkWalletJobs(ListBulkWalletJobsQuery query) {
        return httpClient.getAsync("/wallets/bulk-create", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<BulkWalletCreationJob>>() {});
    }

    /** Delegated signing step 1 for Bulk Create Wallets: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> bulkCreateWalletsInit(BulkCreateWalletsRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/wallets/bulk-create", body);
    }

    /** Delegated signing step 2 for Bulk Create Wallets: submits the signed challenge and issues the request. */
    public CompletableFuture<BulkWalletCreationJobHandle> bulkCreateWalletsComplete(BulkCreateWalletsRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/wallets/bulk-create", java.util.Map.of(), body, BulkWalletCreationJobHandle.class, userAction));
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

    /** Delegated signing step 1 for Sign and Broadcast Transaction: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> signAndBroadcastTransactionInit(String walletId, Object body) {
        return httpClient.createUserActionChallengeAsync("POST", "/wallets/" + walletId + "/transactions", body);
    }

    /** Delegated signing step 2 for Sign and Broadcast Transaction: submits the signed challenge and issues the request. */
    public CompletableFuture<TransactionRequest> signAndBroadcastTransactionComplete(String walletId, Object body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/wallets/" + walletId + "/transactions", java.util.Map.of(), body, TransactionRequest.class, userAction));
    }

    /** Delegated signing step 1 for Cancel Transaction: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> cancelTransactionInit(String walletId, String transactionId) {
        return httpClient.createUserActionChallengeAsync("POST", "/wallets/" + walletId + "/transactions/" + transactionId + "/cancel", null);
    }

    /** Delegated signing step 2 for Cancel Transaction: submits the signed challenge and issues the request. */
    public CompletableFuture<TransactionRequest> cancelTransactionComplete(String walletId, String transactionId, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/wallets/" + walletId + "/transactions/" + transactionId + "/cancel", java.util.Map.of(), null, TransactionRequest.class, userAction));
    }

    /** Delegated signing step 1 for Cancel Transfer: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> cancelTransferInit(String walletId, String transferId) {
        return httpClient.createUserActionChallengeAsync("POST", "/wallets/" + walletId + "/transfers/" + transferId + "/cancel", null);
    }

    /** Delegated signing step 2 for Cancel Transfer: submits the signed challenge and issues the request. */
    public CompletableFuture<TransactionRequest> cancelTransferComplete(String walletId, String transferId, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/wallets/" + walletId + "/transfers/" + transferId + "/cancel", java.util.Map.of(), null, TransactionRequest.class, userAction));
    }

    /** Proxy a request to the Canton Ledger API */
    @SuppressWarnings("unchecked")
    public CompletableFuture<Map<String, Object>> proxyARequestToTheCantonLedgerApi(String walletId, ProxyARequestToTheCantonLedgerApiRequest body) {
        return httpClient.postAsync("/wallets/" + walletId + "/canton/ledger-api", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, false);
    }

    /** Delegated signing step 1 for Speed Up Transaction: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> speedUpTransactionInit(String walletId, String transactionId) {
        return httpClient.createUserActionChallengeAsync("POST", "/wallets/" + walletId + "/transactions/" + transactionId + "/speed-up", null);
    }

    /** Delegated signing step 2 for Speed Up Transaction: submits the signed challenge and issues the request. */
    public CompletableFuture<TransactionRequest> speedUpTransactionComplete(String walletId, String transactionId, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/wallets/" + walletId + "/transactions/" + transactionId + "/speed-up", java.util.Map.of(), null, TransactionRequest.class, userAction));
    }

    /** Delegated signing step 1 for Speed Up Transfer: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> speedUpTransferInit(String walletId, String transferId) {
        return httpClient.createUserActionChallengeAsync("POST", "/wallets/" + walletId + "/transfers/" + transferId + "/speed-up", null);
    }

    /** Delegated signing step 2 for Speed Up Transfer: submits the signed challenge and issues the request. */
    public CompletableFuture<TransactionRequest> speedUpTransferComplete(String walletId, String transferId, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/wallets/" + walletId + "/transfers/" + transferId + "/speed-up", java.util.Map.of(), null, TransactionRequest.class, userAction));
    }

    /** List Wallets */
    public CompletableFuture<PaginatedList<Wallet>> listWallets(ListWalletsQuery query) {
        return httpClient.getAsync("/wallets", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Wallet>>() {});
    }

    /** Delegated signing step 1 for Create Wallet: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> createWalletInit(CreateWalletRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/wallets", body);
    }

    /** Delegated signing step 2 for Create Wallet: submits the signed challenge and issues the request. */
    public CompletableFuture<Wallet> createWalletComplete(CreateWalletRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/wallets", java.util.Map.of(), body, Wallet.class, userAction));
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

    /** Delegated signing step 1 for Update Wallet: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> updateWalletInit(String walletId, UpdateWalletRequest body) {
        return httpClient.createUserActionChallengeAsync("PUT", "/wallets/" + walletId, body);
    }

    /** Delegated signing step 2 for Update Wallet: submits the signed challenge and issues the request. */
    public CompletableFuture<Wallet> updateWalletComplete(String walletId, UpdateWalletRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("PUT", "/wallets/" + walletId, java.util.Map.of(), body, Wallet.class, userAction));
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

    /** Delegated signing step 1 for Import Wallet: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> importWalletInit(ImportWalletRequest body) {
        return httpClient.createUserActionChallengeAsync("POST", "/wallets/import", body);
    }

    /** Delegated signing step 2 for Import Wallet: submits the signed challenge and issues the request. */
    public CompletableFuture<Wallet> importWalletComplete(ImportWalletRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/wallets/import", java.util.Map.of(), body, Wallet.class, userAction));
    }

    /** List Transfers */
    public CompletableFuture<ListTransfersResponse> listTransfers(String walletId, ListTransfersQuery query) {
        return httpClient.getAsync("/wallets/" + walletId + "/transfers", query.toMap(), ListTransfersResponse.class);
    }

    /** Delegated signing step 1 for Transfer Asset: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> transferAssetInit(String walletId, Object body) {
        return httpClient.createUserActionChallengeAsync("POST", "/wallets/" + walletId + "/transfers", body);
    }

    /** Delegated signing step 2 for Transfer Asset: submits the signed challenge and issues the request. */
    public CompletableFuture<TransferRequest> transferAssetComplete(String walletId, Object body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("POST", "/wallets/" + walletId + "/transfers", java.util.Map.of(), body, TransferRequest.class, userAction));
    }

    /** Delegated signing step 1 for Tag Wallet: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> tagWalletInit(String walletId, TagWalletRequest body) {
        return httpClient.createUserActionChallengeAsync("PUT", "/wallets/" + walletId + "/tags", body);
    }

    /** Delegated signing step 2 for Tag Wallet: submits the signed challenge and issues the request. */
    @SuppressWarnings("unchecked")
    public CompletableFuture<Map<String, Object>> tagWalletComplete(String walletId, TagWalletRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("PUT", "/wallets/" + walletId + "/tags", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, userAction));
    }

    /** Delegated signing step 1 for Untag Wallet: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> untagWalletInit(String walletId, UntagWalletRequest body) {
        return httpClient.createUserActionChallengeAsync("DELETE", "/wallets/" + walletId + "/tags", body);
    }

    /** Delegated signing step 2 for Untag Wallet: submits the signed challenge and issues the request. */
    @SuppressWarnings("unchecked")
    public CompletableFuture<Map<String, Object>> untagWalletComplete(String walletId, UntagWalletRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("DELETE", "/wallets/" + walletId + "/tags", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, userAction));
    }

    /** Get Offer */
    public CompletableFuture<Offer> getOffer(String walletId, String offerId) {
        return httpClient.getAsync("/wallets/" + walletId + "/offers/" + offerId, java.util.Map.of(), Offer.class);
    }

    /** List Offers */
    public CompletableFuture<PaginatedList<Offer>> listOffers(String walletId, ListOffersQuery query) {
        return httpClient.getAsync("/wallets/" + walletId + "/offers", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Offer>>() {});
    }

    /** Delegated signing step 1 for Accept Offer: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> acceptOfferInit(String walletId, String offerId) {
        return httpClient.createUserActionChallengeAsync("PUT", "/wallets/" + walletId + "/offers/" + offerId + "/accept", null);
    }

    /** Delegated signing step 2 for Accept Offer: submits the signed challenge and issues the request. */
    public CompletableFuture<Offer> acceptOfferComplete(String walletId, String offerId, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("PUT", "/wallets/" + walletId + "/offers/" + offerId + "/accept", java.util.Map.of(), null, Offer.class, userAction));
    }

    /** Delegated signing step 1 for Reject Offer: returns the challenge to sign out-of-band. */
    public CompletableFuture<UserActionChallenge> rejectOfferInit(String walletId, String offerId) {
        return httpClient.createUserActionChallengeAsync("PUT", "/wallets/" + walletId + "/offers/" + offerId + "/reject", null);
    }

    /** Delegated signing step 2 for Reject Offer: submits the signed challenge and issues the request. */
    public CompletableFuture<Offer> rejectOfferComplete(String walletId, String offerId, String challengeIdentifier, CredentialAssertion assertion) {
        return httpClient.completeUserActionSigningAsync(challengeIdentifier, assertion)
            .thenCompose(userAction -> httpClient.executeWithUserActionAsync("PUT", "/wallets/" + walletId + "/offers/" + offerId + "/reject", java.util.Map.of(), null, Offer.class, userAction));
    }

    /** List Org Wallet History */
    public CompletableFuture<Object> listOrgWalletHistory(ListOrgWalletHistoryQuery query) {
        return httpClient.getAsync("/wallets/all/history", query.toMap(), Object.class);
    }
}
