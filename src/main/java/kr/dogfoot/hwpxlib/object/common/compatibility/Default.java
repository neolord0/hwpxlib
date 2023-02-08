package kr.dogfoot.hwpxlib.object.common.compatibility;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class Default extends InSwitchObject {
    @Override
    public ObjectType objectType() {
        return ObjectType.Default;
    }
}
