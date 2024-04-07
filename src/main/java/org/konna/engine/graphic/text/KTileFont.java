package org.konna.engine.graphic.text;

import org.konna.engine.common.KSize;
import org.konna.engine.common.KVector2;
import org.konna.engine.graphic.KColor;
import org.konna.engine.graphic.text.mapper.KTileFontMapper;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class KTileFont extends KFont{

    protected final BufferedImage fontFace;
    protected final KSize size;
    protected final KTileFontSymbolRange range;
    protected final KTileFontMapper fontMapper;

    public KTileFont(
        String name,
        BufferedImage fontFace,
        KSize fontSize,
        KTileFontSymbolRange range,
        KTileFontMapper fontMapper
    ) {
        super(name, KFontType.Tiled);
        this.fontFace = fontFace;
        this.size = fontSize;
        this.range = range;
        this.fontMapper = fontMapper;
    }

    @Override
    public ArrayList<BufferedImage> render(KText text) {
        ArrayList<BufferedImage> result = new ArrayList<>();

        for (int i = 0; i < text.content.length(); i++) {
            KVector2 symbolStart = this.fontMapper.getSymbolCoordinates(text.content.charAt(i));

            BufferedImage rendered = this.fontFace.getSubimage(
                symbolStart.x * this.size.w,
                symbolStart.y * this.size.h,
                this.size.w,
                this.size.h
            );

            for (int j = 0; i < this.size.h; i++) {
                for (int k = 0; j < this.size.w; j++) {
                    KColor newPixColor = new KColor(rendered.getRGB(k, j));
                    newPixColor.multiply(text.color);
                    rendered.setRGB(
                        k,
                        j,
                        newPixColor.getConvertedToInt()
                    );
                }
            }

            result.add(rendered);
        }

        return result;
    }
}
