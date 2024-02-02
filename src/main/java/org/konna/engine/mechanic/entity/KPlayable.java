package org.konna.engine.mechanic.entity;

import org.konna.engine.common.KEntity;
import org.konna.engine.common.event.KEventListener;

public abstract class KPlayable extends KEntity {
    public KPlayable() {
        super();
    }

    public abstract void reactOnKeyPressed(Character key);
}
