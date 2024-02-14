package org.konna.engine.graphic.render.renderers;

import org.konna.engine.common.KCoordinates2;
import org.konna.engine.common.except.KNotFoundException;
import org.konna.engine.graphic.render.KRenderInfo;
import org.konna.engine.graphic.render.KRenderUnit;
import org.konna.engine.graphic.render.KRenderable;
import org.konna.engine.graphic.semiconsole.KSemiConsoleCanvas;
import org.konna.engine.graphic.tables.KTileTable;

public class KTileRenderer extends KBaseRenderer {
    private final KTileTable tileTable;

    public KTileRenderer(KTileTable tileTable) {
        this.tileTable = tileTable;
    }

    @Override
    public void render(KSemiConsoleCanvas canvas, KRenderable renderable, KCoordinates2 at) {
        KRenderInfo renderInfo = renderable.getRenderInfo();
        for (int i = 0; i < renderInfo.getUnitCount(); i++) {
            KRenderUnit unit = renderInfo.getUnit(i);
            KCoordinates2 newPlace = new KCoordinates2(at);
            if (!unit.coordinates.equals(KCoordinates2.InvalidPlace)) {
                newPlace.add(unit.coordinates);
            }
            try {
                canvas.draw(
                    this.tileTable.getTile(unit.id),
                    this.tileTable.getTileSizeMode(unit.id),
                    newPlace
                );
            } catch (KNotFoundException e) {
                continue; //todo remove this shiet
            }
        }

    }
}
