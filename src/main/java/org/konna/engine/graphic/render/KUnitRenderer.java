package org.konna.engine.graphic.render;

import org.konna.engine.common.except.KNotFoundException;
import org.konna.engine.common.except.KRenderError;
import org.konna.engine.graphic.tables.*;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class KUnitRenderer implements KBaseRenderer {

    private final KTileTable tileTable;
    private final KSpriteTable spriteTable;
    private final KImageTable imageTable;

    public KUnitRenderer(KTileTable tileTable, KSpriteTable spriteTable, KImageTable imageTable) {
        this.tileTable = tileTable;
        this.spriteTable = spriteTable;
        this.imageTable = imageTable;
    }

    @Override
    public BufferedImage render(KRenderUnit unit) throws KRenderError{
        try {
            return switch (unit.type) {
                case Tile -> this.tileTable.getRendered(unit);
                case Sprite -> this.spriteTable.getRendered(unit);
                case Image -> this.imageTable.getRendered(unit);
                default -> null;
            };
        } catch (Exception e) {
            throw new KRenderError(e);
        }


    }

    // Render machine = text re + unit re
    // by type passes to required table
    // text renderer contains hashmap str: jey : font name, value: font
}
