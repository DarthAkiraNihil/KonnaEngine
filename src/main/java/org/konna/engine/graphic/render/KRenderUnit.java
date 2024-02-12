package org.konna.engine.graphic.render;

import org.konna.engine.common.KCoordinates;
import org.konna.engine.graphic.KColor;

public class KRenderUnit {
    public final int id;
    public KRenderUnitType type;
    public KColor color;
    public KCoordinates coordinates;

    public KRenderUnit(int id, KColor color, KCoordinates coordinates) {
        this.id = id;
        this.color = color;
        this.coordinates = coordinates; //????
    }
}
