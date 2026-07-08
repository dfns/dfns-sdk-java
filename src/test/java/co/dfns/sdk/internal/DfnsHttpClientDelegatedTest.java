package co.dfns.sdk.internal;

import co.dfns.sdk.DfnsClientConfig;
import co.dfns.sdk.auth.CredentialAssertion;
import co.dfns.sdk.auth.UserActionChallenge;
import com.sun.net.httpserver.HttpServer;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Repo-owned tests for the delegated user-action-signing runtime on {@link DfnsHttpClient}:
 * createUserActionChallenge, completeUserActionSigning and executeWithUserAction (sync + async).
 * These back the generated Delegated*Client classes, letting a challenge be signed out-of-band
 * instead of by an in-process Signer. Uses the JDK's built-in HttpServer as a stub API, so there
 * are no external test dependencies.
 */
class DfnsHttpClientDelegatedTest {

    /** A stub API that records the last request body / user-action header per path. */
    private static final class StubServer implements AutoCloseable {
        final HttpServer server;
        final Map<String, String> lastBody = new ConcurrentHashMap<>();
        final Map<String, String> lastUserAction = new ConcurrentHashMap<>();

        StubServer(Map<String, String> responses) throws IOException {
            server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
            responses.forEach((path, body) -> server.createContext(path, exchange -> {
                byte[] req = exchange.getRequestBody().readAllBytes();
                lastBody.put(path, new String(req, StandardCharsets.UTF_8));
                String ua = exchange.getRequestHeaders().getFirst("X-DFNS-USERACTION");
                if (ua != null) {
                    lastUserAction.put(path, ua);
                }
                byte[] resp = body.getBytes(StandardCharsets.UTF_8);
                exchange.getResponseHeaders().add("Content-Type", "application/json");
                exchange.sendResponseHeaders(200, resp.length);
                exchange.getResponseBody().write(resp);
                exchange.close();
            }));
            server.start();
        }

        String baseUrl() {
            return "http://127.0.0.1:" + server.getAddress().getPort();
        }

        @Override
        public void close() {
            server.stop(0);
        }
    }

    private DfnsHttpClient clientFor(StubServer s) {
        // No Signer configured: the delegated flow signs challenges out-of-band.
        DfnsClientConfig config = DfnsClientConfig.builder()
            .baseUrl(s.baseUrl())
            .authToken("test-token")
            .build();
        return new DfnsHttpClient(config);
    }

    private static CredentialAssertion testAssertion() {
        return new CredentialAssertion("Key",
            new CredentialAssertion.CredentialAssertionData("cred-1", "Y2xpZW50", "c2ln"));
    }

    @Test
    void createUserActionChallengeReturnsChallengeAndEncodesPayload() throws Exception {
        try (StubServer s = new StubServer(Map.of(
                "/auth/action/init", "{\"challengeIdentifier\":\"ch-1\",\"challenge\":\"c2ln\"}"))) {
            DfnsHttpClient http = clientFor(s);

            UserActionChallenge challenge = http.createUserActionChallenge(
                "POST", "/wallets", Map.of("network", "Eth"));

            assertEquals("ch-1", challenge.challengeIdentifier());
            assertEquals("c2ln", challenge.challenge());

            // The init request carries the method, path and JSON-serialized body to be signed.
            String init = s.lastBody.get("/auth/action/init");
            assertTrue(init.contains("\"userActionHttpMethod\":\"POST\""), init);
            assertTrue(init.contains("\"userActionHttpPath\":\"/wallets\""), init);
            assertTrue(init.contains("\"userActionServerKind\":\"Api\""), init);
            assertTrue(init.contains("network"), init);
        }
    }

    @Test
    void completeUserActionSigningReturnsTokenAndSendsAssertion() throws Exception {
        try (StubServer s = new StubServer(Map.of(
                "/auth/action", "{\"userAction\":\"ua-token\"}"))) {
            DfnsHttpClient http = clientFor(s);

            String token = http.completeUserActionSigning("ch-1", testAssertion());

            assertEquals("ua-token", token);
            String body = s.lastBody.get("/auth/action");
            assertTrue(body.contains("\"challengeIdentifier\":\"ch-1\""), body);
            assertTrue(body.contains("firstFactor"), body);
        }
    }

    @Test
    void executeWithUserActionAttachesHeaderAndReturnsResponse() throws Exception {
        try (StubServer s = new StubServer(Map.of("/wallets", "{\"id\":\"wa-1\"}"))) {
            DfnsHttpClient http = clientFor(s);

            @SuppressWarnings("unchecked")
            Map<String, Object> result = http.executeWithUserAction(
                "POST", "/wallets", Map.of(), Map.of("network", "Eth"), Map.class, "ua-token");

            assertEquals("wa-1", result.get("id"));
            assertEquals("ua-token", s.lastUserAction.get("/wallets"));
        }
    }

    @Test
    void delegatedRoundTripSync() throws Exception {
        try (StubServer s = new StubServer(Map.of(
                "/auth/action/init", "{\"challengeIdentifier\":\"ch-1\",\"challenge\":\"c2ln\"}",
                "/auth/action", "{\"userAction\":\"ua-token\"}",
                "/wallets", "{\"id\":\"wa-1\"}"))) {
            DfnsHttpClient http = clientFor(s);

            UserActionChallenge ch = http.createUserActionChallenge("POST", "/wallets", Map.of());
            String token = http.completeUserActionSigning(ch.challengeIdentifier(), testAssertion());
            @SuppressWarnings("unchecked")
            Map<String, Object> result = http.executeWithUserAction(
                "POST", "/wallets", Map.of(), Map.of(), Map.class, token);

            assertEquals("wa-1", result.get("id"));
            assertEquals("ua-token", s.lastUserAction.get("/wallets"));
        }
    }

    @Test
    void delegatedRoundTripAsync() throws Exception {
        try (StubServer s = new StubServer(Map.of(
                "/auth/action/init", "{\"challengeIdentifier\":\"ch-1\",\"challenge\":\"c2ln\"}",
                "/auth/action", "{\"userAction\":\"ua-token\"}",
                "/wallets", "{\"id\":\"wa-1\"}"))) {
            DfnsHttpClient http = clientFor(s);

            UserActionChallenge ch = http.createUserActionChallengeAsync("POST", "/wallets", Map.of()).get();
            String token = http.completeUserActionSigningAsync(ch.challengeIdentifier(), testAssertion()).get();
            assertEquals("ua-token", token);

            @SuppressWarnings("unchecked")
            Map<String, Object> result = http.executeWithUserActionAsync(
                "POST", "/wallets", Map.of(), Map.of(), Map.class, token).get();

            assertEquals("wa-1", result.get("id"));
            assertEquals("ua-token", s.lastUserAction.get("/wallets"));
        }
    }
}
