package kr.dogfoot.hwpxlib.object.content.header_xml;

import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.TargetProgramSort;

public class CompatibleDocument extends SwitchableObject {
    private TargetProgramSort targetProgram;
    private ObjectList<LayoutCompatibilityItem> layoutCompatibility;

    public CompatibleDocument() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_compatibleDocument;
    }

    public TargetProgramSort targetProgram() {
        return targetProgram;
    }

    public void targetProgram(TargetProgramSort targetProgram) {
        this.targetProgram = targetProgram;
    }

    public CompatibleDocument targetProgramAnd(TargetProgramSort targetProgram) {
        this.targetProgram = targetProgram;
        return this;
    }

    public ObjectList<LayoutCompatibilityItem> layoutCompatibility() {
        return layoutCompatibility;
    }

    public void createLayoutCompatibility() {
        layoutCompatibility = new ObjectList<LayoutCompatibilityItem>(ObjectType.hh_layoutCompatibility, LayoutCompatibilityItem.class);
    }

    public void removeLayoutCompatibility() {
        layoutCompatibility = null;
    }
}
