# Dfns Java SDK

Java 17 SDK for the Dfns API.

## Quick Start

```java
import co.dfns.sdk.*;
import co.dfns.sdk.auth.*;

// Create a signer with your credential ID and private key
Signer signer = KeySigner.fromEd25519PrivateKey("cr-xxx-xxx", privateKeyBytes);

DfnsClientConfig config = DfnsClientConfig.builder()
    .authToken("your-auth-token")
    .signer(signer)
    .build();

DfnsClient client = new DfnsClient(config);
DfnsAsyncClient asyncClient = new DfnsAsyncClient(config);
```

## Available Domains

- `client.agreements` — AgreementsClient
- `client.allocations` — AllocationsClient
- `client.auth` — AuthClient
- `client.exchanges` — ExchangesClient
- `client.feeSponsors` — FeeSponsorsClient
- `client.keys` — KeysClient
- `client.networks` — NetworksClient
- `client.payouts` — PayoutsClient
- `client.permissions` — PermissionsClient
- `client.policies` — PoliciesClient
- `client.signers` — SignersClient
- `client.staking` — StakingClient
- `client.swaps` — SwapsClient
- `client.wallets` — WalletsClient
- `client.webhooks` — WebhooksClient

## Error Handling

```java
try {
    var result = client.wallets.listWallets();
} catch (DfnsException e) {
    System.err.println("HTTP status: " + e.getHttpStatus());
}
```
