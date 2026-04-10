package co.dfns.sdk.networks;

import co.dfns.sdk.internal.DfnsHttpClient;
import co.dfns.sdk.networks.model.*;
import java.util.Map;
import java.util.List;
import co.dfns.sdk.PaginatedList;
import java.util.concurrent.CompletableFuture;

public class NetworksAsyncClient {
    private final DfnsHttpClient httpClient;

    public NetworksAsyncClient(DfnsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /** Estimate Fees */
    public CompletableFuture<Object> estimateFees(EstimateFeesQuery query) {
        return httpClient.getAsync("/networks/fees", query.toMap(), Object.class);
    }

    /** Call Function */
    @SuppressWarnings("unchecked")
    public CompletableFuture<Map<String, Object>> callFunction(String network, CallFunctionRequest body) {
        return httpClient.postAsync("/networks/" + network + "/call-function", java.util.Map.of(), body, (Class<Map<String, Object>>) (Class<?>) Map.class, false);
    }

    /** Get Canton Validator */
    public CompletableFuture<CantonValidator> getCantonValidator(String network, String validatorId) {
        return httpClient.getAsync("/networks/" + network + "/validators/" + validatorId, java.util.Map.of(), CantonValidator.class);
    }

    /** Update Canton Validator */
    public CompletableFuture<CantonValidator> updateCantonValidator(String network, String validatorId, UpdateCantonValidatorRequest body) {
        return httpClient.putAsync("/networks/" + network + "/validators/" + validatorId, java.util.Map.of(), body, CantonValidator.class, true);
    }

    /** Delete Canton Validator */
    public CompletableFuture<CantonValidator> deleteCantonValidator(String network, String validatorId) {
        return httpClient.deleteAsync("/networks/" + network + "/validators/" + validatorId, java.util.Map.of(), null, CantonValidator.class, true);
    }

    /** List Canton Validators */
    public CompletableFuture<PaginatedList<CantonValidator>> listCantonValidators(String network, ListCantonValidatorsQuery query) {
        return httpClient.getAsync("/networks/" + network + "/validators", query.toMap(), new com.fasterxml.jackson.core.type.TypeReference<PaginatedList<CantonValidator>>() {});
    }

    /** Create Canton Validator */
    public CompletableFuture<CantonValidator> createCantonValidator(String network, Object body) {
        return httpClient.postAsync("/networks/" + network + "/validators", java.util.Map.of(), body, CantonValidator.class, true);
    }
}
