package co.dfns.sdk.wallets;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.wallets.model.*;
import java.util.Map;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.auth.CredentialAssertion;

public class DelegatedWalletsClient {
    private final DfnsHttpClient httpClient;

    public DelegatedWalletsClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Delegated signing step 1 for Abort Transaction: returns the challenge to sign out-of-band. */
    public UserActionChallenge abortTransactionInit(String walletId, String transactionId) {
        return httpClient.createUserActionChallenge("PUT", "/wallets/" + walletId + "/transactions/" + transactionId + "/abort", null);
    }

    /** Delegated signing step 2 for Abort Transaction: submits the signed challenge and issues the request. */
    public TransactionRequest abortTransactionComplete(String walletId, String transactionId, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/wallets/" + walletId + "/transactions/" + transactionId + "/abort", java.util.Map.of(), null, TransactionRequest.class, userAction);
    }

    /** Delegated signing step 1 for Abort Transfer: returns the challenge to sign out-of-band. */
    public UserActionChallenge abortTransferInit(String walletId, String transferId) {
        return httpClient.createUserActionChallenge("PUT", "/wallets/" + walletId + "/transfers/" + transferId + "/abort", null);
    }

    /** Delegated signing step 2 for Abort Transfer: submits the signed challenge and issues the request. */
    public TransferRequest abortTransferComplete(String walletId, String transferId, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/wallets/" + walletId + "/transfers/" + transferId + "/abort", java.util.Map.of(), null, TransferRequest.class, userAction);
    }

    /** Delegated signing step 1 for Activate Wallet: returns the challenge to sign out-of-band. */
    public UserActionChallenge activateWalletInit(String walletId, Object body) {
        return httpClient.createUserActionChallenge("POST", "/wallets/" + walletId + "/activate", body);
    }

    /** Delegated signing step 2 for Activate Wallet: submits the signed challenge and issues the request. */
    public TransactionRequest activateWalletComplete(String walletId, Object body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/wallets/" + walletId + "/activate", java.util.Map.of(), body, TransactionRequest.class, userAction);
    }

    /** List Transactions */
    public ListTransactionsResponse listTransactions(String walletId, ListTransactionsQuery query) {
        return httpClient.get("/wallets/" + walletId + "/transactions", query.toMap(), ListTransactionsResponse.class);
    }

    /** Delegated signing step 1 for Sign and Broadcast Transaction: returns the challenge to sign out-of-band. */
    public UserActionChallenge signAndBroadcastTransactionInit(String walletId, Object body) {
        return httpClient.createUserActionChallenge("POST", "/wallets/" + walletId + "/transactions", body);
    }

    /** Delegated signing step 2 for Sign and Broadcast Transaction: submits the signed challenge and issues the request. */
    public TransactionRequest signAndBroadcastTransactionComplete(String walletId, Object body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/wallets/" + walletId + "/transactions", java.util.Map.of(), body, TransactionRequest.class, userAction);
    }

    /** Delegated signing step 1 for Cancel Transaction: returns the challenge to sign out-of-band. */
    public UserActionChallenge cancelTransactionInit(String walletId, String transactionId) {
        return httpClient.createUserActionChallenge("POST", "/wallets/" + walletId + "/transactions/" + transactionId + "/cancel", null);
    }

    /** Delegated signing step 2 for Cancel Transaction: submits the signed challenge and issues the request. */
    public TransactionRequest cancelTransactionComplete(String walletId, String transactionId, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/wallets/" + walletId + "/transactions/" + transactionId + "/cancel", java.util.Map.of(), null, TransactionRequest.class, userAction);
    }

    /** Delegated signing step 1 for Cancel Transfer: returns the challenge to sign out-of-band. */
    public UserActionChallenge cancelTransferInit(String walletId, String transferId) {
        return httpClient.createUserActionChallenge("POST", "/wallets/" + walletId + "/transfers/" + transferId + "/cancel", null);
    }

