package org.konna.engine.graphic.tables;

import org.konna.engine.common.KSize;
import org.konna.engine.common.except.KNotFoundException;
import org.konna.engine.graphic.KColor;
import org.konna.engine.graphic.render.KRenderUnit;
import org.konna.engine.graphic.render.KTileRenderAttributes;
import org.konna.engine.graphic.semiconsole.KSemiConsoleOutputMode;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class KTileSheet extends KBaseTable{

    protected BufferedImage tileSheet;
    protected HashMap<Integer, KTileRenderAttributes> tilesMap;

    public KTileSheet(BufferedImage tileSheet) {
        this.tileSheet = tileSheet;
        this.tilesMap = new HashMap<>();
    }

    public void addTile(KTileRenderAttributes tileAttributes) {
        tilesMap.put(tileAttributes.id, tileAttributes);
    }

    public void addTiles(KTileRenderAttributes[]  tiles) {
        for (KTileRenderAttributes tile : tiles) {
            this.addTile(tile);
        }
    }

    public boolean hasTile(int id) {
        return this.tilesMap.containsKey(id);
    }

    public BufferedImage getRendered(KRenderUnit unit) throws KNotFoundException {
        if (!this.hasTile(unit.id)) {
            throw new KNotFoundException(String.format("Tile with id %d not found", unit.id));
        } else {
            KTileRenderAttributes tileAttributes = this.tilesMap.get(unit.id);

            WritableRaster data = (
                (WritableRaster) this.tileSheet.getData(
                    new Rectangle(
                        tileAttributes.tileTopLeftCorner.x,
                        tileAttributes.tileTopLeftCorner.y,
                        tileAttributes.tileSize.w,
                        tileAttributes.tileSize.h)
                )
            )
                .createWritableTranslatedChild(0, 0);

            BufferedImage rendered = new BufferedImage(this.tileSheet.getColorModel(), data, this.tileSheet.isAlphaPremultiplied(), null);

            if (tileAttributes.requireColoring) {
                for (int i = 0; i < tileAttributes.tileSize.h; i++) {
                    for (int j = 0; j < tileAttributes.tileSize.w; j++) {
                        KColor newPixColor = new KColor(rendered.getRGB(j, i));
                        newPixColor.multiply(tileAttributes.tileColor);
                        newPixColor.multiply(unit.color); //TODO do nothinng if white
                        rendered.setRGB(
                            j,
                            i,
                            newPixColor.getConvertedToInt()
                        );

                    }
                }
            }
            return rendered;

        }
    }

    public KSemiConsoleOutputMode getTileSizeMode(int id) throws KNotFoundException {
        if (!this.tilesMap.containsKey(id)) {
            throw new KNotFoundException(String.format("Tile with id %d not found", id));
        } else {
            KSize size = this.tilesMap.get(id).tileSize;
            if (size.w == 8 && size.h == 8) {
                return KSemiConsoleOutputMode.Grid8x8;
            } else if (size.w == 12 && size.h == 12) {
                return KSemiConsoleOutputMode.Grid12x12;
            } else if (size.w == 16 && size.h == 16) {
                return KSemiConsoleOutputMode.Grid16x16;
            } else {
                return KSemiConsoleOutputMode.SinglePixelAccuracy;
            }
        }
    }

}
