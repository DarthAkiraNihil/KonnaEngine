package org.konna.engine.graphic.render;

import org.konna.engine.common.except.KNotFoundException;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class KBaseRenderer {

    protected abstract BufferedImage renderOne(KRenderUnit unit) throws KNotFoundException;
    public abstract ArrayList<BufferedImage> render(KRenderInfo info);

}