    /** Delegated signing step 2 for Cancel Transfer: submits the signed challenge and issues the request. */
    public TransactionRequest cancelTransferComplete(String walletId, String transferId, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/wallets/" + walletId + "/transfers/" + transferId + "/cancel", java.util.Map.of(), null, TransactionRequest.class, userAction);
    }

    /** Proxy a request to the Canton Ledger API */
    @SuppressWarnings("unchecked")
    public Map<String, Object> proxyARequestToTheCantonLedgerApi(String walletId, ProxyARequestToTheCantonLedgerApiRequest body) {
        return httpClient.post("/wallets/" + walletId + "/canton/ledger-api", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, false);
    }

    /** Delegated signing step 1 for Speed Up Transaction: returns the challenge to sign out-of-band. */
    public UserActionChallenge speedUpTransactionInit(String walletId, String transactionId) {
        return httpClient.createUserActionChallenge("POST", "/wallets/" + walletId + "/transactions/" + transactionId + "/speed-up", null);
    }

    /** Delegated signing step 2 for Speed Up Transaction: submits the signed challenge and issues the request. */
    public TransactionRequest speedUpTransactionComplete(String walletId, String transactionId, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/wallets/" + walletId + "/transactions/" + transactionId + "/speed-up", java.util.Map.of(), null, TransactionRequest.class, userAction);
    }

    /** Delegated signing step 1 for Speed Up Transfer: returns the challenge to sign out-of-band. */
    public UserActionChallenge speedUpTransferInit(String walletId, String transferId) {
        return httpClient.createUserActionChallenge("POST", "/wallets/" + walletId + "/transfers/" + transferId + "/speed-up", null);
    }

    /** Delegated signing step 2 for Speed Up Transfer: submits the signed challenge and issues the request. */
    public TransactionRequest speedUpTransferComplete(String walletId, String transferId, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/wallets/" + walletId + "/transfers/" + transferId + "/speed-up", java.util.Map.of(), null, TransactionRequest.class, userAction);
    }

    /** List Wallets */
    public PaginatedList<Wallet> listWallets(ListWalletsQuery query) {
        return httpClient.get("/wallets", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Wallet>>() {});
    }

    /** Delegated signing step 1 for Create Wallet: returns the challenge to sign out-of-band. */
    public UserActionChallenge createWalletInit(CreateWalletRequest body) {
        return httpClient.createUserActionChallenge("POST", "/wallets", body);
    }

