package org.konna.engine.graphic.text;

import org.konna.engine.common.KSize;
import org.konna.engine.common.KVector2;
import org.konna.engine.graphic.KColor;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class KTileFont extends KFont{

    protected final BufferedImage fontFace;
    protected final KSize size;
    protected final KTileFontSymbolRange range;

    public KTileFont(
        String name,
        BufferedImage fontFace,
        KSize fontSize,
        KTileFontSymbolRange range
    ) {
        super(name, KFontType.Tiled);
        this.fontFace = fontFace;
        this.size = fontSize;
        this.range = range;
    }

    @Override
    public ArrayList<BufferedImage> render(KText text) {



//        KVector2 symbolStart = this.findSymbol()
//
//        BufferedImage rendered = this.fontFace.getSubimage(
//            unit.coordinates.x * this.fontSize.w,
//            unit.coordinates.y * this.fontSize.h,
//            this.fontSize.w,
//            this.fontSize.w
//        );
//
//        for (int i = 0; i < this.fontSize.h; i++) {
//            for (int j = 0; j < this.fontSize.w; j++) {
//                KColor newPixColor = new KColor(rendered.getRGB(j, i));
//                newPixColor.multiply(unit.color); //TODO do nothinng if white
//                rendered.setRGB(
//                    j,
//                    i,
//                    newPixColor.getConvertedToInt()
//                );
//
//            }
//        }

        return null;
    }

    protected BufferedImage findSymbol() {
        return null;
    }

    protected KVector2 findSymbolPosition() {
        return null;
    }
}
