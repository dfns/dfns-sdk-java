package co.dfns.sdk.internal;

import co.dfns.sdk.DfnsClientConfig;
import co.dfns.sdk.DfnsException;
import com.sun.net.httpserver.HttpServer;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Repo-owned tests for the core DfnsHttpClient request path — GET/POST (client call) and
 * multipart upload — independent of user-action signing. Uses the JDK's built-in HttpServer
 * as a stub API, so there are no external test dependencies.
 */
class DfnsHttpClientCoreTest {

    /** A stub API that records the last request (body, content-type) per path and replies. */
    private static final class StubServer implements AutoCloseable {
        final HttpServer server;
        final Map<String, String> lastBody = new ConcurrentHashMap<>();
        final Map<String, String> lastContentType = new ConcurrentHashMap<>();
        private final int status;

        StubServer(int status, Map<String, String> responses) throws IOException {
            this.status = status;
            server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
            responses.forEach((path, body) -> server.createContext(path, exchange -> {
                byte[] req = exchange.getRequestBody().readAllBytes();
                lastBody.put(path, new String(req, StandardCharsets.UTF_8));
                String ct = exchange.getRequestHeaders().getFirst("Content-Type");
                if (ct != null) {
                    lastContentType.put(path, ct);
                }
                byte[] resp = body.getBytes(StandardCharsets.UTF_8);
                exchange.getResponseHeaders().add("Content-Type", "application/json");
                exchange.sendResponseHeaders(this.status, resp.length);
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
        DfnsClientConfig config = DfnsClientConfig.builder()
            .baseUrl(s.baseUrl())
            .authToken("test-token")
            .build();
        return new DfnsHttpClient(config);
    }

    @Test
    void getDeserializesResponse() throws Exception {
        try (StubServer s = new StubServer(200, Map.of("/wallets/wa-1", "{\"id\":\"wa-1\"}"))) {
            @SuppressWarnings("unchecked")
            Map<String, Object> result = clientFor(s).get("/wallets/wa-1", Map.of(), Map.class);
            assertEquals("wa-1", result.get("id"));
        }
    }

    @Test
    void postSendsBodyAndDeserializesResponse() throws Exception {
        try (StubServer s = new StubServer(200, Map.of("/wallets", "{\"id\":\"wa-1\"}"))) {
            @SuppressWarnings("unchecked")
            Map<String, Object> result = clientFor(s).post(
                "/wallets", Map.of(), Map.of("network", "Eth"), Map.class, false);

            assertEquals("wa-1", result.get("id"));
            String body = s.lastBody.get("/wallets");
            assertTrue(body.contains("\"network\":\"Eth\""), body);
        }
    }

    @Test
    void apiErrorRaisesDfnsException() throws Exception {
        try (StubServer s = new StubServer(400, Map.of("/wallets", "{\"error\":{\"message\":\"bad\"}}"))) {
            DfnsHttpClient http = clientFor(s);
            assertThrows(DfnsException.class,
                () -> http.post("/wallets", Map.of(), Map.of(), Map.class, false));
        }
    }

    @Test
    void postMultipartPacksDataAndFileParts() throws Exception {
        try (StubServer s = new StubServer(200, Map.of("/documents", "{\"id\":\"doc-1\"}"))) {
            byte[] file = "hello-file-contents".getBytes(StandardCharsets.UTF_8);

            @SuppressWarnings("unchecked")
            Map<String, Object> result = clientFor(s).postMultipart(
                "/documents", Map.of(), Map.of("kind", "kyc"), file, Map.class, false);

            assertEquals("doc-1", result.get("id"));

            // The request is multipart/form-data carrying the JSON "data" part (with the
            // injected fileChecksum) and the raw file bytes as the "file" part.
            assertTrue(s.lastContentType.get("/documents").startsWith("multipart/form-data"),
                s.lastContentType.get("/documents"));
            String body = s.lastBody.get("/documents");
            assertTrue(body.contains("name=\"data\""), body);
            assertTrue(body.contains("name=\"file\""), body);
            assertTrue(body.contains("fileChecksum"), body);
            assertTrue(body.contains("hello-file-contents"), body);
            assertNotNull(body);
        }
    }
}
