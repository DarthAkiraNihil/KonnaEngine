package org.konna.engine.graphic;

import org.konna.engine.common.KCoordinates;

public class KRenderUnit {
    public int unitID;
    public KColor color;
    public KCoordinates coordinates;

    public KRenderUnit(int unitID, KColor color, KCoordinates coordinates) {
        this.unitID = unitID;
        this.color = color;
        this.coordinates = coordinates; //????
    }
}
