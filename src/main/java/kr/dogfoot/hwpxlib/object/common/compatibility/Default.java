package kr.dogfoot.hwpxlib.object.common.compatibility;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class Default extends InSwitchObject {
    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_default;
    }

    @Override
    public Default clone() {
        Default cloned = new Default();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(Default from) {
        super.copyForm(from);
    }
}
