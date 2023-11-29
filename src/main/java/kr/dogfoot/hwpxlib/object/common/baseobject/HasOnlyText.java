package kr.dogfoot.hwpxlib.object.common.baseobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class HasOnlyText extends HWPXObject {
    private final ObjectType _objectType;
    private final StringBuffer buffer;

    public HasOnlyText(ObjectType _objectType) {
        this._objectType = _objectType;
        buffer = new StringBuffer();
    }

    @Override
    public ObjectType _objectType() {
        return _objectType;
    }

    public String text() {
        return buffer.toString();
    }

    public void addText(String text) {
        buffer.append(text);
    }

    public HasOnlyText addTextAnd(String text) {
        buffer.append(text);
        return this;
    }

    public HasOnlyText clone() {
        HasOnlyText cloned = new HasOnlyText(this._objectType);
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(HasOnlyText from) {
        addText(from.text());
    }
}



