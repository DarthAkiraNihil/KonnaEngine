package org.konna.engine.graphic.render;

import org.konna.engine.common.except.KNotFoundException;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public interface KBaseRenderer {

    //protected abstract BufferedImage renderOne(KRenderUnit unit) throws KNotFoundException;
    ArrayList<BufferedImage> render(KRenderInfo info);

}
