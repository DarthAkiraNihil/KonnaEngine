package org.konna.engine.common.except;

/**
 * <h1>KEventException class</h1>
 * <p>An exception representing different exceptional situations with an event system, such as</p>
 * <ul>
 *     <li>There were no event at the moment of invocation</li>
 * </ul>
 */
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
