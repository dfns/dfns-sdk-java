package co.dfns.sdk;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.agreements.AgreementsAsyncClient;
import co.dfns.sdk.allocations.AllocationsAsyncClient;
import co.dfns.sdk.auth.AuthAsyncClient;
import co.dfns.sdk.exchanges.ExchangesAsyncClient;
import co.dfns.sdk.feesponsors.FeeSponsorsAsyncClient;
import co.dfns.sdk.keys.KeysAsyncClient;
import co.dfns.sdk.networks.NetworksAsyncClient;
import co.dfns.sdk.payins.PayinsAsyncClient;
import co.dfns.sdk.payouts.PayoutsAsyncClient;
import co.dfns.sdk.permissions.PermissionsAsyncClient;
import co.dfns.sdk.policies.PoliciesAsyncClient;
import co.dfns.sdk.signers.SignersAsyncClient;
import co.dfns.sdk.staking.StakingAsyncClient;
import co.dfns.sdk.swaps.SwapsAsyncClient;
import co.dfns.sdk.vaults.VaultsAsyncClient;
import co.dfns.sdk.wallets.WalletsAsyncClient;
import co.dfns.sdk.webhooks.WebhooksAsyncClient;

/** Dfns async SDK client. Provides access to all Dfns API domains. */
public class DfnsAsyncClient implements AutoCloseable {
    private final DfnsHttpClient httpClient;
    public final AgreementsAsyncClient agreements;
    public final AllocationsAsyncClient allocations;
    public final AuthAsyncClient auth;
    public final ExchangesAsyncClient exchanges;
    public final FeeSponsorsAsyncClient feeSponsors;
    public final KeysAsyncClient keys;
    public final NetworksAsyncClient networks;
    public final PayinsAsyncClient payins;
    public final PayoutsAsyncClient payouts;
    public final PermissionsAsyncClient permissions;
    public final PoliciesAsyncClient policies;
    public final SignersAsyncClient signers;
    public final StakingAsyncClient staking;
    public final SwapsAsyncClient swaps;
    public final VaultsAsyncClient vaults;
    public final WalletsAsyncClient wallets;
    public final WebhooksAsyncClient webhooks;

    public DfnsAsyncClient(DfnsClientConfig config) {
        this.httpClient = new DfnsHttpClient(config);
        this.agreements = new AgreementsAsyncClient(httpClient);
        this.allocations = new AllocationsAsyncClient(httpClient);
        this.auth = new AuthAsyncClient(httpClient);
        this.exchanges = new ExchangesAsyncClient(httpClient);
        this.feeSponsors = new FeeSponsorsAsyncClient(httpClient);
        this.keys = new KeysAsyncClient(httpClient);
        this.networks = new NetworksAsyncClient(httpClient);
        this.payins = new PayinsAsyncClient(httpClient);
        this.payouts = new PayoutsAsyncClient(httpClient);
        this.permissions = new PermissionsAsyncClient(httpClient);
        this.policies = new PoliciesAsyncClient(httpClient);
        this.signers = new SignersAsyncClient(httpClient);
        this.staking = new StakingAsyncClient(httpClient);
        this.swaps = new SwapsAsyncClient(httpClient);
        this.vaults = new VaultsAsyncClient(httpClient);
        this.wallets = new WalletsAsyncClient(httpClient);
        this.webhooks = new WebhooksAsyncClient(httpClient);
    }

    @Override
    public void close() {
        httpClient.close();
    }
}
