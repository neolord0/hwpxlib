package kr.dogfoot.hwpxlib.object.dochistory;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;

public abstract class DiffItem<ChildType> extends SwitchableObject {
    private String path;


    public String path() {
        return path;
    }

    public void path(String path) {
        this.path = path;
    }

    public ChildType pathAnd(String path) {
        this.path = path;
        return (ChildType) this;
    }
}
