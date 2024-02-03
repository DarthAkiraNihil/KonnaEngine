package org.konna.engine.graphic.semiconsole;

import org.konna.engine.common.KSize;
import org.konna.engine.common.event.KBaseEventDispatcher;
import org.konna.engine.common.event.KEventListener;
import org.konna.engine.common.except.KGraphicException;
import org.konna.engine.graphic.KColor;
import org.konna.engine.graphic.KRenderUnitList;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class KSemiConsole extends Frame implements KEventListener, KeyListener, WindowListener {
    private KRenderUnitList semiConsoleRenderUnitList;
    private KBaseEventDispatcher eventDispatcher;
    private Canvas semiConsoleCanvas;

    public KSemiConsole(String pathToRenderUnitTable) throws KGraphicException {
        super("TEST TEST TEST TEST TEST");
        this.semiConsoleRenderUnitList = new KRenderUnitList(pathToRenderUnitTable, new KSize(16,16));
        this.setSize(200, 200);
        this.addKeyListener(this);
        this.addWindowListener(this);
        this.semiConsoleCanvas = new Canvas() {
            @Override
            public void paint(Graphics g) {
                g.setColor(new Color(0, 0, 0));
                g.drawRect(0, 0, 200, 200);
                g.fillRect(0, 0, 200, 200);
                g.drawImage(semiConsoleRenderUnitList.getUnit(2, new KColor(0, 0, 200, 0)), 20, 20, 16, 16, this);
            }
        };
        this.semiConsoleCanvas.setSize(200, 200);

        //this.dispatcher.subscribeEvent("onKeyPressed", this::onBP);

        this.add(this.semiConsoleCanvas);

        //this.semiConsoleCanvas.getGraphics().
        this.setVisible(true);
        //

        //this.canvas.paint();


    }

    @Override
    public void setEventDispatcher(KBaseEventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }


    @Override
    public void keyTyped(KeyEvent e) {
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
