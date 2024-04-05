package org.konna.engine.graphic.text;

import org.konna.engine.common.KSize;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class KTileFont extends KFont{

    protected final BufferedImage fontFace;
    protected final KSize fontSize;
    protected final KTileFontType fontType;

    public KTileFont(String name, KTileFontType type, BufferedImage fontFace, KSize fontSize, KTileFontType fontType) {
        super(name, type);
        this.fontFace = fontFace;
        this.fontSize = fontSize;
        this.fontType = fontType;
    }

    @Override
    public ArrayList<BufferedImage> render(KText text) {
        return null;
    }
}
