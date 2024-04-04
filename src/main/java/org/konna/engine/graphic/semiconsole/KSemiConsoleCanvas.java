package org.konna.engine.graphic.semiconsole;

import org.konna.engine.common.KVector2;
import org.konna.engine.common.KSize;
import org.konna.engine.graphic.KColor;
import org.konna.engine.graphic.render.KRenderInfo;
import org.konna.engine.graphic.render.KRenderable;
import org.konna.engine.graphic.render.KUnitRenderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class KSemiConsoleCanvas extends Canvas {

    protected final KSize realSize;
    protected KColor backgroundColor;
    protected KUnitRenderer canvasRenderer;
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

    public void draw(BufferedImage image, KSemiConsoleOutputMode mode, KVector2 coordinates) {
        Graphics g = this.getGraphics();
        switch (mode) {
            case Grid8x8 -> g.drawImage(image, coordinates.x * 8, coordinates.y * 8, null);
            case Grid12x12 -> g.drawImage(image, coordinates.x * 12, coordinates.y * 12, null);
            case Grid16x16 -> g.drawImage(image, coordinates.x * 16, coordinates.y * 16, null);
            case SinglePixelAccuracy -> g.drawImage(image, coordinates.x, coordinates.y, null);
        }
    }

    public void render(KRenderable renderable, KVector2 coordinates) {
        KRenderInfo info = renderable.getRenderInfo();
        ArrayList<BufferedImage> rendered = this.canvasRenderer.render(renderable);
        for (int i = 0; i < info.getUnitCount(); i++) {
            KVector2 insertPlace = info.getUnit(i).coordinates;
            insertPlace.add(coordinates);
            this.draw(
                rendered.get(i),
                KSemiConsoleOutputMode.Grid16x16,
                insertPlace
            );
        }
    }
}
