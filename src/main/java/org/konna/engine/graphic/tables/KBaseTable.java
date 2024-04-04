package org.konna.engine.graphic.tables;

import org.konna.engine.common.except.KNotFoundException;
import org.konna.engine.graphic.render.KRenderUnit;

import java.awt.image.BufferedImage;

public abstract class KBaseTable {
    public abstract BufferedImage getRendered(KRenderUnit unit) throws KNotFoundException;
}
