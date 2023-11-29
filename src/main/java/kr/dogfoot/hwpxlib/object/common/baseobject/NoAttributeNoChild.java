package kr.dogfoot.hwpxlib.object.common.baseobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * No Attribute, No Child Object
 */
public class NoAttributeNoChild extends HWPXObject {
    private final ObjectType _objectType;

    public NoAttributeNoChild(ObjectType _objectType) {
        this._objectType = _objectType;
    }

    @Override
    public ObjectType _objectType() {
        return _objectType;
    }

    @Override
    public NoAttributeNoChild clone() {
        NoAttributeNoChild cloned = new NoAttributeNoChild(_objectType);
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(NoAttributeNoChild from) {
        // nothing
    }
}
