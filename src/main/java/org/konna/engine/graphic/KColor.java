package org.konna.engine.graphic;

public class KColor {
    public int red, green, blue, alpha;

    public KColor(int red, int green, int blue, int alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public KColor(int rgba) {
        this.red = rgba & 0x00FF0000;
        this.green = rgba & 0x0000FF00;
        this.blue = rgba & 0x000000FF;
        this.alpha = rgba & 0xFF000000; //fix if incorrect colors //TODO FIX COLOR CONVERSION FORMULAS
    }

    public void multiply(KColor other) {
        this.red = (this.red * other.red) / 255;
        this.green = (this.green * other.green) / 255;
        this.blue = (this.blue * other.blue) / 255;
        this.alpha = (this.alpha * other.alpha) / 255;
    }

    public int getConvertedToInt() {
        return (((alpha * 255) + red) * 255 + green) * 255 + blue; //fix if corrupted
    }

}
