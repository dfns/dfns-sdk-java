package co.dfns.sdk.internal;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/** Shared Jackson ObjectMapper singleton. */
public final class JsonMapper {
    private static final ObjectMapper INSTANCE = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

    private JsonMapper() {}

    public static ObjectMapper getInstance() { return INSTANCE; }
}
