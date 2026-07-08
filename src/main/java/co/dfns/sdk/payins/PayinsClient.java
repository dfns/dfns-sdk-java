package co.dfns.sdk.payins;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.payins.model.*;
import java.util.Map;

public class PayinsClient {
    private final DfnsHttpClient httpClient;

    public PayinsClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Get Payin Recipient */
    public GetPayinRecipientResponse getPayinRecipient(GetPayinRecipientQuery query) {
        return httpClient.get("/payins/recipients", query.toMap(), GetPayinRecipientResponse.class);
    }

    /** Register Payin Recipient */
    public RegisterPayinRecipientResponse registerPayinRecipient(Object body) {
        return httpClient.post("/payins/recipients", java.util.Map.of(), body, RegisterPayinRecipientResponse.class, true);
    }
}
