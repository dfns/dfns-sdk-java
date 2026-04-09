package co.dfns.sdk.keys.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum KeyCurve {
    ed25519("ed25519"),
    secp256k1("secp256k1"),
    stark("stark"),
    UNKNOWN(null);


    private final String value;

    KeyCurve(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static KeyCurve fromValue(String value) {
        for (KeyCurve e : values()) {
            if (e.value != null && e.value.equals(value)) return e;
        }
        return UNKNOWN;
    }
}
