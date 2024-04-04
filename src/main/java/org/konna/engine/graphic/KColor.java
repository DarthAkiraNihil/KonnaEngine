package org.konna.engine.graphic;

import java.awt.*;
import java.util.Objects;

public class KColor {
    public int red, green, blue, alpha;

    public static final KColor NoColor = new KColor(-1, -1, -1, -1);
    public static final KColor White = new KColor(255, 255, 255, 255); //! FIX if incorrect alpha

    public KColor(int red, int green, int blue, int alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public KColor(int rgba) {
        this.red = rgba & 0x00FF0000 >> 16;
        this.green = rgba & 0x0000FF00 >> 8;
        this.blue = rgba & 0x000000FF;
        this.alpha = rgba & 0xFF000000 >> 24;
    }



    public void multiply(KColor other) {
        if (!other.equals(KColor.White)) {
            this.red = (this.red * other.red) / 255;
            this.green = (this.green * other.green) / 255;
            this.blue = (this.blue * other.blue) / 255;
            this.alpha = (this.alpha * other.alpha) / 255;
        }
    }

    public int getConvertedToInt() {
        return this.alpha << 24 | this.red << 16 | this.green << 8 | this.blue;
    }

    public Color getConvertedToAWTColor() {
        return new Color(this.red, this.green, this.blue, this.alpha);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KColor kColor = (KColor) o;
        return red == kColor.red && green == kColor.green && blue == kColor.blue && alpha == kColor.alpha;
    }

    @Override
    public int hashCode() {
        return Objects.hash(red, green, blue, alpha);
    }

}
