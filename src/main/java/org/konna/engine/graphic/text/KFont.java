package org.konna.engine.graphic.text;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class KFont {

    protected final String name;
    protected final KFontType type;

    public KFont(String name, KFontType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public KFontType getType() {
        return type;
    }

    public abstract ArrayList<BufferedImage> render(KText text);
}
