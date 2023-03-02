package kr.dogfoot.hwpxlib.object.common.baseobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class WidthAndHeight extends HWPXObject {
    private final ObjectType _objectType;
    private Long width;
    private Long height;

    public WidthAndHeight(ObjectType _objectType) {
        this._objectType = _objectType;
    }

    @Override
    public ObjectType _objectType() {
        return _objectType;
    }

    public Long width() {
        return width;
    }

    public void width(Long width) {
        this.width = width;
    }

    public WidthAndHeight widthAnd(Long width) {
        this.width = width;
        return this;
    }

    public Long height() {
        return height;
    }

    public void height(Long height) {
        this.height = height;
    }

    public WidthAndHeight heightAnd(Long height) {
        this.height = height;
        return this;
    }
}
