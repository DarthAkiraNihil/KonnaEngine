package org.konna.engine.graphic.render;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class KRenderMachine {

    protected KUnitRenderer unitRenderer;
    protected KTextRenderer textRenderer;

    public KRenderMachine(KUnitRenderer unitRenderer, KTextRenderer textRenderer) {
        this.unitRenderer = unitRenderer;
        this.textRenderer = textRenderer;
    }

    public ArrayList<BufferedImage> render(KRenderInfo info) {
        ArrayList<BufferedImage> rendered = new ArrayList<>();

        //todo if text and graphic are in one unit

        for (int i = 0; i < info.getUnitCount(); i++) {
            KRenderUnit unit = info.getUnit(i);
            rendered.add(this.unitRenderer.render(unit));
            if (unit.text != null) {
                rendered.add(this.textRenderer.render(unit));
            }
        }

        return rendered;
    }
}
