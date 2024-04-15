package org.example;

import org.konna.engine.common.KVector2;
import org.konna.engine.graphic.KColor;
import org.konna.engine.graphic.render.KRenderInfo;
import org.konna.engine.graphic.render.KRenderUnit;
import org.konna.engine.graphic.render.KRenderable;

public class TestRenderable implements KRenderable {

    @Override
    public KRenderInfo getRenderInfo() {
        KRenderInfo renderInfo = new KRenderInfo();
        renderInfo.addUnit(new KRenderUnit(
            4,
            KColor.White,
            new KVector2(2, 2)
        ));
        renderInfo.addUnit(new KRenderUnit(
            4,
            KColor.White,
            new KVector2(2, 3)
        ));
        renderInfo.addUnit(new KRenderUnit(
            4,
            KColor.White,
            new KVector2(2, 4)
        ));
        renderInfo.addUnit(new KRenderUnit(
            4,
            KColor.White,
            new KVector2(2, 5)
        ));
        renderInfo.addUnit(new KRenderUnit(
            5,
            KColor.White,
            new KVector2(3, 2)
        ));
        renderInfo.addUnit(new KRenderUnit(
            5,
            KColor.White,
            new KVector2(1, 2)
        ));
        return renderInfo;
    }
}
