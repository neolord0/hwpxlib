package kr.dogfoot.hwpxlib.object.dochistory;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class PackageDiff extends FilePartDiff<PackageDiff> {
    public PackageDiff() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.PackageDiff;
    }
}
