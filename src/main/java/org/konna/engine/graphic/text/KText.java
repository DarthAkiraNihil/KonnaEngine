package org.konna.engine.graphic.text;

import org.konna.engine.common.KSize;

public class KText {

    protected final String content;
    protected final String font;
    protected final KSize size;
    protected final KFontType type;

    public KText(String content, String font, KSize size, KFontType type) {
        this.content = content;
        this.font = font;
        this.size = size;
        this.type = type;
    }

    public String getContent() {
        return this.content;
    }

    public String getFont() {
        return this.font;
    }

    public KSize getSize() {
        return this.size;
    }

    public KFontType getType() {
        return this.type;
    }
}
