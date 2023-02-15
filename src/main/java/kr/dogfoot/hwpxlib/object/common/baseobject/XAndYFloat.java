package kr.dogfoot.hwpxlib.object.common.baseobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;

public abstract class XAndYFloat<ChildType> extends HWPXObject {
    private Float x;
    private Float y;

    public Float x() {
        return x;
    }

    public void x(Float x) {
        this.x = x;
    }

    public ChildType xAnd(Float x) {
        this.x = x;
        return (ChildType) this;
    }

    public Float y() {
        return y;
    }

    public void y(Float y) {
        this.y = y;
    }

    public ChildType yAnd(Float y) {
        this.y = y;
        return (ChildType) this;
    }
}
