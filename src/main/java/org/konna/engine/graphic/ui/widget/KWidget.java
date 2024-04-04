package org.konna.engine.graphic.ui.widget;

import org.konna.engine.common.KVector2;
import org.konna.engine.common.KSize;
import org.konna.engine.graphic.semiconsole.KSemiConsoleCanvas;

public abstract class KWidget {
    protected KSemiConsoleCanvas canvas;
    protected KVector2 topLeftCornerCoordinates;
    protected KSize size;

    public KWidget(KVector2 topLeftCornerCoordinates, KSize size) {
        this.canvas = null;
        this.topLeftCornerCoordinates = topLeftCornerCoordinates;
        this.size = size;
    }

    public void connectCanvas(KSemiConsoleCanvas canvas) {
        this.canvas = canvas;
    }
}
