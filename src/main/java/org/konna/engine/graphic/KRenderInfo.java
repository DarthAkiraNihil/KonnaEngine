package org.konna.engine.graphic;

import java.util.ArrayList;

public class KRenderInfo {
    private ArrayList<KRenderUnit> renderUnits;
    public KRenderInfo() {
        this.renderUnits = new ArrayList<>();
    }

    public void addUnit(KRenderUnit unit) {
        this.renderUnits.add(unit);
    }

    public void addUnits(KRenderInfo info) {
        for (int i = 0; i < info.getUnitCount(); i++) {
            this.addUnit(info.getUnit(i));
        }
    }

    public int getUnitCount() {
        return this.renderUnits.size();
    }

    public KRenderUnit getUnit(int index) {
        return this.renderUnits.get(index);
    }
}
