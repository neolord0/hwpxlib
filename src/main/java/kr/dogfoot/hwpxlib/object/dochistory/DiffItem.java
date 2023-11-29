package kr.dogfoot.hwpxlib.object.dochistory;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;

public abstract class DiffItem<ChildType> extends SwitchableObject {
    private String path;
    private ObjectType filePartDiffType;

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

    public ObjectType filePartDiffType() {
        return filePartDiffType;
    }

    public void filePartDiffType(ObjectType filePartDiffType) {
        this.filePartDiffType = filePartDiffType;
    }

    public ChildType filePartDiffTypeAnd(ObjectType filePartDiffType) {
        this.filePartDiffType = filePartDiffType;
        return (ChildType) this;
    }

    protected void copyFrom(DiffItem from) {
        this.path = from.path;
        this.filePartDiffType = from.filePartDiffType;

        super.copyFrom(from);
    }
}
