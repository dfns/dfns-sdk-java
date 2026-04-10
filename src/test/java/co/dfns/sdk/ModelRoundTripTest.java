package co.dfns.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import co.dfns.sdk.internal.JsonMapper;
import co.dfns.sdk.wallets.model.Network;
import co.dfns.sdk.wallets.model.Offer;
import co.dfns.sdk.wallets.model.TransactionRequest;
import co.dfns.sdk.wallets.model.TransferRequest;
import co.dfns.sdk.wallets.model.Wallet;
import co.dfns.sdk.keys.model.Key;
import co.dfns.sdk.keys.model.KeyCurve;
import co.dfns.sdk.keys.model.KeyScheme;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JSON round-trip tests: deserialize JSON, assert fields, re-serialize,
 * deserialize again, and verify equality via record value semantics.
 */
class ModelRoundTripTest {

    private final ObjectMapper mapper = JsonMapper.getInstance();

    @Test
    void walletRoundTrip() throws Exception {
        String json = "{\"id\":\"wa-xxx\",\"network\":\"Ethereum\",\"status\":\"Active\","
            + "\"dateCreated\":\"2024-01-01T00:00:00Z\",\"custodial\":true,\"tags\":[\"hot\"],"
            + "\"signingKey\":{\"scheme\":\"ECDSA\"}}";

        var wallet = mapper.readValue(json, Wallet.class);
        assertEquals("wa-xxx", wallet.id());
        assertEquals(Network.Ethereum, wallet.network());
        assertEquals("Active", wallet.status());
        assertTrue(wallet.custodial());
        assertEquals(1, wallet.tags().size());
        assertEquals("hot", wallet.tags().get(0));

        String json2 = mapper.writeValueAsString(wallet);
        var wallet2 = mapper.readValue(json2, Wallet.class);
        assertEquals(wallet, wallet2);
    }

    @Test
    void transactionRequestRoundTrip() throws Exception {
        String json = "{\"id\":\"tx-xxx\",\"walletId\":\"wa-xxx\",\"network\":\"Ethereum\","
            + "\"requester\":{\"userId\":\"us-xxx\"},\"requestBody\":{},\"status\":\"Pending\","
            + "\"dateRequested\":\"2024-01-01T00:00:00Z\"}";

        var tx = mapper.readValue(json, TransactionRequest.class);
        assertEquals("tx-xxx", tx.id());
        assertEquals("wa-xxx", tx.walletId());
        assertEquals(Network.Ethereum, tx.network());
        assertEquals("Pending", tx.status());

        String json2 = mapper.writeValueAsString(tx);
        var tx2 = mapper.readValue(json2, TransactionRequest.class);
        assertEquals(tx, tx2);
    }

    @Test
    void transferRequestRoundTrip() throws Exception {
        String json = "{\"id\":\"tr-xxx\",\"walletId\":\"wa-xxx\",\"network\":\"Ethereum\","
            + "\"requester\":{\"userId\":\"us-xxx\"},\"requestBody\":{},\"metadata\":{},"
            + "\"status\":\"Pending\",\"dateRequested\":\"2024-01-01T00:00:00Z\"}";

        var tr = mapper.readValue(json, TransferRequest.class);
        assertEquals("tr-xxx", tr.id());
        assertEquals("wa-xxx", tr.walletId());
        assertEquals(Network.Ethereum, tr.network());
        assertEquals("Pending", tr.status());

        String json2 = mapper.writeValueAsString(tr);
        var tr2 = mapper.readValue(json2, TransferRequest.class);
        assertEquals(tr, tr2);
    }

    @Test
    void networkEnumDeserializes() throws Exception {
        var eth = mapper.readValue("\"Ethereum\"", Network.class);
        assertEquals(Network.Ethereum, eth);

        var unknown = mapper.readValue("\"UnknownChain\"", Network.class);
        assertEquals(Network.UNKNOWN, unknown);
    }

