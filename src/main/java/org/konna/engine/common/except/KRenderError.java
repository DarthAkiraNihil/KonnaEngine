package org.konna.engine.common.except;

public class KRenderError extends RuntimeException{

    public KRenderError() {
        super();
    }

    public KRenderError(String message) {
        super(message);
    }

    public KRenderError(String message, Throwable cause) {
        super(message, cause);
    }

    public KRenderError(Throwable cause) {
        super(cause);
    }

}
