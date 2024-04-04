package org.konna.engine.mechanic.entity;

import org.konna.engine.common.KVector3;
import org.konna.engine.common.KDirection;
import org.konna.engine.common.KMovable;
import org.konna.engine.graphic.KColor;
import org.konna.engine.graphic.render.KRenderInfo;
import org.konna.engine.graphic.render.KRenderUnit;
import org.konna.engine.graphic.render.KRenderable;

public class KPlayer extends KPlayable implements KRenderable, KMovable {
    private KVector3 globalCoordinates;

    public KPlayer(KVector3 globalCoordinates) {
        this.globalCoordinates = globalCoordinates;
    }

    public KRenderInfo getRenderInfo() {
        KRenderInfo info = new KRenderInfo();
        info.addUnit(new KRenderUnit(1, new KColor(255, 0, 0, 0), null));
        return info;
    }

    public void reactOnKeyPressed(Character key) {
        switch (key) {
            case 'W' -> this.move(KDirection.Up, true);
        }
    }

    public void move(KDirection direction, boolean reachable) {
        if (reachable) {
            switch (direction) {
                case Up -> globalCoordinates.y += 1;
                case Down -> globalCoordinates.y -= 1;
                case Left -> globalCoordinates.x -= 1;
                case Right -> globalCoordinates.x += 1;
            }
        }
    }
//private KRenderUnit
}
