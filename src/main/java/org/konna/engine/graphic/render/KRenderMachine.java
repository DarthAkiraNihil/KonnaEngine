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

        if (info.getUnitCount() != 0) {
            rendered.addAll(this.unitRenderer.render(info));
        }
        if (info.getText() != null) {
            rendered.addAll(this.textRenderer.render(info));
        }

        return rendered;
    }
}
