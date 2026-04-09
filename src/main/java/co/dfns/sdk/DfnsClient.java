package co.dfns.sdk;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.agreements.AgreementsClient;
import co.dfns.sdk.allocations.AllocationsClient;
import co.dfns.sdk.auth.AuthClient;
import co.dfns.sdk.exchanges.ExchangesClient;
import co.dfns.sdk.feesponsors.FeeSponsorsClient;
import co.dfns.sdk.keys.KeysClient;
import co.dfns.sdk.networks.NetworksClient;
import co.dfns.sdk.payouts.PayoutsClient;
import co.dfns.sdk.permissions.PermissionsClient;
import co.dfns.sdk.policies.PoliciesClient;
import co.dfns.sdk.signers.SignersClient;
import co.dfns.sdk.staking.StakingClient;
import co.dfns.sdk.swaps.SwapsClient;
import co.dfns.sdk.wallets.WalletsClient;
import co.dfns.sdk.webhooks.WebhooksClient;

/** Dfns SDK client. Provides access to all Dfns API domains. */
public class DfnsClient implements AutoCloseable {
    private final DfnsHttpClient httpClient;
    public final AgreementsClient agreements;
    public final AllocationsClient allocations;
    public final AuthClient auth;
    public final ExchangesClient exchanges;
    public final FeeSponsorsClient feeSponsors;
    public final KeysClient keys;
    public final NetworksClient networks;
    public final PayoutsClient payouts;
    public final PermissionsClient permissions;
    public final PoliciesClient policies;
    public final SignersClient signers;
    public final StakingClient staking;
    public final SwapsClient swaps;
    public final WalletsClient wallets;
    public final WebhooksClient webhooks;

    public DfnsClient(DfnsClientConfig config) {
        this.httpClient = new DfnsHttpClient(config);
        this.agreements = new AgreementsClient(httpClient);
        this.allocations = new AllocationsClient(httpClient);
        this.auth = new AuthClient(httpClient);
        this.exchanges = new ExchangesClient(httpClient);
        this.feeSponsors = new FeeSponsorsClient(httpClient);
        this.keys = new KeysClient(httpClient);
        this.networks = new NetworksClient(httpClient);
        this.payouts = new PayoutsClient(httpClient);
        this.permissions = new PermissionsClient(httpClient);
        this.policies = new PoliciesClient(httpClient);
        this.signers = new SignersClient(httpClient);
        this.staking = new StakingClient(httpClient);
        this.swaps = new SwapsClient(httpClient);
        this.wallets = new WalletsClient(httpClient);
        this.webhooks = new WebhooksClient(httpClient);
    }

    @Override
    public void close() {
        httpClient.close();
    }
}
