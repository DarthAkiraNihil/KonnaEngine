package org.konna.engine.graphic.tables;

import org.konna.engine.common.except.KNotFoundException;
import org.konna.engine.graphic.KColor;
import org.konna.engine.graphic.render.KRenderUnit;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

public class KSpriteTable extends KBaseTable{
    protected HashMap<Integer, BufferedImage> sprites;

    public KSpriteTable() {
        this.sprites = new HashMap<>();
    }

    @Override
    public BufferedImage getRendered(KRenderUnit unit) throws KNotFoundException {

        if (!this.sprites.containsKey(unit.id)) {
            throw new KNotFoundException(String.format("Can't find sprite with id %d", unit.id));
        } else {
            BufferedImage rendered = this.sprites.get(unit.id);

            for (int i = 0; i < rendered.getHeight(); i++) {
                for (int j = 0; j < rendered.getWidth(); j++) {
                    KColor newPixColor = new KColor(rendered.getRGB(j, i));
                    newPixColor.multiply(unit.color);
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
}
