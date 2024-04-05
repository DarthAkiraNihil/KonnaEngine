package org.konna.engine.graphic.render;

import org.konna.engine.graphic.text.KText;

import java.util.ArrayList;

public class KRenderInfo {
    private ArrayList<KRenderUnit> renderUnits;
    private KText text;
    public KRenderInfo() {
        this.renderUnits = null;
        this.text = null;
    }

    public void addUnit(KRenderUnit unit) {
        if (this.renderUnits == null) {
            this.renderUnits = new ArrayList<>();
        }
        this.renderUnits.add(unit);
    }

    public void packText(KText text) {
        this.text = text;
    }

    public void addUnits(KRenderInfo info) {
        for (int i = 0; i < info.getUnitCount(); i++) {
            this.addUnit(info.getUnit(i));
        }
    }

    public int getUnitCount() {
        if (this.renderUnits == null) {
            return 0;
        } else {
            return this.renderUnits.size();
        }
    }

    public KRenderUnit getUnit(int index) {
        return this.renderUnits.get(index);
    }

    public KText getText() {
        return text;
    }
}
