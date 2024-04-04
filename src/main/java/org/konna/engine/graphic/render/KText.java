package org.konna.engine.graphic.render;

import org.konna.engine.common.KSize;

public class KText {

    protected final String content;
    protected final String font;
    protected final KSize size;

    public KText(String content, String font, KSize size) {
        this.content = content;
        this.font = font;
        this.size = size;
    }

    public String getContent() {
        return content;
    }

    public String getFont() {
        return font;
    }

    public KSize getSize() {
        return size;
    }
}
