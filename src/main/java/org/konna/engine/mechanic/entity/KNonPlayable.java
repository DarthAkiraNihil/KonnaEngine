package org.konna.engine.mechanic.entity;

import org.konna.engine.common.KEntity;

public abstract class KNonPlayable extends KEntity {
    public KNonPlayable() {
        super();
    }

    public abstract void makeAutoMove();
    public abstract void reactOnPlayableApproaching();
}
