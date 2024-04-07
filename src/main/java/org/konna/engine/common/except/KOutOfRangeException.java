package org.konna.engine.common.except;

public class KOutOfRangeException extends RuntimeException{

    public KOutOfRangeException() {
        super();
    }

    public KOutOfRangeException(String message) {
        super(message);
    }

    public KOutOfRangeException(String message, Throwable cause) {
        super(message, cause);
    }

    public KOutOfRangeException(Throwable cause) {
        super(cause);
    }
    
}
