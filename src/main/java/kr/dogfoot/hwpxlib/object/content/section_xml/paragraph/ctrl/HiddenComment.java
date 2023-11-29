package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.SubList;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.CtrlItem;

/**
 * 숨은 주석
 */
public class HiddenComment extends CtrlItem {
    /**
     * 내부 문단 리스트
     */
    private SubList subList;

    public HiddenComment() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_hiddenComment;
    }

    public SubList subList() {
        return subList;
    }

    public void createSubList() {
        subList = new SubList();
    }

    public void removeSubList() {
        subList = null;
    }

    @Override
    public HiddenComment clone() {
        HiddenComment cloned = new HiddenComment();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(HiddenComment from) {
        if (from.subList != null) {
            subList = from.subList.clone();
        } else {
            subList = null;
        }

        super.copyFrom(from);
    }
}
