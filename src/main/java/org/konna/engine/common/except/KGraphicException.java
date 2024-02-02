package org.konna.engine.common.except;

public class KGraphicException extends Exception{
    public KGraphicException() {
        super();
    }

    public KGraphicException(String message) {
        super(message);
    }

    public KGraphicException(String message, Throwable cause) {
        super(message, cause);
    }

    public KGraphicException(Throwable cause) {
        super(cause);
    }
}
