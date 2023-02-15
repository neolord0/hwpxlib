package kr.dogfoot.hwpxlib.object.dochistory;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class HeadDiff extends FilePartDiff<HeadDiff> {
    public HeadDiff() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hhs_headDiff;
    }
}
