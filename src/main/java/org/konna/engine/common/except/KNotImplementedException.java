package org.konna.engine.common.except;

public class KNotImplementedException extends RuntimeException {
    public KNotImplementedException() {
        super();
    }

    public KNotImplementedException(String message) {
        super(message);
    }

    public KNotImplementedException(String message, Throwable cause) {
        super(message, cause);
    }

    public KNotImplementedException(Throwable cause) {
        super(cause);
    }
}
