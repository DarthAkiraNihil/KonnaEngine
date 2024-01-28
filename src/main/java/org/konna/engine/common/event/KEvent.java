package org.konna.engine.common.event;

import java.util.ArrayList;

public class KEvent<T> {
    private ArrayList<KEventAction<T>> listeners;

    public KEvent() {
        this.listeners = new ArrayList<>();
    }

    public void subscribe(KEventAction<T> callable) {
        this.listeners.add(callable);
    }

    public void unsubscribe(KEventAction<T> callable) {
        this.listeners.remove(callable);
    }

    public void invoke(T argument) {
        for (KEventAction<T> listener: this.listeners) {
            listener.accept(argument);
        }
    }
}
