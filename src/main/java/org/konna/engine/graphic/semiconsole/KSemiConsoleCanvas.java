package org.konna.engine.graphic.semiconsole;

import org.example.TestRenderable;
import org.konna.engine.common.KVector2;
import org.konna.engine.common.KSize;
import org.konna.engine.graphic.KColor;
import org.konna.engine.graphic.render.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class KSemiConsoleCanvas extends Canvas {

    protected final KSize realSize;
    protected KColor backgroundColor;
    protected KRenderMachine renderMachine;
    protected ArrayList<KRenderInfo> activei;
    protected ArrayList<KVector2> activec;
    protected TestRenderable test;
    //private KSemiConsoleOutputMode canvasMode;
    public KSemiConsoleCanvas(KSize realSize, KColor backgroundColor, KRenderMachine renderMachine) {
        super();
        this.realSize = realSize;
        this.backgroundColor = backgroundColor;
        this.renderMachine = renderMachine;
        this.activei = new ArrayList<>();
        this.activec = new ArrayList<>();
        this.test = new TestRenderable();
    }

    @Override
    public void paint(Graphics g) {
        //super.paint(g);
        initCanvas(g);
        //System.out.println("...and then it is fucking gone");
        //this.render(this.test, new KVector2(1, 2));
        //System.out.println("...so I've drawn it again");
    }


    private void initCanvas(Graphics g) {
        //for (KRenderInfo act: this.active) {
            //this.render();
        //}
        //this.setBackground(this.backgroundColor.getConvertedToAWTColor());
        g.setColor(this.backgroundColor.getConvertedToAWTColor());
        g.fillRect(0, 0, this.realSize.w, this.realSize.h);

        //g.drawImage(this.renderMachine.render())
    }

    //todo make private
    public void draw(BufferedImage image, KSemiConsoleOutputMode mode, KVector2 coordinates, Graphics g) {
        //Graphics g = this.getGraphics();
        switch (mode) {
            case Grid8x8 -> g.drawImage(image, coordinates.x * 8, coordinates.y * 8, null);
            case Grid12x12 -> g.drawImage(image, coordinates.x * 12, coordinates.y * 12, null);
            case Grid16x16 -> g.drawImage(image, coordinates.x * 16, coordinates.y * 16, this);
            case SinglePixelAccuracy -> g.drawImage(image, coordinates.x, coordinates.y, null);
        }
    }

    public void render(KRenderable renderable, KVector2 coordinates) {
        KRenderInfo info = renderable.getRenderInfo();
        ArrayList<BufferedImage> rendered = this.renderMachine.render(info);
        Graphics2D g = (Graphics2D) this.getGraphics();
        this.initCanvas(g);
        for (int i = 0; i < info.getUnitCount(); i++) {
            KVector2 insertPlace = info.getUnit(i).coordinates;
            insertPlace.add(coordinates);
            this.draw(
                rendered.get(i),
                KSemiConsoleOutputMode.Grid16x16,
                insertPlace,
                g
            );

            System.out.println("I've drawn an image");
        }
        g.dispose();
    }
}
