package kr.dogfoot.hwpxlib.object.common.parameter;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;

public abstract class Param<ChildType> extends SwitchableObject {
    private String name;

    public String name() {
        return name;
    }

    public void name(String name) {
        this.name = name;
    }

    public ChildType nameAnd(String name) {
        this.name = name;
        return (ChildType) this;
    }

    public void copyFrom(Param from) {
        this.name = from.name;

        super.copyFrom(this);
    }
}
