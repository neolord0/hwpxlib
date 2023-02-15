package kr.dogfoot.hwpxlib.object.dochistory;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class BodyDiff extends FilePartDiff<BodyDiff> {
    public BodyDiff() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hhs_bodyDiff;
    }
}
