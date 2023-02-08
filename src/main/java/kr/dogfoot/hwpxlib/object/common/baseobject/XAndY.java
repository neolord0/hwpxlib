package kr.dogfoot.hwpxlib.object.common.baseobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;

public abstract class XAndY<ChildType> extends HWPXObject {
    private Integer x;
    private Integer y;

    public Integer x() {
        return x;
    }

    public void x(Integer x) {
        this.x = x;
    }

    public ChildType xAnd(Integer x) {
        this.x = x;
        return (ChildType) this;
    }

    public Integer y() {
        return y;
    }

    public void y(Integer y) {
        this.y = y;
    }

    public ChildType yAnd(Integer y) {
        this.y = y;
        return (ChildType) this;
    }
}
