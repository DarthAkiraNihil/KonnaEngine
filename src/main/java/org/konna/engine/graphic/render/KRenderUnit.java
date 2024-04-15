package org.konna.engine.graphic.render;

import org.konna.engine.common.KVector2;
import org.konna.engine.graphic.KColor;
import org.konna.engine.graphic.text.KText;

public class KRenderUnit {
    public final int id;
    public KRenderUnitType type;
    public KColor color;
    public KVector2 coordinates;
    public KText text;

    public KRenderUnit(int id, KColor color, KVector2 coordinates) {
        this.id = id;
        this.color = color;
        this.coordinates = coordinates; //????
        this.type = KRenderUnitType.Tile;
    }

    public KRenderUnit(int id, KColor color) {
        this.id = id;
        this.color = color;
        this.coordinates = KVector2.InvalidPlace;
        this.type = KRenderUnitType.Tile;
    }

    public KRenderUnit(KText text, KVector2 coordinates) {
        this.id = 0;
        this.text = text;
        this.coordinates = coordinates;
        this.type = KRenderUnitType.Text;
    }
}
