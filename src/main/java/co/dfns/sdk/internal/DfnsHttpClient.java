package co.dfns.sdk.internal;

import co.dfns.sdk.DfnsClientConfig;
import co.dfns.sdk.DfnsException;
import co.dfns.sdk.auth.UserActionChallenge;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/** Internal HTTP client — not part of the public API. */
public class DfnsHttpClient implements AutoCloseable {
    private static final String DFNS_AUTH_TOKEN_HEADER  = "Authorization";
    private static final String DFNS_USER_ACTION_HEADER = "X-DFNS-USERACTION";

    private final DfnsClientConfig config;
    private final HttpClient       http;
    private final ObjectMapper     mapper;

    public DfnsHttpClient(DfnsClientConfig config) {
        this.config = config;
        this.http   = HttpClient.newHttpClient();
        this.mapper = JsonMapper.getInstance();
    }

    public <T> T get(String path, Map<String, String> query, Class<T> responseType) {
        return execute(buildRequest("GET", path, query, null, null), responseType);
    }

    public <T> T post(String path, Object body, Class<T> responseType, boolean requiresUserAction) {
        return post(path, Map.of(), body, responseType, requiresUserAction);
    }

    public <T> T post(String path, Map<String, String> query, Object body, Class<T> responseType, boolean requiresUserAction) {
        return executeWithOptionalUserAction("POST", path, query, body, responseType, requiresUserAction);
    }

    public <T> T put(String path, Object body, Class<T> responseType, boolean requiresUserAction) {
        return put(path, Map.of(), body, responseType, requiresUserAction);
    }

    public <T> T put(String path, Map<String, String> query, Object body, Class<T> responseType, boolean requiresUserAction) {
        return executeWithOptionalUserAction("PUT", path, query, body, responseType, requiresUserAction);
    }

    public <T> T delete(String path, Object body, Class<T> responseType, boolean requiresUserAction) {
        return delete(path, Map.of(), body, responseType, requiresUserAction);
    }

    public <T> T delete(String path, Map<String, String> query, Object body, Class<T> responseType, boolean requiresUserAction) {
        return executeWithOptionalUserAction("DELETE", path, query, body, responseType, requiresUserAction);
    }

    public <T> T patch(String path, Object body, Class<T> responseType, boolean requiresUserAction) {
        return patch(path, Map.of(), body, responseType, requiresUserAction);
    }

    public <T> T patch(String path, Map<String, String> query, Object body, Class<T> responseType, boolean requiresUserAction) {
        return executeWithOptionalUserAction("PATCH", path, query, body, responseType, requiresUserAction);
    }

    public <T> CompletableFuture<T> getAsync(String path, Map<String, String> query, Class<T> responseType) {
        HttpRequest request = buildRequest("GET", path, query, null, null);
        return executeAsync(request, responseType);
    }

    // TypeReference-based overloads for generic response types (e.g. PaginatedList<Wallet>)

    public <T> T get(String path, Map<String, String> query, TypeReference<T> responseType) {
        return executeWithTypeRef(buildRequest("GET", path, query, null, null), responseType);
    }

    public <T> T post(String path, Map<String, String> query, Object body, TypeReference<T> responseType, boolean requiresUserAction) {
        return executeWithOptionalUserActionTypeRef("POST", path, query, body, responseType, requiresUserAction);
    }

    public <T> T put(String path, Map<String, String> query, Object body, TypeReference<T> responseType, boolean requiresUserAction) {
        return executeWithOptionalUserActionTypeRef("PUT", path, query, body, responseType, requiresUserAction);
    }

    public <T> T delete(String path, Map<String, String> query, Object body, TypeReference<T> responseType, boolean requiresUserAction) {
        return executeWithOptionalUserActionTypeRef("DELETE", path, query, body, responseType, requiresUserAction);
    }

    public <T> T patch(String path, Map<String, String> query, Object body, TypeReference<T> responseType, boolean requiresUserAction) {
        return executeWithOptionalUserActionTypeRef("PATCH", path, query, body, responseType, requiresUserAction);
    }

    public <T> CompletableFuture<T> getAsync(String path, Map<String, String> query, TypeReference<T> responseType) {
        HttpRequest request = buildRequest("GET", path, query, null, null);
        return executeAsyncWithTypeRef(request, responseType);
    }

