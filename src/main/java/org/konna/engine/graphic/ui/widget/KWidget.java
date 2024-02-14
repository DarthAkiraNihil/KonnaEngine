package org.konna.engine.graphic.ui.widget;

import org.konna.engine.common.KCoordinates;
import org.konna.engine.common.KCoordinates2;
import org.konna.engine.common.KSize;
import org.konna.engine.graphic.semiconsole.KSemiConsoleCanvas;

public abstract class KWidget {
    protected KSemiConsoleCanvas canvas;
    protected KCoordinates2 topLeftCornerCoordinates;
    protected KSize size;

    public KWidget(KCoordinates2 topLeftCornerCoordinates, KSize size) {
        this.canvas = null;
        this.topLeftCornerCoordinates = topLeftCornerCoordinates;
        this.size = size;
    }

    public void connectCanvas(KSemiConsoleCanvas canvas) {
        this.canvas = canvas;
    }
}
