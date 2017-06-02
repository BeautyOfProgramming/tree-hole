package org.bop.treehole.web.exception;

import lombok.Getter;

import java.util.UUID;

// TODO Add exception advice for better handling, the desired response entity should be defined in common module
@Getter
public abstract class TreeHoleRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 2420142958423451699L;

    /**
     * Add a UUID as traceId to better debug from the logs
     */
    private final String traceId = UUID.randomUUID().toString();

    /**
     * A common business specified error code for sorting the exception
     */
    private final ErrorCode errorCode;

    protected TreeHoleRuntimeException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    protected TreeHoleRuntimeException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    protected TreeHoleRuntimeException(Throwable cause, ErrorCode errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    /**
     * Better exception message handle, easy to log or user friendly display
     */
    @Override
    public String getMessage() {
        return String.format("[%d]%s, TraceId: %s%n%s", errorCode.getCode(), errorCode.getDesc(), traceId, super.getMessage());
    }
}
