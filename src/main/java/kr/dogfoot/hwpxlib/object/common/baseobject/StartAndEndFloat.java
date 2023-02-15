package kr.dogfoot.hwpxlib.object.common.baseobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;

public abstract class StartAndEndFloat<ChildType> extends HWPXObject {
    private Float start;
    private Float end;

    public Float start() {
        return start;
    }

    public void start(Float start) {
        this.start = start;
    }

    public ChildType startAnd(Float start) {
        this.start = start;
        return (ChildType) this;
    }

    public Float end() {
        return end;
    }

    public void end(Float end) {
        this.end = end;
    }

    public ChildType endAnd(Float end) {
        this.end = end;
        return (ChildType) this;
    }
}
