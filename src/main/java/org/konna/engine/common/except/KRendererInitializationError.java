package org.konna.engine.common.except;

public class KRendererInitializationError extends RuntimeException{

    public KRendererInitializationError() {
        super();
    }

    public KRendererInitializationError(String message) {
        super(message);
    }

    public KRendererInitializationError(String message, Throwable cause) {
        super(message, cause);
    }

    public KRendererInitializationError(Throwable cause) {
        super(cause);
    }

}
