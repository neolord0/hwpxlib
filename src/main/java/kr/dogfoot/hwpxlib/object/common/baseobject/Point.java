package kr.dogfoot.hwpxlib.object.common.baseobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class Point extends HWPXObject {
    private final ObjectType objectType;
    private Integer x;
    private Integer y;

    public Point() {
        objectType = ObjectType.Pt;
    }

    public Point(ObjectType objectType) {
        this.objectType = objectType;
    }

    @Override
    public ObjectType objectType() {
        return objectType;
    }


    public Integer x() {
        return x;
    }

    public void x(Integer x) {
        this.x = x;
    }

    public Point xAnd(Integer x) {
        this.x = x;
        return this;
    }

    public Integer y() {
        return y;
    }

    public void y(Integer y) {
        this.y = y;
    }

    public Point yAnd(Integer y) {
        this.y = y;
        return this;
    }

}
