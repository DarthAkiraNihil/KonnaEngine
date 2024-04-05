package org.konna.engine.graphic.text;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class KFont {

    protected final String name;
    protected final KTileFontType type;

    public KFont(String name, KTileFontType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public KTileFontType getType() {
        return type;
    }

    public abstract ArrayList<BufferedImage> render(KText text);
}
