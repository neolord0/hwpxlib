package kr.dogfoot.hwpxlib.object.common.baseobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class StartAndEndFloat extends HWPXObject {
    private final ObjectType _objectType;
    private Float start;
    private Float end;

    public StartAndEndFloat(ObjectType _objectType) {
        this._objectType = _objectType;
    }

    @Override
    public ObjectType _objectType() {
        return _objectType;
    }

    public Float start() {
        return start;
    }

    public void start(Float start) {
        this.start = start;
    }

    public StartAndEndFloat startAnd(Float start) {
        this.start = start;
        return this;
    }

    public Float end() {
        return end;
    }

    public void end(Float end) {
        this.end = end;
    }

    public StartAndEndFloat endAnd(Float end) {
        this.end = end;
        return this;
    }

    @Override
    public StartAndEndFloat clone() {
        StartAndEndFloat cloned = new StartAndEndFloat(_objectType);
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(StartAndEndFloat from) {
        this.start = from.start;
        this.end = from.end;
    }

}
