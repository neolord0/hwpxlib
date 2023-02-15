package kr.dogfoot.hwpxlib.object.common.baseobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;

public abstract class HasOnlyText<ChildType> extends HWPXObject {
    private StringBuffer buffer = new StringBuffer();

    public String text() {
        return buffer.toString();
    }

    public void addText(String text) {
        buffer.append(text);
    }

    public ChildType addTextAnd(String text) {
        buffer.append(text);
        return (ChildType) this;
    }
}

