package org.konna.engine.common.except;

public class KEventException extends Exception {
    public KEventException() {
        super();
    }
    public KEventException(String eventName) {
        super(String.format(
                "Something went wrong with the event '%s', check if the event exists",
                eventName
        ));
    }
    public KEventException(String message, Throwable cause) {
        super(message, cause);
    }
    public KEventException(Throwable cause) {
        super(cause);
    }

}
