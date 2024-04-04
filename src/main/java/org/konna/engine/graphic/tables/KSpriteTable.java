package org.konna.engine.graphic.tables;

import org.konna.engine.common.except.KNotFoundException;
import org.konna.engine.graphic.KColor;
import org.konna.engine.graphic.render.KRenderUnit;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class KSpriteTable extends KBaseTable{
    protected ArrayList<BufferedImage> sprites;

    public KSpriteTable() {
        this.sprites = new ArrayList<>();
    }

    @Override
    public BufferedImage getRendered(KRenderUnit unit) throws KNotFoundException {
        BufferedImage rendered = this.sprites.get(unit.id);

        for (int i = 0; i < rendered.getHeight(); i++) {
            for (int j = 0; j < rendered.getWidth(); j++) {
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
