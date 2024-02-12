package org.konna.engine.graphic.render;

import org.konna.engine.common.KCoordinates2;
import org.konna.engine.common.KSize;
import org.konna.engine.graphic.KColor;

public class KTileRenderAttributes {
    public final int id;
    public final boolean requireColoring;
    public final KColor tileColor;
    public final int sheetId;
    public final KCoordinates2 tileTopLeftCorner;
    public final KSize tileSize;

    public KTileRenderAttributes(int id, boolean requireColoring, KColor tileColor, int sheetId, KCoordinates2 tileTopLeftCorner, KSize tileSize) {
        this.id = id;
        this.requireColoring = requireColoring;
        this.tileColor = tileColor;
        this.sheetId = sheetId;
        this.tileTopLeftCorner = tileTopLeftCorner;
        this.tileSize = tileSize;
    }
}
