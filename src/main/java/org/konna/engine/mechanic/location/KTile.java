package org.konna.engine.mechanic.location;

import org.konna.engine.graphic.KColor;
import org.konna.engine.graphic.render.KRenderInfo;
import org.konna.engine.graphic.render.KRenderUnit;
import org.konna.engine.graphic.render.KRenderable;

public class KTile implements KRenderable {

    private final int id;
    private final String name;
    private final boolean passable, transparent;

    public KTile(int id, String name, boolean passable, boolean transparent) {
        this.id = id;
        this.name = name;
        this.passable = passable;
        this.transparent = transparent;
    }

    public boolean isPassable() {
        return passable;
    }

    public boolean isTransparent() {
        return transparent;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public KRenderInfo getRenderInfo() {
        KRenderInfo temp = new KRenderInfo();
        temp.addUnit(new KRenderUnit(this.id, KColor.NoColor));
        return temp;
    }
}
