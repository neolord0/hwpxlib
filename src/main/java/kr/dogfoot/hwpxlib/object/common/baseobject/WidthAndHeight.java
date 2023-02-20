package kr.dogfoot.hwpxlib.object.common.baseobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;

public abstract class WidthAndHeight<ChildType> extends HWPXObject {
    private Long width;
    private Long height;

    public Long width() {
        return width;
    }

    public void width(Long width) {
        this.width = width;
    }

    public ChildType widthAnd(Long width) {
        this.width = width;
        return (ChildType) this;
    }

    public Long height() {
        return height;
    }

    public void height(Long height) {
        this.height = height;
    }

    public ChildType heightAnd(Long height) {
        this.height = height;
        return (ChildType) this;
    }
}
