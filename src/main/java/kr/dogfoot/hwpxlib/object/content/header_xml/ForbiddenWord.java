package kr.dogfoot.hwpxlib.object.content.header_xml;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 금칙어
 */
public class ForbiddenWord extends HWPXObject {
    private final StringBuffer buffer;

    public ForbiddenWord() {
        buffer = new StringBuffer();
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_forbiddenWord;
    }

    public String text() {
        return buffer.toString();
    }

    public void addText(String text) {
        buffer.append(text);
    }

    public ForbiddenWord addTextAnd(String text) {
        buffer.append(text);
        return this;
    }

    @Override
    public ForbiddenWord clone() {
        ForbiddenWord cloned = new ForbiddenWord();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(ForbiddenWord from) {
        addText(from.text());
    }
}
