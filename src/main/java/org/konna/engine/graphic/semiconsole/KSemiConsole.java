package org.konna.engine.graphic.semiconsole;

import org.example.TestRenderable;
import org.konna.engine.common.KSize;
import org.konna.engine.common.KVector2;
import org.konna.engine.common.event.KBaseEventDispatcher;
import org.konna.engine.common.event.KEventListener;
import org.konna.engine.common.except.KGraphicException;
import org.konna.engine.graphic.KColor;
import org.konna.engine.graphic.render.KRenderMachine;
import org.konna.engine.graphic.render.KRenderUnitList;
import org.konna.engine.graphic.render.KRenderable;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

public class KSemiConsole extends Frame implements KEventListener, KeyListener, WindowListener {
    //private final KRenderUnitList semiConsoleRenderUnitList;
    private KBaseEventDispatcher eventDispatcher;
    private final KSemiConsoleCanvas semiConsoleCanvas;
    private final TestRenderable test;

    //TEST TEST TEST
    private int o = 0;

    public KSemiConsole(KRenderMachine renderMachine) throws KGraphicException {
        super("TEST TEST TEST TEST TEST");
        this.test = new TestRenderable();
        //this.semiConsoleRenderUnitList = new KRenderUnitList(pathToRenderUnitTable, new KSize(16,16));
        this.setSize(200, 200);
        this.addKeyListener(this);
        this.addWindowListener(this);
        this.semiConsoleCanvas = new KSemiConsoleCanvas(
            new KSize(200, 200),
            new KColor(0, 0, 0, 255),
            renderMachine

        );
//        this.semiConsoleCanvas = new Canvas() {
//            @Override
//            public void paint(Graphics g) {
//                g.setColor(new Color(0, 0, 0));
//                //g.drawRect(0, 0, 200, 200);
//                g.fillRect(0, 0, 200, 200);
//                g.drawImage(semiConsoleRenderUnitList.getUnit(2, new KColor(255, 255, 0, 0)), 20, 20, 16, 16, this);
//            }
//        };
        this.semiConsoleCanvas.setSize(200, 200);

        //this.dispatcher.subscribeEvent("onKeyPressed", this::onBP);

        this.add(this.semiConsoleCanvas);

        //this.semiConsoleCanvas.getGraphics().
        this.setVisible(true);
        //

        //this.canvas.paint();


    }

    public void render(KRenderable renderable, KVector2 coordinates) {
        this.semiConsoleCanvas.render(renderable, coordinates);
    }

    @Override
    public void setEventDispatcher(KBaseEventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }


    @Override
    public void keyTyped(KeyEvent e) {
        //this.semiConsoleCanvas.getGraphics().drawImage(semiConsoleRenderUnitList.getUnit(o, new KColor(255, 255, 255, 0)), 20, 20, 16, 16, this);
        o+=1;
        //Graphics2D g = (Graphics2D) this.getGraphics();
        this.semiConsoleCanvas.render(this.test, new KVector2(1, 2));
        //g.dispose();
        //this.dispatcher.invokeEvent("onKeyPressed", e.getKeyChar());
        //System.out.println(e.getKeyChar());
    }


    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void windowOpened(WindowEvent e) {
    }

    public void windowClosing(WindowEvent e) {
        this.dispose();
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }

}
