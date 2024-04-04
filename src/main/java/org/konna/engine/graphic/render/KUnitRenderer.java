package org.konna.engine.graphic.render;

import org.konna.engine.common.except.KNotFoundException;
import org.konna.engine.common.except.KRenderError;
import org.konna.engine.graphic.tables.KBaseTable;
import org.konna.engine.graphic.tables.KSpriteTable;
import org.konna.engine.graphic.tables.KTileFont;
import org.konna.engine.graphic.tables.KTileTable;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class KUnitRenderer extends KBaseRenderer {

    protected KTileTable tileTable;
    protected KSpriteTable spriteTable;
    protected KTileFont tileFont;

    public KUnitRenderer(KTileTable tileTable, KSpriteTable spriteTable, KTileFont tileFont) {
        this.tileTable = tileTable;
        this.spriteTable = spriteTable;
        this.tileFont = tileFont;
    }

    @Override
    protected BufferedImage renderOne(KRenderUnit unit) throws KNotFoundException {
        return switch (unit.type) {
            case Tile -> this.tileTable.getRendered(unit);
            case Sprite -> null;
            case Symbol -> null;
            case Image -> null;
        };
    }

    @Override
    public ArrayList<BufferedImage> render(KRenderInfo info) {
        //KRenderInfo info = renderable.getRenderInfo();
        ArrayList<BufferedImage> rendered = new ArrayList<>();
        for (int i = 0; i < info.getUnitCount(); i++) {
            try {
                rendered.add(this.renderOne(info.getUnit(i)));
            } catch (Exception e) {
                throw new KRenderError(e);
            }
        }
        return rendered;
    }

    // Render machine = text re + unit re
    // by type passes to required table
    // text renderer contains hashmap str: jey : font name, value: font
}
