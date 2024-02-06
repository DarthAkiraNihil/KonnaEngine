package org.konna.engine.common.except;

public class KNotFoundException extends Exception {
    public KNotFoundException() {
        super();
    }

    public KNotFoundException(String message) {
        super(message);
    }

    public KNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public KNotFoundException(Throwable cause) {
        super(cause);
    }
}