    /** Delegated signing step 2 for Create Wallet: submits the signed challenge and issues the request. */
    public Wallet createWalletComplete(CreateWalletRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/wallets", java.util.Map.of(), body, Wallet.class, userAction);
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

    /** Delegated signing step 1 for Update Wallet: returns the challenge to sign out-of-band. */
    public UserActionChallenge updateWalletInit(String walletId, UpdateWalletRequest body) {
        return httpClient.createUserActionChallenge("PUT", "/wallets/" + walletId, body);
    }

    /** Delegated signing step 2 for Update Wallet: submits the signed challenge and issues the request. */
    public Wallet updateWalletComplete(String walletId, UpdateWalletRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/wallets/" + walletId, java.util.Map.of(), body, Wallet.class, userAction);
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

    /** Delegated signing step 1 for Import Wallet: returns the challenge to sign out-of-band. */
    public UserActionChallenge importWalletInit(ImportWalletRequest body) {
        return httpClient.createUserActionChallenge("POST", "/wallets/import", body);
    }

    /** Delegated signing step 2 for Import Wallet: submits the signed challenge and issues the request. */
    public Wallet importWalletComplete(ImportWalletRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/wallets/import", java.util.Map.of(), body, Wallet.class, userAction);
    }

    /** List Transfers */
    public ListTransfersResponse listTransfers(String walletId, ListTransfersQuery query) {
        return httpClient.get("/wallets/" + walletId + "/transfers", query.toMap(), ListTransfersResponse.class);
    }

    /** Delegated signing step 1 for Transfer Asset: returns the challenge to sign out-of-band. */
    public UserActionChallenge transferAssetInit(String walletId, Object body) {
        return httpClient.createUserActionChallenge("POST", "/wallets/" + walletId + "/transfers", body);
    }

    /** Delegated signing step 2 for Transfer Asset: submits the signed challenge and issues the request. */
    public TransferRequest transferAssetComplete(String walletId, Object body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("POST", "/wallets/" + walletId + "/transfers", java.util.Map.of(), body, TransferRequest.class, userAction);
    }

    /** Delegated signing step 1 for Tag Wallet: returns the challenge to sign out-of-band. */
    public UserActionChallenge tagWalletInit(String walletId, TagWalletRequest body) {
        return httpClient.createUserActionChallenge("PUT", "/wallets/" + walletId + "/tags", body);
    }

    /** Delegated signing step 2 for Tag Wallet: submits the signed challenge and issues the request. */
    @SuppressWarnings("unchecked")
    public Map<String, Object> tagWalletComplete(String walletId, TagWalletRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/wallets/" + walletId + "/tags", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, userAction);
    }

    /** Delegated signing step 1 for Untag Wallet: returns the challenge to sign out-of-band. */
    public UserActionChallenge untagWalletInit(String walletId, UntagWalletRequest body) {
        return httpClient.createUserActionChallenge("DELETE", "/wallets/" + walletId + "/tags", body);
    }

    /** Delegated signing step 2 for Untag Wallet: submits the signed challenge and issues the request. */
    @SuppressWarnings("unchecked")
    public Map<String, Object> untagWalletComplete(String walletId, UntagWalletRequest body, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("DELETE", "/wallets/" + walletId + "/tags", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, userAction);
    }

    /** Get Offer */
    public Offer getOffer(String walletId, String offerId) {
        return httpClient.get("/wallets/" + walletId + "/offers/" + offerId, java.util.Map.of(), Offer.class);
    }

    /** List Offers */
    public PaginatedList<Offer> listOffers(String walletId, ListOffersQuery query) {
        return httpClient.get("/wallets/" + walletId + "/offers", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<Offer>>() {});
    }

    /** Delegated signing step 1 for Accept Offer: returns the challenge to sign out-of-band. */
    public UserActionChallenge acceptOfferInit(String walletId, String offerId) {
        return httpClient.createUserActionChallenge("PUT", "/wallets/" + walletId + "/offers/" + offerId + "/accept", null);
    }

    /** Delegated signing step 2 for Accept Offer: submits the signed challenge and issues the request. */
    public Offer acceptOfferComplete(String walletId, String offerId, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/wallets/" + walletId + "/offers/" + offerId + "/accept", java.util.Map.of(), null, Offer.class, userAction);
    }

    /** Delegated signing step 1 for Reject Offer: returns the challenge to sign out-of-band. */
    public UserActionChallenge rejectOfferInit(String walletId, String offerId) {
        return httpClient.createUserActionChallenge("PUT", "/wallets/" + walletId + "/offers/" + offerId + "/reject", null);
    }

    /** Delegated signing step 2 for Reject Offer: submits the signed challenge and issues the request. */
    public Offer rejectOfferComplete(String walletId, String offerId, String challengeIdentifier, CredentialAssertion assertion) {
        String userAction = httpClient.completeUserActionSigning(challengeIdentifier, assertion);
        return httpClient.executeWithUserAction("PUT", "/wallets/" + walletId + "/offers/" + offerId + "/reject", java.util.Map.of(), null, Offer.class, userAction);
    }

    /** List Org Wallet History */
    public Object listOrgWalletHistory(ListOrgWalletHistoryQuery query) {
        return httpClient.get("/wallets/all/history", query.toMap(), Object.class);
    }
}
