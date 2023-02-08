package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
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
    public ObjectType objectType() {
        return ObjectType.HiddenComment;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.SubList.equalElementName(name)) {
            return new SubList();
        }
        return null;
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
}
