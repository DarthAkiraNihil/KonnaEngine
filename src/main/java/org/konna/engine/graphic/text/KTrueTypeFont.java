package org.konna.engine.graphic.text;

import org.konna.engine.common.except.KNotFoundException;
import org.konna.engine.common.except.KNotImplementedException;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class KTrueTypeFont extends KFont{

    protected final Font fontFace;
    protected int size;

    public KTrueTypeFont(String name, String sourceFile) throws KNotFoundException{
        super(name, KFontType.TTF);
        try {
            this.fontFace = Font.createFont(Font.TRUETYPE_FONT, new File(sourceFile));
        } catch (Exception e) { // Personally I don't like this
            throw new KNotFoundException(e);
        }
    }

    public void setSize(int size) {
        this.size = size;
    }

    //TODO add color and something to ktext
    @Override
    public BufferedImage render(KText text) {

       throw new KNotImplementedException("No text?");

        /*
        TODO
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        Font font = new Font("Arial", Font.PLAIN, 48);
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        int width = fm.stringWidth(text);
        int height = fm.getHeight();
        g2d.dispose();

        renderResult.add(img);

         */


    }
}
