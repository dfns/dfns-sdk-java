package co.dfns.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CredentialKind {
    Fido2("Fido2"),
    Key("Key"),
    RecoveryKey("RecoveryKey"),
    PasswordProtectedKey("PasswordProtectedKey"),
    UNKNOWN(null);


    private final String value;

    CredentialKind(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static CredentialKind fromValue(String value) {
        for (CredentialKind e : values()) {
            if (e.value != null && e.value.equals(value)) return e;
        }
        return UNKNOWN;
    }
}
