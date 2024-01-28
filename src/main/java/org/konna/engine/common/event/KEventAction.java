package org.konna.engine.common.event;

@FunctionalInterface
public interface KEventAction<T> {
    void accept(T arg);
}
