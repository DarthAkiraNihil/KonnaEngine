package org.konna.engine.graphic.semiconsole;

import org.konna.engine.common.KCoordinates;
import org.konna.engine.common.KCoordinates2;
import org.konna.engine.common.KSize;
import org.konna.engine.graphic.KColor;

import java.awt.*;
import java.awt.image.BufferedImage;

public class KSemiConsoleCanvas extends Canvas {

    private final KSize realSize;
    private KColor backgroundColor;
    //private KSemiConsoleOutputMode canvasMode;
    public KSemiConsoleCanvas(KSize realSize, KColor backgroundColor) {
        super();
        this.realSize = realSize;
        this.backgroundColor = backgroundColor;
    }

    @Override
    public void paint(Graphics g) {
        initCanvas(g);
    }

    private void initCanvas(Graphics g) {
        g.setColor(this.backgroundColor.getConvertedToAWTColor());
        g.fillRect(0, 0, this.realSize.w, this.realSize.h);
    }

    public void draw(BufferedImage image, KSemiConsoleOutputMode mode, KCoordinates2 coordinates) {
        Graphics g = this.getGraphics();
        switch (mode) {
            case Grid8x8 -> g.drawImage(image, coordinates.x * 8, coordinates.y * 8, null);
            case Grid12x12 -> g.drawImage(image, coordinates.x * 12, coordinates.y * 12, null);
            case Grid16x16 -> g.drawImage(image, coordinates.x * 16, coordinates.y * 16, null);
            case SinglePixelAccuracy -> g.drawImage(image, coordinates.x, coordinates.y, null);
        }
    }
}
