package org.konna.engine.graphic.render.renderers;

import org.konna.engine.common.KCoordinates2;
import org.konna.engine.graphic.render.KRenderable;
import org.konna.engine.graphic.semiconsole.KSemiConsoleCanvas;

public abstract class KBaseRenderer {
    //private KSemiConsoleCanvas canvas;

    public abstract void render(KSemiConsoleCanvas canvas, KRenderable renderable, KCoordinates2 at);
}