    @Test
    void keyRoundTrip() throws Exception {
        String json = "{\"id\":\"key-xxx\",\"scheme\":\"ECDSA\",\"curve\":\"secp256k1\","
            + "\"publicKey\":\"0xabc\",\"status\":\"Active\","
            + "\"dateCreated\":\"2024-01-01T00:00:00Z\","
            + "\"custodial\":true,\"masterKey\":false,\"imported\":false,\"exported\":false}";

        var key = mapper.readValue(json, Key.class);
        assertEquals("key-xxx", key.id());
        assertEquals(KeyScheme.ECDSA, key.scheme());
        assertEquals(KeyCurve.secp256k1, key.curve());
        assertEquals("0xabc", key.publicKey());
        assertEquals("Active", key.status());
        assertTrue(key.custodial());
        assertFalse(key.masterKey());

        String json2 = mapper.writeValueAsString(key);
        var key2 = mapper.readValue(json2, Key.class);
        assertEquals(key, key2);
    }

    @Test
    void offerRoundTrip() throws Exception {
        String json = "{\"id\":\"of-xxx\",\"orgId\":\"org-xxx\",\"walletId\":\"wa-xxx\","
            + "\"network\":\"Ethereum\",\"kind\":\"Swap\",\"metadata\":{},"
            + "\"txHash\":\"0xabc\",\"status\":\"Pending\","
            + "\"from\":\"0x1\",\"to\":\"0x2\",\"value\":\"100\","
            + "\"timestamp\":\"2024-01-01T00:00:00Z\"}";

        var offer = mapper.readValue(json, Offer.class);
        assertEquals("of-xxx", offer.id());
        assertEquals("Pending", offer.status());
        assertEquals("org-xxx", offer.orgId());

        String json2 = mapper.writeValueAsString(offer);
        var offer2 = mapper.readValue(json2, Offer.class);
        assertEquals(offer, offer2);
    }

    @Test
    void paginatedListWalletRoundTrip() throws Exception {
        String json = "{\"items\":[{\"id\":\"wa-xxx\",\"network\":\"Ethereum\","
            + "\"status\":\"Active\",\"dateCreated\":\"2024-01-01T00:00:00Z\","
            + "\"custodial\":true,\"tags\":[],\"signingKey\":{\"scheme\":\"ECDSA\"}}],"
            + "\"nextPageToken\":\"abc123\"}";

        var list = mapper.readValue(json, new TypeReference<PaginatedList<Wallet>>() {});
        assertEquals(1, list.items().size());
        assertEquals("wa-xxx", list.items().get(0).id());
        assertEquals("abc123", list.nextPageToken());

        String json2 = mapper.writeValueAsString(list);
        var list2 = mapper.readValue(json2, new TypeReference<PaginatedList<Wallet>>() {});
        assertEquals(list, list2);
    }

    @Test
    void walletNullOptionalFieldsRoundTrip() throws Exception {
        String json = "{\"id\":\"wa-xxx\",\"network\":\"Ethereum\",\"status\":\"Active\","
            + "\"dateCreated\":\"2024-01-01T00:00:00Z\",\"custodial\":true,\"tags\":[],"
            + "\"signingKey\":{\"scheme\":\"ECDSA\"}}";

        var wallet = mapper.readValue(json, Wallet.class);
        assertEquals("wa-xxx", wallet.id());
        assertNull(wallet.address());
        assertNull(wallet.name());
        assertNull(wallet.externalId());
        assertNull(wallet.dateDeleted());
        assertNull(wallet.validatorId());

        String json2 = mapper.writeValueAsString(wallet);
        var wallet2 = mapper.readValue(json2, Wallet.class);
        assertEquals(wallet, wallet2);
    }

    @Test
    void networkEnumRoundTrip() throws Exception {
        Network eth = Network.Ethereum;
        String json = mapper.writeValueAsString(eth);
        assertEquals("\"Ethereum\"", json);

        Network deserialized = mapper.readValue(json, Network.class);
        assertEquals(eth, deserialized);
    }
}
