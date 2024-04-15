package org.konna.engine.graphic.tables;

import org.konna.engine.common.KSize;
import org.konna.engine.common.except.KNotFoundException;
import org.konna.engine.graphic.KColor;
import org.konna.engine.graphic.render.KRenderUnit;
import org.konna.engine.graphic.render.KTileRenderAttributes;
import org.konna.engine.graphic.semiconsole.KSemiConsoleOutputMode;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class KTileTable extends KBaseTable{
    protected ArrayList<KTileSheet> tileSheets;

    public KTileTable() {
        this.tileSheets = new ArrayList<>();
    }

    public void addTileSheet(KTileSheet tileSheet) {
        this.tileSheets.add(tileSheet);
    }

    public void addTileSheets(KTileSheet[] tileSheets) {
        this.tileSheets.addAll(Arrays.asList(tileSheets));
    }

    public BufferedImage getRendered(KRenderUnit unit) throws KNotFoundException {

        for (KTileSheet sheet : this.tileSheets) {
            if (sheet.hasTile(unit.id)) {
                return sheet.getRendered(unit);
            }
        }

        throw new KNotFoundException(String.format("Tile with id %d does not exist", unit.id));
    }
}
