package co.dfns.sdk.agreements.model;

import java.util.HashMap;
import java.util.Map;

public class GetLatestUnacceptedAgreementQuery {
    private String agreementType;

    public GetLatestUnacceptedAgreementQuery agreementType(String agreementType) {
        this.agreementType = agreementType;
        return this;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        if (agreementType != null) map.put("agreementType", String.valueOf(agreementType));
        return map;
    }
}
