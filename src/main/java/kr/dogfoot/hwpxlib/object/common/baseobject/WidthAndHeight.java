package kr.dogfoot.hwpxlib.object.common.baseobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;

public abstract class WidthAndHeight<ChildType> extends HWPXObject {
    private Integer width;
    private Integer height;

    public Integer width() {
        return width;
    }

    public void width(Integer width) {
        this.width = width;
    }

    public ChildType widthAnd(Integer width) {
        this.width = width;
        return (ChildType) this;
    }

    public Integer height() {
        return height;
    }

    public void height(Integer height) {
        this.height = height;
    }

    public ChildType heightAnd(Integer height) {
        this.height = height;
        return (ChildType) this;
    }
}
