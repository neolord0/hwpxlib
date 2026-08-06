package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 형광펜 끝
 */
public class MarkpenEndForRun extends RunItem {
    public MarkpenEndForRun() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_markpenEnd;
    }

    @Override
    public MarkpenEndForRun clone() {
        MarkpenEndForRun cloned = new MarkpenEndForRun();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(MarkpenEndForRun from) {
        // nothing
    }
}
