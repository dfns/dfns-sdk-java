package co.dfns.sdk;

/** Thrown when the Dfns API returns a non-2xx response or a network error occurs. */
public class DfnsException extends RuntimeException {
    private final int    httpStatus;
    private final String dfnsErrorCode;
    private final String errorMessage;
    private final String requestId;
    private final String responseBody;

    public DfnsException(String message, int httpStatus, String dfnsErrorCode, String errorMessage, String requestId, String responseBody) {
        super(message);
        this.httpStatus    = httpStatus;
        this.dfnsErrorCode = dfnsErrorCode;
        this.errorMessage  = errorMessage;
        this.requestId     = requestId;
        this.responseBody  = responseBody;
    }

    public DfnsException(String message, Throwable cause) {
        super(message, cause);
        this.httpStatus    = 0;
        this.dfnsErrorCode = null;
        this.errorMessage  = null;
        this.requestId     = null;
        this.responseBody  = null;
    }

    public int    getHttpStatus()    { return httpStatus; }
    public String getDfnsErrorCode() { return dfnsErrorCode; }
    public String getErrorMessage()  { return errorMessage; }
    public String getRequestId()     { return requestId; }
    public String getResponseBody()  { return responseBody; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("DfnsException{");
        sb.append("httpStatus=").append(httpStatus);
        if (dfnsErrorCode != null) sb.append(", errorCode='").append(dfnsErrorCode).append("'");
        if (errorMessage != null) sb.append(", errorMessage='").append(errorMessage).append("'");
        if (requestId != null) sb.append(", requestId='").append(requestId).append("'");
        sb.append("}");
        return sb.toString();
    }
}
