package kr.dogfoot.hwpxlib.object.common.baseobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class Point extends XAndY<Point> {
    private final ObjectType objectType;

    public Point() {
        objectType = ObjectType.hc_pt;
    }

    public Point(ObjectType objectType) {
        this.objectType = objectType;
    }

    @Override
    public ObjectType _objectType() {
        return objectType;
    }
}
