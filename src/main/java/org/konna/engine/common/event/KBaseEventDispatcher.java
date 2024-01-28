package org.konna.engine.common.event;

import org.konna.engine.common.except.KEventException;

import java.lang.reflect.Field;

public abstract class KBaseEventDispatcher {
    public KBaseEventDispatcher() {
        
    }
    public <T> void invokeEvent(String eventName, T argument) throws KEventException {
        Class<KBaseEventDispatcher> meta = KBaseEventDispatcher.class;
        try {
            Field invoked = KBaseEventDispatcher.class.getDeclaredField(eventName);
            KEvent<T> event = (KEvent<T>) invoked.get(this);
            event.invoke(argument);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new KEventException(eventName);
        }
    }

    public <T> void subscribeEvent(String eventName, KEventAction<T> callable) throws KEventException{
        Class<KBaseEventDispatcher> meta = KBaseEventDispatcher.class;
        try {
            Field invoked = meta.getDeclaredField(eventName);
            KEvent<T> event = (KEvent<T>) invoked.get(this);
            event.subscribe(callable);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new KEventException(eventName);
        }
    }
    public <T> void unsubscribeEvent(String eventName, KEventAction<T> callable) throws KEventException{
        Class<KBaseEventDispatcher> meta = KBaseEventDispatcher.class;
        try {
            Field invoked = meta.getDeclaredField(eventName);
            KEvent<T> event = (KEvent<T>) invoked.get(this);
            event.unsubscribe(callable);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new KEventException(eventName);
        }
    }
}