    public <T> CompletableFuture<T> postAsync(String path, Map<String, String> query, Object body, TypeReference<T> responseType, boolean requiresUserAction) {
        return executeWithOptionalUserActionAsyncTypeRef("POST", path, query, body, responseType, requiresUserAction);
    }

    public <T> CompletableFuture<T> putAsync(String path, Map<String, String> query, Object body, TypeReference<T> responseType, boolean requiresUserAction) {
        return executeWithOptionalUserActionAsyncTypeRef("PUT", path, query, body, responseType, requiresUserAction);
    }

    public <T> CompletableFuture<T> deleteAsync(String path, Map<String, String> query, Object body, TypeReference<T> responseType, boolean requiresUserAction) {
        return executeWithOptionalUserActionAsyncTypeRef("DELETE", path, query, body, responseType, requiresUserAction);
    }

    public <T> CompletableFuture<T> patchAsync(String path, Map<String, String> query, Object body, TypeReference<T> responseType, boolean requiresUserAction) {
        return executeWithOptionalUserActionAsyncTypeRef("PATCH", path, query, body, responseType, requiresUserAction);
    }

    public <T> CompletableFuture<T> postAsync(String path, Map<String, String> query, Object body, Class<T> responseType, boolean requiresUserAction) {
        return executeWithOptionalUserActionAsync("POST", path, query, body, responseType, requiresUserAction);
    }

    public <T> CompletableFuture<T> putAsync(String path, Map<String, String> query, Object body, Class<T> responseType, boolean requiresUserAction) {
        return executeWithOptionalUserActionAsync("PUT", path, query, body, responseType, requiresUserAction);
    }

    public <T> CompletableFuture<T> deleteAsync(String path, Map<String, String> query, Object body, Class<T> responseType, boolean requiresUserAction) {
        return executeWithOptionalUserActionAsync("DELETE", path, query, body, responseType, requiresUserAction);
    }

    public <T> CompletableFuture<T> patchAsync(String path, Map<String, String> query, Object body, Class<T> responseType, boolean requiresUserAction) {
        return executeWithOptionalUserActionAsync("PATCH", path, query, body, responseType, requiresUserAction);
    }

    private <T> T executeWithOptionalUserAction(
            String method, String path, Map<String, String> query, Object body, Class<T> responseType, boolean requiresUserAction) {
        if (!requiresUserAction || config.getSigner() == null) {
            return execute(buildRequest(method, path, query, body, null), responseType);
        }
        String userAction = obtainUserActionToken(method, path, body);
        return execute(buildRequest(method, path, query, body, userAction), responseType);
    }

    private <T> CompletableFuture<T> executeWithOptionalUserActionAsync(
            String method, String path, Map<String, String> query, Object body, Class<T> responseType, boolean requiresUserAction) {
        if (!requiresUserAction || config.getSigner() == null) {
            return executeAsync(buildRequest(method, path, query, body, null), responseType);
        }
        return obtainUserActionTokenAsync(method, path, body)
            .thenCompose(userAction -> executeAsync(buildRequest(method, path, query, body, userAction), responseType));
    }

    private String obtainUserActionToken(String method, String path, Object body) {
        try {
            String bodyJson   = body != null ? mapper.writeValueAsString(body) : "{}";
            String initBody   = mapper.writeValueAsString(Map.of(
                "userActionHttpMethod", method,
                "userActionHttpPath",   path,
                "userActionPayload",    bodyJson,
                "userActionServerKind", "Api"
            ));

            // Step 1: Create user action challenge
            HttpRequest initReq = buildRequest("POST", "/auth/action/init", Map.of(), initBody, null);
            UserActionChallenge challenge = execute(initReq, UserActionChallenge.class);

            // Step 2: Sign the challenge
            co.dfns.sdk.auth.CredentialAssertion assertion = config.getSigner().sign(challenge);

            // Step 3: Complete signing to obtain the user action token
            String signBody = mapper.writeValueAsString(Map.of(
                "challengeIdentifier", challenge.challengeIdentifier(),
                "firstFactor", assertion
            ));
            HttpRequest signReq = buildRequest("POST", "/auth/action", Map.of(), signBody, null);
            @SuppressWarnings("unchecked")
            Map<String, Object> signResp = execute(signReq, Map.class);
            return (String) signResp.get("userAction");
        } catch (DfnsException e) {
            throw e;
        } catch (Exception e) {
            throw new DfnsException("Failed to obtain user action token: " + e.getMessage(), e);
        }
    }

