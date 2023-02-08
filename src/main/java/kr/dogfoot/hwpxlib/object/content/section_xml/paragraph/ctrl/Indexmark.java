package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.CtrlItem;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.FirstKey;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.SecondKey;

/**
 * 인덱스
 */
public class Indexmark extends CtrlItem {
    /**
     * 키
     */
    private FirstKey firstKey;
    /**
     * 두번째 키
     */
    private SecondKey secondKey;

    public Indexmark() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Indexmark;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.FirstKey.equalElementName(name)) {
            return new FirstKey();
        } else if (ObjectType.SecondKey.equalElementName(name)) {
            return new SecondKey();
        }
        return null;
    }

    public HasOnlyText firstKey() {
        return firstKey;
    }

    public void createFirstKey() {
        firstKey = new FirstKey();
    }

    public void removeFirstKey() {
        firstKey = null;
    }

    public HasOnlyText secondKey() {
        return secondKey;
    }

    public void createSecondKey() {
        secondKey = new SecondKey();
    }

    public void removeSecondKey() {
        secondKey = null;
    }

}
