package kr.dogfoot.hwpxlib.object.common.baseobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;

public abstract class HasOnlyText<ChildType> extends HWPXObject {
    private String text;

    public String text() {
        return text;
    }

    public void text(String text) {
        this.text = text;
    }

    public ChildType textAnd(String text) {
        this.text = text;
        return (ChildType) this;
    }
}

