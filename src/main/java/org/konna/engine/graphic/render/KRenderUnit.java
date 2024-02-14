package org.konna.engine.graphic.render;

import org.konna.engine.common.KCoordinates2;
import org.konna.engine.graphic.KColor;

public class KRenderUnit {
    public final int id;
    public KRenderUnitType type;
    public KColor color;
    public KCoordinates2 coordinates;

    public KRenderUnit(int id, KColor color, KCoordinates2 coordinates) {
        this.id = id;
        this.color = color;
        this.coordinates = coordinates; //????
    }

    public KRenderUnit(int id, KColor color) {
        this.id = id;
        this.color = color;
        this.coordinates = KCoordinates2.InvalidPlace;
    }
}
