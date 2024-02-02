package org.konna.engine.common.event;

import org.konna.engine.common.except.KEventException;

import java.lang.reflect.Field;

/**
 * <h1>KBaseEventDispatcher class</h1>
 * <p>Used as a base for a game's event dispatcher. An abstract class, must be inherited before using.</p>
 * <p>Class fields are defined by a programmer</p>
 * <p>It's important to know that you should know that you need to override all class methods in an inherited class.
 * These mostly copy the code from base methods, except the fact they MUST call the same method of the super class (in all inherited)</p>
 */
public abstract class KBaseEventDispatcher {
    public KBaseEventDispatcher() {
        
    }

    /**
     * A method to invoke an event
     * @param eventName The name of an invoked event
     * @param argument The argument for the event
     * @param <T> Type of the argument
     * @throws KEventException If no event with this name has been found
     */
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


    /**
     * A method to subscribe an event.
     * @param eventName The name of an event
     * @param callable A callable object (functional interface)
     * @param <T> A type of consuming argument of a callable object
     * @throws KEventException If no event with this name has been found
     */
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
