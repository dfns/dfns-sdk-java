package co.dfns.sdk;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.agreements.DelegatedAgreementsClient;
import co.dfns.sdk.allocations.DelegatedAllocationsClient;
import co.dfns.sdk.auth.DelegatedAuthClient;
import co.dfns.sdk.exchanges.DelegatedExchangesClient;
import co.dfns.sdk.feesponsors.DelegatedFeeSponsorsClient;
import co.dfns.sdk.keys.DelegatedKeysClient;
import co.dfns.sdk.networks.DelegatedNetworksClient;
import co.dfns.sdk.payins.DelegatedPayinsClient;
import co.dfns.sdk.payouts.DelegatedPayoutsClient;
import co.dfns.sdk.permissions.DelegatedPermissionsClient;
import co.dfns.sdk.policies.DelegatedPoliciesClient;
import co.dfns.sdk.signers.DelegatedSignersClient;
import co.dfns.sdk.staking.DelegatedStakingClient;
import co.dfns.sdk.swaps.DelegatedSwapsClient;
import co.dfns.sdk.vaults.DelegatedVaultsClient;
import co.dfns.sdk.wallets.DelegatedWalletsClient;
import co.dfns.sdk.webhooks.DelegatedWebhooksClient;

/**
 * Dfns SDK client for delegated user action signing. Its domain clients split signed
 * operations into Init/Complete calls so challenges can be signed out-of-band (e.g. by an
 * end user) rather than by a Signer held in this process.
 */
public class DfnsDelegatedClient implements AutoCloseable {
    private final DfnsHttpClient httpClient;
    public final DelegatedAgreementsClient agreements;
    public final DelegatedAllocationsClient allocations;
    public final DelegatedAuthClient auth;
    public final DelegatedExchangesClient exchanges;
    public final DelegatedFeeSponsorsClient feeSponsors;
    public final DelegatedKeysClient keys;
    public final DelegatedNetworksClient networks;
    public final DelegatedPayinsClient payins;
    public final DelegatedPayoutsClient payouts;
    public final DelegatedPermissionsClient permissions;
    public final DelegatedPoliciesClient policies;
    public final DelegatedSignersClient signers;
    public final DelegatedStakingClient staking;
    public final DelegatedSwapsClient swaps;
    public final DelegatedVaultsClient vaults;
    public final DelegatedWalletsClient wallets;
    public final DelegatedWebhooksClient webhooks;

    public DfnsDelegatedClient(DfnsClientConfig config) {
        this.httpClient = new DfnsHttpClient(config);
        this.agreements = new DelegatedAgreementsClient(httpClient);
        this.allocations = new DelegatedAllocationsClient(httpClient);
        this.auth = new DelegatedAuthClient(httpClient);
        this.exchanges = new DelegatedExchangesClient(httpClient);
        this.feeSponsors = new DelegatedFeeSponsorsClient(httpClient);
        this.keys = new DelegatedKeysClient(httpClient);
        this.networks = new DelegatedNetworksClient(httpClient);
        this.payins = new DelegatedPayinsClient(httpClient);
        this.payouts = new DelegatedPayoutsClient(httpClient);
        this.permissions = new DelegatedPermissionsClient(httpClient);
        this.policies = new DelegatedPoliciesClient(httpClient);
        this.signers = new DelegatedSignersClient(httpClient);
        this.staking = new DelegatedStakingClient(httpClient);
        this.swaps = new DelegatedSwapsClient(httpClient);
        this.vaults = new DelegatedVaultsClient(httpClient);
        this.wallets = new DelegatedWalletsClient(httpClient);
        this.webhooks = new DelegatedWebhooksClient(httpClient);
    }

    @Override
    public void close() {
        httpClient.close();
    }
}