    private CompletableFuture<String> obtainUserActionTokenAsync(String method, String path, Object body) {
        try {
            String bodyJson = body != null ? mapper.writeValueAsString(body) : "{}";
            String initBody = mapper.writeValueAsString(Map.of(
                "userActionHttpMethod", method,
                "userActionHttpPath",   path,
                "userActionPayload",    bodyJson,
                "userActionServerKind", "Api"
            ));
            HttpRequest initReq = buildRequest("POST", "/auth/action/init", Map.of(), initBody, null);
            return executeAsync(initReq, UserActionChallenge.class)
                .thenCompose(challenge -> {
                    try {
                        co.dfns.sdk.auth.CredentialAssertion assertion = config.getSigner().sign(challenge);
                        String signBody = mapper.writeValueAsString(Map.of(
                            "challengeIdentifier", challenge.challengeIdentifier(),
                            "firstFactor", assertion
                        ));
                        HttpRequest signReq = buildRequest("POST", "/auth/action", Map.of(), signBody, null);
                        @SuppressWarnings("unchecked")
                        Class<Map<String, Object>> mapClass = (Class<Map<String, Object>>) (Class<?>) Map.class;
                        return executeAsync(signReq, mapClass);
                    } catch (Exception e) {
                        return CompletableFuture.<Map<String, Object>>failedFuture(
                            new DfnsException("Failed to sign user action challenge: " + e.getMessage(), e));
                    }
                })
                .thenApply(signResp -> (String) signResp.get("userAction"));
        } catch (Exception e) {
            return CompletableFuture.failedFuture(
                new DfnsException("Failed to initiate user action signing: " + e.getMessage(), e));
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    // Delegated user action signing (init/complete split)
    //
    // These expose the two halves of user action signing so a challenge can be
    // signed out-of-band (e.g. by an end user's device) instead of by a Signer
    // held in this process. createUserActionChallenge returns the challenge to
    // sign; completeUserActionSigning exchanges the signed assertion for a token;
    // executeWithUserAction issues the request with that token.

    public UserActionChallenge createUserActionChallenge(String method, String path, Object body) {
        try {
            String bodyJson = body != null ? mapper.writeValueAsString(body) : "{}";
            String initBody = mapper.writeValueAsString(Map.of(
                "userActionHttpMethod", method,
                "userActionHttpPath",   path,
                "userActionPayload",    bodyJson,
                "userActionServerKind", "Api"
            ));
            HttpRequest initReq = buildRequest("POST", "/auth/action/init", Map.of(), initBody, null);
            return execute(initReq, UserActionChallenge.class);
        } catch (DfnsException e) {
            throw e;
        } catch (Exception e) {
            throw new DfnsException("Failed to create user action challenge: " + e.getMessage(), e);
        }
    }

    public CompletableFuture<UserActionChallenge> createUserActionChallengeAsync(String method, String path, Object body) {
        try {
            String bodyJson = body != null ? mapper.writeValueAsString(body) : "{}";
            String initBody = mapper.writeValueAsString(Map.of(
                "userActionHttpMethod", method,
                "userActionHttpPath",   path,
                "userActionPayload",    bodyJson,
                "userActionServerKind", "Api"
            ));
            HttpRequest initReq = buildRequest("POST", "/auth/action/init", Map.of(), initBody, null);
            return executeAsync(initReq, UserActionChallenge.class);
        } catch (Exception e) {
            return CompletableFuture.failedFuture(
                new DfnsException("Failed to create user action challenge: " + e.getMessage(), e));
        }
    }

    public String completeUserActionSigning(String challengeIdentifier, co.dfns.sdk.auth.CredentialAssertion assertion) {
        try {
            String signBody = mapper.writeValueAsString(Map.of(
                "challengeIdentifier", challengeIdentifier,
                "firstFactor", assertion
            ));
            HttpRequest signReq = buildRequest("POST", "/auth/action", Map.of(), signBody, null);
            @SuppressWarnings("unchecked")
            Map<String, Object> signResp = execute(signReq, Map.class);
            return (String) signResp.get("userAction");
        } catch (DfnsException e) {
            throw e;
        } catch (Exception e) {
            throw new DfnsException("Failed to complete user action signing: " + e.getMessage(), e);
        }
    }

    public CompletableFuture<String> completeUserActionSigningAsync(String challengeIdentifier, co.dfns.sdk.auth.CredentialAssertion assertion) {
        try {
            String signBody = mapper.writeValueAsString(Map.of(
                "challengeIdentifier", challengeIdentifier,
                "firstFactor", assertion
            ));
            HttpRequest signReq = buildRequest("POST", "/auth/action", Map.of(), signBody, null);
            @SuppressWarnings("unchecked")
            Class<Map<String, Object>> mapClass = (Class<Map<String, Object>>) (Class<?>) Map.class;
            return executeAsync(signReq, mapClass).thenApply(signResp -> (String) signResp.get("userAction"));
        } catch (Exception e) {
            return CompletableFuture.failedFuture(
                new DfnsException("Failed to complete user action signing: " + e.getMessage(), e));
        }
    }

    public <T> T executeWithUserAction(String method, String path, Map<String, String> query, Object body, Class<T> responseType, String userAction) {
        return execute(buildRequest(method, path, query, body, userAction), responseType);
    }

    public <T> T executeWithUserAction(String method, String path, Map<String, String> query, Object body, TypeReference<T> responseType, String userAction) {
        return executeWithTypeRef(buildRequest(method, path, query, body, userAction), responseType);
    }

    public <T> CompletableFuture<T> executeWithUserActionAsync(String method, String path, Map<String, String> query, Object body, Class<T> responseType, String userAction) {
        return executeAsync(buildRequest(method, path, query, body, userAction), responseType);
    }

    public <T> CompletableFuture<T> executeWithUserActionAsync(String method, String path, Map<String, String> query, Object body, TypeReference<T> responseType, String userAction) {
        return executeAsyncWithTypeRef(buildRequest(method, path, query, body, userAction), responseType);
    }

    private HttpRequest buildRequest(String method, String path, Map<String, String> query, Object body, String userAction) {
        try {
            String url = buildTransportUrl(path);
            if (!query.isEmpty()) {
                String qs = query.entrySet().stream()
                    .map(e -> java.net.URLEncoder.encode(e.getKey(), java.nio.charset.StandardCharsets.UTF_8) + "=" + java.net.URLEncoder.encode(e.getValue(), java.nio.charset.StandardCharsets.UTF_8))
                    .reduce("", (a, b) -> a.isEmpty() ? b : a + "&" + b);
                url += "?" + qs;
            }

            HttpRequest.BodyPublisher publisher = body instanceof String s
                ? HttpRequest.BodyPublishers.ofString(s)
                : body != null
                    ? HttpRequest.BodyPublishers.ofString(mapper.writeValueAsString(body))
                    : HttpRequest.BodyPublishers.noBody();

            HttpRequest.Builder req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .method(method, publisher)
                .header("Content-Type", "application/json")
                .header(DFNS_AUTH_TOKEN_HEADER, "Bearer " + config.getAuthToken())
                .timeout(config.getRequestTimeout());

            if (userAction != null) req.header(DFNS_USER_ACTION_HEADER, userAction);

            return req.build();
        } catch (Exception e) {
            throw new DfnsException("Failed to build HTTP request: " + e.getMessage(), e);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T postMultipart(String path, Map<String, String> query, Object body, byte[] file, Class<T> responseType, boolean requiresUserAction) {
        try {
            Map<String, Object> data = body != null
                ? mapper.convertValue(body, Map.class)
                : new java.util.LinkedHashMap<>();
            data.put("fileChecksum", sha256Hex(file));
            String dataJson = mapper.writeValueAsString(data);

            String userAction = null;
            if (requiresUserAction && config.getSigner() != null) {
                userAction = obtainUserActionToken("POST", path, data);
            }
            return execute(buildMultipartRequest("POST", path, query, dataJson, file, userAction), responseType);
        } catch (DfnsException e) {
            throw e;
        } catch (Exception e) {
            throw new DfnsException("Failed to perform multipart upload: " + e.getMessage(), e);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> CompletableFuture<T> postMultipartAsync(String path, Map<String, String> query, Object body, byte[] file, Class<T> responseType, boolean requiresUserAction) {
        try {
            Map<String, Object> data = body != null
                ? mapper.convertValue(body, Map.class)
                : new java.util.LinkedHashMap<>();
            data.put("fileChecksum", sha256Hex(file));
            String dataJson = mapper.writeValueAsString(data);

            if (requiresUserAction && config.getSigner() != null) {
                return obtainUserActionTokenAsync("POST", path, data)
                    .thenCompose(userAction -> executeAsync(buildMultipartRequest("POST", path, query, dataJson, file, userAction), responseType));
            }
            return executeAsync(buildMultipartRequest("POST", path, query, dataJson, file, null), responseType);
        } catch (Exception e) {
            return CompletableFuture.failedFuture(new DfnsException("Failed to perform multipart upload: " + e.getMessage(), e));
        }
    }

    private HttpRequest buildMultipartRequest(String method, String path, Map<String, String> query, String dataJson, byte[] file, String userAction) {
        try {
            String url = buildTransportUrl(path);
            if (!query.isEmpty()) {
                String qs = query.entrySet().stream()
                    .map(e -> java.net.URLEncoder.encode(e.getKey(), java.nio.charset.StandardCharsets.UTF_8) + "=" + java.net.URLEncoder.encode(e.getValue(), java.nio.charset.StandardCharsets.UTF_8))
                    .reduce("", (a, b) -> a.isEmpty() ? b : a + "&" + b);
                url += "?" + qs;
            }

            String boundary = "DfnsBoundary" + Long.toHexString(System.nanoTime());
            String crlf = "\r\n";
            java.nio.charset.Charset utf8 = java.nio.charset.StandardCharsets.UTF_8;
            java.util.List<byte[]> parts = new java.util.ArrayList<>();
            parts.add(("--" + boundary + crlf
                + "Content-Disposition: form-data; name=\"data\"" + crlf + crlf
                + dataJson + crlf).getBytes(utf8));
            parts.add(("--" + boundary + crlf
                + "Content-Disposition: form-data; name=\"file\"; filename=\"upload.bin\"" + crlf
                + "Content-Type: application/octet-stream" + crlf + crlf).getBytes(utf8));
            parts.add(file);
            parts.add((crlf + "--" + boundary + "--" + crlf).getBytes(utf8));

            HttpRequest.Builder req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .method(method, HttpRequest.BodyPublishers.ofByteArrays(parts))
                .header("Content-Type", "multipart/form-data; boundary=" + boundary)
                .header(DFNS_AUTH_TOKEN_HEADER, "Bearer " + config.getAuthToken())
                .timeout(config.getRequestTimeout());

            if (userAction != null) req.header(DFNS_USER_ACTION_HEADER, userAction);

            return req.build();
        } catch (Exception e) {
            throw new DfnsException("Failed to build multipart request: " + e.getMessage(), e);
        }
    }

    private String buildTransportUrl(String path) {
        if (path == null || !path.startsWith("/") || path.startsWith("//"))
            throw new DfnsException("Request path must be root-relative", 0, null, null, null, null);
        return config.getBaseUrl() + path;
    }

    private static String sha256Hex(byte[] bytes) {
        try {
            byte[] digest = java.security.MessageDigest.getInstance("SHA-256").digest(bytes);
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                sb.append(Character.forDigit((b >> 4) & 0xF, 16)).append(Character.forDigit(b & 0xF, 16));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new DfnsException("SHA-256 not available: " + e.getMessage(), e);
        }
    }

    private <T> T execute(HttpRequest request, Class<T> responseType) {
        try {
            HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());
            return handleResponse(response, responseType);
        } catch (DfnsException e) {
            throw e;
        } catch (Exception e) {
            throw new DfnsException("HTTP request failed: " + e.getMessage(), e);
        }
    }

    private <T> CompletableFuture<T> executeAsync(HttpRequest request, Class<T> responseType) {
        return http.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(response -> handleResponse(response, responseType));
    }

    private <T> T handleResponse(HttpResponse<String> response, Class<T> responseType) {
        try {
            if (response.statusCode() < 200 || response.statusCode() >= 300) {
                String requestId = response.headers().firstValue("X-Request-ID").orElse(null);
                String errorCode = null;
                String errorMessage = null;
                try {
                    @SuppressWarnings("unchecked")
                    Map<String, Object> err = mapper.readValue(response.body(), Map.class);
                    errorCode = (String) err.get("error");
                    errorMessage = (String) err.get("message");
                } catch (Exception ignored) {}
                throw new DfnsException(
                    "Dfns API error (HTTP " + response.statusCode() + ")" + (errorMessage != null ? ": " + errorMessage : ""),
                    response.statusCode(), errorCode, errorMessage, requestId, response.body());
            }
            if (responseType == Void.class || response.body() == null || response.body().isBlank()) {
                return null;
            }
            return mapper.readValue(response.body(), responseType);
        } catch (DfnsException e) {
            throw e;
        } catch (Exception e) {
            throw new DfnsException("Failed to parse response: " + e.getMessage(), e);
        }
    }

    // TypeReference-based execution methods for generic types

    private <T> T executeWithOptionalUserActionTypeRef(
            String method, String path, Map<String, String> query, Object body, TypeReference<T> responseType, boolean requiresUserAction) {
        if (!requiresUserAction || config.getSigner() == null) {
            return executeWithTypeRef(buildRequest(method, path, query, body, null), responseType);
        }
        String userAction = obtainUserActionToken(method, path, body);
        return executeWithTypeRef(buildRequest(method, path, query, body, userAction), responseType);
    }

    private <T> CompletableFuture<T> executeWithOptionalUserActionAsyncTypeRef(
            String method, String path, Map<String, String> query, Object body, TypeReference<T> responseType, boolean requiresUserAction) {
        if (!requiresUserAction || config.getSigner() == null) {
            return executeAsyncWithTypeRef(buildRequest(method, path, query, body, null), responseType);
        }
        return obtainUserActionTokenAsync(method, path, body)
            .thenCompose(userAction -> executeAsyncWithTypeRef(buildRequest(method, path, query, body, userAction), responseType));
    }

    private <T> T executeWithTypeRef(HttpRequest request, TypeReference<T> responseType) {
        try {
            HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());
            return handleResponseWithTypeRef(response, responseType);
        } catch (DfnsException e) {
            throw e;
        } catch (Exception e) {
            throw new DfnsException("HTTP request failed: " + e.getMessage(), e);
        }
    }

    private <T> CompletableFuture<T> executeAsyncWithTypeRef(HttpRequest request, TypeReference<T> responseType) {
        return http.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(response -> handleResponseWithTypeRef(response, responseType));
    }

    private <T> T handleResponseWithTypeRef(HttpResponse<String> response, TypeReference<T> responseType) {
        try {
            if (response.statusCode() < 200 || response.statusCode() >= 300) {
                String requestId = response.headers().firstValue("X-Request-ID").orElse(null);
                String errorCode = null;
                String errorMessage = null;
                try {
                    @SuppressWarnings("unchecked")
                    Map<String, Object> err = mapper.readValue(response.body(), Map.class);
                    errorCode = (String) err.get("error");
                    errorMessage = (String) err.get("message");
                } catch (Exception ignored) {}
                throw new DfnsException(
                    "Dfns API error (HTTP " + response.statusCode() + ")" + (errorMessage != null ? ": " + errorMessage : ""),
                    response.statusCode(), errorCode, errorMessage, requestId, response.body());
            }
            if (response.body() == null || response.body().isBlank()) {
                return null;
            }
            return mapper.readValue(response.body(), responseType);
        } catch (DfnsException e) {
            throw e;
        } catch (Exception e) {
            throw new DfnsException("Failed to parse response: " + e.getMessage(), e);
        }
    }

    @Override
    public void close() {
        // HttpClient.close() is available in Java 21+; safe no-op on Java 17
    }
}
