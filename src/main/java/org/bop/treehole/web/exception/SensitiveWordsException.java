package org.bop.treehole.web.exception;

public class SensitiveWordsException extends TreeHoleRuntimeException {
    private static final long serialVersionUID = 5041051393720525912L;

    public SensitiveWordsException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public SensitiveWordsException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause, errorCode);
    }

    public SensitiveWordsException(Throwable cause, ErrorCode errorCode) {
        super(cause, errorCode);
    }
}
