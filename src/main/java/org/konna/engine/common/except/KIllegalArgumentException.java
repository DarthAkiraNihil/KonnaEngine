package org.konna.engine.common.except;

public class KIllegalArgumentException extends RuntimeException{
    public KIllegalArgumentException(String message) {
        super(message);
    }

    public KIllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public KIllegalArgumentException(Throwable cause) {
        super(cause);
    }

    public KIllegalArgumentException() {
        super();
    }
}
