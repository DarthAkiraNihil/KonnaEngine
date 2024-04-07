package org.konna.engine.graphic.render;

import org.konna.engine.common.except.KIllegalArgumentException;
import org.konna.engine.graphic.text.KFont;
import org.konna.engine.graphic.text.KText;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

public class KTextRenderer implements KBaseRenderer{

    protected HashMap<String, KFont> fontDatabase;

    public KTextRenderer() {
        this.fontDatabase = new HashMap<>();
    }

    public void addFont(KFont font) {
        this.fontDatabase.put(font.getName(), font);
    }

    public void addFonts(ArrayList<KFont> fonts) {
        for (KFont font: fonts) {
            this.addFont(font);
        }
    }

    @Override
    public ArrayList<BufferedImage> render(KRenderUnit unit){
        KText text = unit.text;

        if (text == null) {
            throw new KIllegalArgumentException("Invalid unit has been passed: the text is null!");
        } else {
            return this.fontDatabase.get(text.getFont()).render(text);
        }

    }

}
