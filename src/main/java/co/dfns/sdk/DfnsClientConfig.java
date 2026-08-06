package co.dfns.sdk;

import co.dfns.sdk.auth.Signer;
import java.net.URI;
import java.time.Duration;

/** Configuration for all Dfns SDK clients. Build via {@link #builder()}. */
public class DfnsClientConfig {
    private final String   baseUrl;
    private final String   authToken;
    private final Signer   signer;
    private final Duration requestTimeout;

    private DfnsClientConfig(Builder b) {
        this.baseUrl        = normalizeBaseUrl(b.baseUrl);
        this.authToken      = b.authToken;
        this.signer         = b.signer;
        this.requestTimeout = b.requestTimeout;
    }

    public String   getBaseUrl()        { return baseUrl; }
    public String   getAuthToken()      { return authToken; }
    public Signer   getSigner()         { return signer; }
    public Duration getRequestTimeout() { return requestTimeout; }

    private static String normalizeBaseUrl(String baseUrl) {
        if (baseUrl == null || baseUrl.isBlank())
            throw new IllegalStateException("baseUrl is required");

        URI uri;
        try {
            uri = URI.create(baseUrl);
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("baseUrl must be a valid absolute URL", e);
        }
        if (!uri.isAbsolute() || uri.getHost() == null)
            throw new IllegalStateException("baseUrl must be an absolute URL");
        if (uri.getRawQuery() != null)
            throw new IllegalStateException("baseUrl must not include a query");
        if (uri.getRawFragment() != null)
            throw new IllegalStateException("baseUrl must not include a fragment");

        return baseUrl.replaceAll("/+$", "");
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String   baseUrl        = "https://api.dfns.io";
        private String   authToken;
        private Signer   signer;
        private Duration requestTimeout = Duration.ofSeconds(30);

        public Builder baseUrl(String baseUrl)              { this.baseUrl = baseUrl;              return this; }
        public Builder authToken(String authToken)          { this.authToken = authToken;          return this; }
        public Builder signer(Signer signer)                { this.signer = signer;                return this; }
        public Builder requestTimeout(Duration requestTimeout) { this.requestTimeout = requestTimeout; return this; }

        public DfnsClientConfig build() {
            if (authToken == null || authToken.isBlank())
                throw new IllegalStateException("authToken is required");
            return new DfnsClientConfig(this);
        }
    }
}
