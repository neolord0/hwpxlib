package kr.dogfoot.hwpxlib.object.dochistory;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class BodyDiff extends FilePartDiff<BodyDiff> {
    public BodyDiff() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.BodyDiff;
    }
}
