package co.dfns.sdk;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.agreements.DelegatedAgreementsAsyncClient;
import co.dfns.sdk.allocations.DelegatedAllocationsAsyncClient;
import co.dfns.sdk.auth.DelegatedAuthAsyncClient;
import co.dfns.sdk.exchanges.DelegatedExchangesAsyncClient;
import co.dfns.sdk.feesponsors.DelegatedFeeSponsorsAsyncClient;
import co.dfns.sdk.keys.DelegatedKeysAsyncClient;
import co.dfns.sdk.networks.DelegatedNetworksAsyncClient;
import co.dfns.sdk.payouts.DelegatedPayoutsAsyncClient;
import co.dfns.sdk.permissions.DelegatedPermissionsAsyncClient;
import co.dfns.sdk.policies.DelegatedPoliciesAsyncClient;
import co.dfns.sdk.signers.DelegatedSignersAsyncClient;
import co.dfns.sdk.staking.DelegatedStakingAsyncClient;
import co.dfns.sdk.swaps.DelegatedSwapsAsyncClient;
import co.dfns.sdk.wallets.DelegatedWalletsAsyncClient;
import co.dfns.sdk.webhooks.DelegatedWebhooksAsyncClient;

/**
 * Dfns async SDK client for delegated user action signing. Its domain clients split signed
 * operations into Init/Complete calls so challenges can be signed out-of-band (e.g. by an
 * end user) rather than by a Signer held in this process.
 */
public class DfnsDelegatedAsyncClient implements AutoCloseable {
    private final DfnsHttpClient httpClient;
    public final DelegatedAgreementsAsyncClient agreements;
    public final DelegatedAllocationsAsyncClient allocations;
    public final DelegatedAuthAsyncClient auth;
    public final DelegatedExchangesAsyncClient exchanges;
    public final DelegatedFeeSponsorsAsyncClient feeSponsors;
    public final DelegatedKeysAsyncClient keys;
    public final DelegatedNetworksAsyncClient networks;
    public final DelegatedPayoutsAsyncClient payouts;
    public final DelegatedPermissionsAsyncClient permissions;
    public final DelegatedPoliciesAsyncClient policies;
    public final DelegatedSignersAsyncClient signers;
    public final DelegatedStakingAsyncClient staking;
    public final DelegatedSwapsAsyncClient swaps;
    public final DelegatedWalletsAsyncClient wallets;
    public final DelegatedWebhooksAsyncClient webhooks;

    public DfnsDelegatedAsyncClient(DfnsClientConfig config) {
        this.httpClient = new DfnsHttpClient(config);
        this.agreements = new DelegatedAgreementsAsyncClient(httpClient);
        this.allocations = new DelegatedAllocationsAsyncClient(httpClient);
        this.auth = new DelegatedAuthAsyncClient(httpClient);
        this.exchanges = new DelegatedExchangesAsyncClient(httpClient);
        this.feeSponsors = new DelegatedFeeSponsorsAsyncClient(httpClient);
        this.keys = new DelegatedKeysAsyncClient(httpClient);
        this.networks = new DelegatedNetworksAsyncClient(httpClient);
        this.payouts = new DelegatedPayoutsAsyncClient(httpClient);
        this.permissions = new DelegatedPermissionsAsyncClient(httpClient);
        this.policies = new DelegatedPoliciesAsyncClient(httpClient);
        this.signers = new DelegatedSignersAsyncClient(httpClient);
        this.staking = new DelegatedStakingAsyncClient(httpClient);
        this.swaps = new DelegatedSwapsAsyncClient(httpClient);
        this.wallets = new DelegatedWalletsAsyncClient(httpClient);
        this.webhooks = new DelegatedWebhooksAsyncClient(httpClient);
    }

    @Override
    public void close() {
        httpClient.close();
    }
}
