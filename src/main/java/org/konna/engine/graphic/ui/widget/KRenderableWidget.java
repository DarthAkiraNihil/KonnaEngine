package org.konna.engine.graphic.ui.widget;

import org.konna.engine.common.KVector2;
import org.konna.engine.common.KSize;
import org.konna.engine.graphic.render.KRenderable;
//import org.konna.engine.graphic.render.unit.KTileRenderer;

public abstract class KRenderableWidget extends KWidget{
    private KRenderable connectedObject;
    //private final KTileRenderer tileRenderer;

    public KRenderableWidget(KVector2 topLeftCornerCoordinates, KSize size/*, /*KTileRenderer tileRenderer*/) {
        super(topLeftCornerCoordinates, size);
        //this.tileRenderer = tileRenderer;
    }

    public void connectRenderableObject(KRenderable renderable) {
        this.connectedObject = renderable;
    }

    public abstract void render();
    public abstract void update();
}
