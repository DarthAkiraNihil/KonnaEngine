package org.konna.engine.mechanic.location;

import org.konna.engine.graphic.KRenderInfo;
import org.konna.engine.graphic.KRenderUnit;
import org.konna.engine.graphic.KRenderable;

public class KTile implements KRenderable {

    private final int id;
    private final String name;
    private KRenderInfo tileRenderInfo;
    private boolean passable, transparent;

    public KTile(int id, String name, KRenderUnit tileRenderInfoUnit, boolean passable, boolean transparent) {
        this.id = id;
        this.name = name;

        this.tileRenderInfo = new KRenderInfo();
        this.tileRenderInfo.addUnit(tileRenderInfoUnit);

        this.passable = passable;
        this.transparent = transparent;
    }

    public boolean isPassable() {
        return passable;
    }

    public boolean isTransparent() {
        return transparent;
    }

    @Override
    public KRenderInfo getRenderInfo() {
        return this.tileRenderInfo;
    }
}
