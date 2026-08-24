# Dfns Java SDK

Welcome, builders. This repo holds the Dfns Java SDK. Useful links:

- [Dfns Website](https://www.dfns.co)
- [Dfns API Docs](https://docs.dfns.co)

## Installation

Requires **Java 17+**. The SDK is built with Gradle and will be published to Maven Central
under group `co.dfns`, artifact `dfns-sdk-java`:

**Gradle**

```groovy
implementation("co.dfns:dfns-sdk-java:$version")
```

**Maven**

```xml
<dependency>
  <groupId>co.dfns</groupId>
  <artifactId>dfns-sdk-java</artifactId>
  <version>${version}</version>
</dependency>
```

> Maven Central publishing is being finalized; until it lands, build the SDK from source.

## Quick Start

```java
import co.dfns.sdk.DfnsClient;
import co.dfns.sdk.DfnsClientConfig;

// Create the client (read-only operations)
DfnsClientConfig config = DfnsClientConfig.builder()
    .authToken("your-auth-token")
    // .baseUrl("https://api.dfns.io") // Optional, this is the default
    .build();

DfnsClient client = new DfnsClient(config);

// List wallets
var wallets = client.wallets.listWallets(null);
System.out.println(wallets);
```

An async client with the same API but `CompletableFuture` return types is also available:

```java
import co.dfns.sdk.DfnsAsyncClient;

DfnsAsyncClient asyncClient = new DfnsAsyncClient(config);
```

## User Action Signing

Some operations (like creating wallets or signing transactions) require user action signing.
Configure a signer to enable these operations:

```java
import co.dfns.sdk.DfnsClient;
import co.dfns.sdk.DfnsClientConfig;
import co.dfns.sdk.auth.KeySigner;
import co.dfns.sdk.auth.Signer;
import co.dfns.sdk.wallets.model.CreateWalletRequest;
import co.dfns.sdk.wallets.model.Network;

// Create a signer from your credential ID and private key bytes
Signer signer = KeySigner.fromEd25519PrivateKey("cr-xxx-xxx", privateKeyBytes);

DfnsClientConfig config = DfnsClientConfig.builder()
    .authToken("your-auth-token")
    .signer(signer)
    .build();

DfnsClient client = new DfnsClient(config);

// Operations requiring signatures are signed automatically
var wallet = client.wallets.createWallet(new CreateWalletRequest(Network.EthereumSepolia));
System.out.println(wallet);
```

## Delegated Signing

In some setups you want your **server** to talk to Dfns on behalf of a user, while the user
keeps signing every request themselves (e.g. with a WebAuthn credential in a web app). The
`DfnsDelegatedClient` supports this: it needs **no `Signer`**, and every operation that needs
a user action signature is split into an `...Init` / `...Complete` pair.

- `...Init` takes the request payload and returns a `UserActionChallenge` to be signed
  out-of-band (typically by the end user in the browser).
- `...Complete` takes the same payload, the challenge identifier, and the signed
  `CredentialAssertion`, and performs the request.

A typical flow: the server calls `...Init` and sends the challenge to the user; the user
signs it with their credential and returns the assertion; the server calls `...Complete`.

```java
import co.dfns.sdk.DfnsClientConfig;
import co.dfns.sdk.DfnsDelegatedClient;
import co.dfns.sdk.auth.CredentialAssertion;
import co.dfns.sdk.auth.UserActionChallenge;
import co.dfns.sdk.wallets.model.CreateWalletRequest;
import co.dfns.sdk.wallets.model.Network;

// No signer needed — challenges are signed out-of-band (e.g. by the end user).
DfnsClientConfig config = DfnsClientConfig.builder()
    .authToken("user-auth-token")
    .build();

DfnsDelegatedClient client = new DfnsDelegatedClient(config);

CreateWalletRequest body = new CreateWalletRequest(Network.EthereumSepolia);

// Step 1 (server): start the action, get a challenge.
UserActionChallenge challenge = client.wallets.createWalletInit(body);

// Step 2 (client): the user signs `challenge` with their credential and returns the
// signed assertion (a CredentialAssertion) to the server.
CredentialAssertion assertion = signChallengeOutOfBand(challenge);

// Step 3 (server): complete the action with the signed challenge.
var wallet = client.wallets.createWalletComplete(body, challenge.challengeIdentifier(), assertion);
```

A `DfnsDelegatedAsyncClient` with `CompletableFuture` return types is also available.

## Available Domains

- `client.addressWatches` — AddressWatchesClient
- `client.agreements` — AgreementsClient
- `client.allocations` — AllocationsClient
- `client.auth` — AuthClient
- `client.exchanges` — ExchangesClient
- `client.feeSponsors` — FeeSponsorsClient
- `client.keys` — KeysClient
- `client.networks` — NetworksClient
- `client.payins` — PayinsClient
- `client.payouts` — PayoutsClient
- `client.permissions` — PermissionsClient
- `client.policies` — PoliciesClient
- `client.signers` — SignersClient
- `client.staking` — StakingClient
- `client.swaps` — SwapsClient
- `client.vaults` — VaultsClient
- `client.wallets` — WalletsClient
- `client.webhooks` — WebhooksClient

Each domain provides typed methods for all available API endpoints. The same domains are
exposed (as `Delegated*Client`) on `DfnsDelegatedClient`.

## Error Handling

```java
import co.dfns.sdk.DfnsException;

try {
    var result = client.wallets.listWallets(null);
} catch (DfnsException e) {
    System.err.println("HTTP status: " + e.getHttpStatus());
    System.err.println("Dfns error code: " + e.getDfnsErrorCode());
    System.err.println("Message: " + e.getErrorMessage());
}
```

## Supported Key Types

The `KeySigner` supports the following private key types, each via a factory method that
takes the credential ID and the private key bytes:

| Factory method | Key type |
|---|---|
| `KeySigner.fromEd25519PrivateKey` | Ed25519 (EdDSA) |
| `KeySigner.fromEcdsaP256PrivateKey` | ECDSA (P-256) |
| `KeySigner.fromSecp256k1PrivateKey` | ECDSA (secp256k1) |
| `KeySigner.fromRsaPrivateKey` | RSA (PKCS#1 v1.5, SHA-256) |

## License

MIT License - See LICENSE file for details.
