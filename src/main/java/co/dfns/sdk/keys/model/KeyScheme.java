package co.dfns.sdk.keys.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum KeyScheme {
    ECDSA("ECDSA"),
    EdDSA("EdDSA"),
    Schnorr("Schnorr"),
    UNKNOWN(null);


    private final String value;

    KeyScheme(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static KeyScheme fromValue(String value) {
        for (KeyScheme e : values()) {
            if (e.value != null && e.value.equals(value)) return e;
        }
        return UNKNOWN;
    }
}
