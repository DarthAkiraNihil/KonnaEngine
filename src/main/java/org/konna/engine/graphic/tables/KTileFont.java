package org.konna.engine.graphic.tables;

import org.konna.engine.common.KSize;
import org.konna.engine.common.except.KNotFoundException;
import org.konna.engine.graphic.KColor;
import org.konna.engine.graphic.text.KTileFontSymbolRange;
import org.konna.engine.graphic.render.KRenderUnit;

import java.awt.image.BufferedImage;

public class KTileFont extends KBaseTable{
    protected final BufferedImage fontFace;
    protected final KTileFontSymbolRange fontType;
    protected final KSize fontSize;
    protected final String fontName;

    public KTileFont(
        BufferedImage fontFace,
        KTileFontSymbolRange fontType,
        KSize fontSize,
        String fontName
    ) {
        this.fontFace = fontFace;
        this.fontType = fontType;
        this.fontSize = fontSize;
        this.fontName = fontName;
    }

    public String getFontName() {
        return this.fontName;
    }

    @Override
    public BufferedImage getRendered(KRenderUnit unit) throws KNotFoundException {
        //TODO Font renders the whole text
        BufferedImage rendered = this.fontFace.getSubimage(
            unit.coordinates.x * this.fontSize.w,
            unit.coordinates.y * this.fontSize.h,
            this.fontSize.w,
            this.fontSize.w
        );

        for (int i = 0; i < this.fontSize.h; i++) {
            for (int j = 0; j < this.fontSize.w; j++) {
                KColor newPixColor = new KColor(rendered.getRGB(j, i));
                newPixColor.multiply(unit.color); //TODO do nothinng if white
                rendered.setRGB(
                    j,
                    i,
                    newPixColor.getConvertedToInt()
                );

            }
        }

        return rendered;
    }
}
