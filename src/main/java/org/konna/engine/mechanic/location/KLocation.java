package org.konna.engine.mechanic.location;

import org.konna.engine.common.KCoordinates;
import org.konna.engine.graphic.render.KRenderInfo;
import org.konna.engine.graphic.render.KRenderable;

public class KLocation implements KRenderable {
    public final int length, width, height;
    private KTile[][][] tiles;

    public KLocation(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.tiles = new KTile[height][width][length];
    }

    public void setTile(KCoordinates at, KTile tile) {
        this.tiles[at.z][at.y][at.x] = tile;
    }

    @Override
    public KRenderInfo getRenderInfo() {
        KRenderInfo renderInfo = new KRenderInfo();
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                for (int k = 0; k < this.length; k++) {
                    renderInfo.addUnits(this.tiles[i][j][k].getRenderInfo());
                }
            }
        }
        return renderInfo;
    }
}
