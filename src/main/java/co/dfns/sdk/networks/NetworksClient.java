package co.dfns.sdk.networks;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.networks.model.*;
import java.util.Map;
import java.util.List;
import co.dfns.sdk.PaginatedList;

public class NetworksClient {
    private final DfnsHttpClient httpClient;

    public NetworksClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Estimate Fees */
    public Object estimateFees(EstimateFeesQuery query) {
        return httpClient.get("/networks/fees", query.toMap(), Object.class);
    }

    /** Call Function */
    @SuppressWarnings("unchecked")
    public Map<String, Object> callFunction(String network, CallFunctionRequest body) {
        return httpClient.post("/networks/" + network + "/call-function", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, false);
    }

    /** Get Canton Validator */
    public CantonValidator getCantonValidator(String network, String validatorId) {
        return httpClient.get("/networks/" + network + "/validators/" + validatorId, java.util.Map.of(), CantonValidator.class);
    }

    /** Update Canton Validator */
    public CantonValidator updateCantonValidator(String network, String validatorId, UpdateCantonValidatorRequest body) {
        return httpClient.put("/networks/" + network + "/validators/" + validatorId, java.util.Map.of(), body, CantonValidator.class, true);
    }

    /** Delete Canton Validator */
    public CantonValidator deleteCantonValidator(String network, String validatorId) {
        return httpClient.delete("/networks/" + network + "/validators/" + validatorId, java.util.Map.of(), null, CantonValidator.class, true);
    }

    /** List Canton Validators */
    public PaginatedList<CantonValidator> listCantonValidators(String network, ListCantonValidatorsQuery query) {
        return httpClient.get("/networks/" + network + "/validators", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<CantonValidator>>() {});
    }

    /** Create Canton Validator */
    public CantonValidator createCantonValidator(String network, Object body) {
        return httpClient.post("/networks/" + network + "/validators", java.util.Map.of(), body, CantonValidator.class, true);
    }
}
