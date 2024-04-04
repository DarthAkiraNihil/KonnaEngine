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
    protected ArrayList<BufferedImage> tileSheets;
    protected HashMap<Integer, KTileRenderAttributes> tilesMap;

    public KTileTable() {
        this.tileSheets = new ArrayList<>();
        this.tilesMap = new HashMap<>();
    }

    public void addTileSheet(BufferedImage tileSheet) {
        this.tileSheets.add(tileSheet);
    }

    public void addTileSheets(BufferedImage[] tileSheets) {
        this.tileSheets.addAll(Arrays.asList(tileSheets));
    }
    public void addTile(KTileRenderAttributes tileAttributes) {
        tilesMap.put(tileAttributes.id, tileAttributes);
    }

    public void addTiles(KTileRenderAttributes[]  tiles) {
        for (KTileRenderAttributes tile : tiles) {
            this.addTile(tile);
        }
    }

    public BufferedImage getRendered(KRenderUnit unit) throws KNotFoundException {
        if (!this.tilesMap.containsKey(unit.id)) {
            throw new KNotFoundException(String.format("Tile with id %d not found", unit.id));
        } else {
            KTileRenderAttributes tileAttributes = this.tilesMap.get(unit.id);
            if (!(tileAttributes.sheetId > 0 && tileAttributes.sheetId < this.tileSheets.size())) {
                throw new KNotFoundException(String.format("Tile sheet with id %d not found", tileAttributes.sheetId));
            } else {
                BufferedImage rendered = this.tileSheets.get(tileAttributes.sheetId).getSubimage(
                    tileAttributes.tileTopLeftCorner.x,
                    tileAttributes.tileTopLeftCorner.y,
                    tileAttributes.tileSize.w,
                    tileAttributes.tileSize.h
                );

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
