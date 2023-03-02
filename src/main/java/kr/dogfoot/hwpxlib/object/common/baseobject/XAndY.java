package kr.dogfoot.hwpxlib.object.common.baseobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class XAndY extends HWPXObject {
    private final ObjectType _objectType;
    private Long x;
    private Long y;

    public XAndY(ObjectType _objectType) {
        this._objectType = _objectType;
    }

    @Override
    public ObjectType _objectType() {
        return _objectType;
    }

    public Long x() {
        return x;
    }

    public void x(Long x) {
        this.x = x;
    }

    public XAndY xAnd(Long x) {
        this.x = x;
        return this;
    }

    public Long y() {
        return y;
    }

    public void y(Long y) {
        this.y = y;
    }

    public XAndY yAnd(Long y) {
        this.y = y;
        return this;
    }
}
