package org.konna.engine.graphic.tables;

import org.konna.engine.common.except.KNotFoundException;
import org.konna.engine.graphic.KColor;
import org.konna.engine.graphic.KTileRenderAttributes;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class KTileTable {
    private final BufferedImage tileSheet;
    private HashMap<Integer, KTileRenderAttributes> tilesMap;

    public KTileTable(BufferedImage tileSheet) {
        this.tileSheet = tileSheet;
        this.tilesMap = new HashMap<>();
    }

    public void addTile(KTileRenderAttributes tileAttributes) {
        tilesMap.put(tileAttributes.id, tileAttributes);
    }

    public void addTiles(KTileRenderAttributes[] tiles) {
        for (KTileRenderAttributes tile : tiles) {
            this.addTile(tile);
        }
    }

    public BufferedImage getTile(int id) throws KNotFoundException{
        if (!this.tilesMap.containsKey(id)) {
            throw new KNotFoundException(String.format("Tile with id %d not found", id));
        } else {
            KTileRenderAttributes tileAttributes = this.tilesMap.get(id);
            BufferedImage toReturn = this.tileSheet.getSubimage(
                tileAttributes.tileTopLeftCorner.x,
                tileAttributes.tileTopLeftCorner.y,
                tileAttributes.tileSize.w,
                tileAttributes.tileSize.h
            );

            if (tileAttributes.requireColoring) {
                for (int i = 0; i < tileAttributes.tileSize.h; i++) {
                    for (int j = 0; j < tileAttributes.tileSize.w; j++) {
                        KColor newPixColor = new KColor(toReturn.getRGB(j, i));
                        newPixColor.multiply(tileAttributes.tileColor);
                        toReturn.setRGB(
                            j,
                            i,
                            newPixColor.getConvertedToInt()
                        );

                    }
                }
            }
            return toReturn;
        }
    }
}
