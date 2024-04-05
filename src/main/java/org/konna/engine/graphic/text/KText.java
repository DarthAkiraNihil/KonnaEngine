package org.konna.engine.graphic.text;

import org.konna.engine.common.KSize;

public class KText {

    protected final String content;
    protected final String font;
    protected final KSize size;
    protected final KTextType type;

    public KText(String content, String font, KSize size, KTextType type) {
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

    public KTextType getType() {
        return this.type;
    }
}
