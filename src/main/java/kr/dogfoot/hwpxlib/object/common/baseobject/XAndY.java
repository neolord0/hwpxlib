package kr.dogfoot.hwpxlib.object.common.baseobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;

public abstract class XAndY<ChildType> extends HWPXObject {
    private Long x;
    private Long y;

    public Long x() {
        return x;
    }

    public void x(Long x) {
        this.x = x;
    }

    public ChildType xAnd(Long x) {
        this.x = x;
        return (ChildType) this;
    }

    public Long y() {
        return y;
    }

    public void y(Long y) {
        this.y = y;
    }

    public ChildType yAnd(Long y) {
        this.y = y;
        return (ChildType) this;
    }
}
