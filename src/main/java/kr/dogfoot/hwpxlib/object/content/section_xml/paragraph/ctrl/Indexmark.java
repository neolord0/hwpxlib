package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.CtrlItem;

/**
 * 인덱스
 */
public class Indexmark extends CtrlItem {
    /**
     * 키
     */
    private HasOnlyText firstKey;
    /**
     * 두번째 키
     */
    private HasOnlyText secondKey;

    public Indexmark() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_indexmark;
    }

    public HasOnlyText firstKey() {
        return firstKey;
    }

    public void createFirstKey() {
        firstKey = new HasOnlyText(ObjectType.hp_firstKey);
    }

    public void removeFirstKey() {
        firstKey = null;
    }

    public HasOnlyText secondKey() {
        return secondKey;
    }

    public void createSecondKey() {
        secondKey = new HasOnlyText(ObjectType.hp_secondKey);
    }

    public void removeSecondKey() {
        secondKey = null;
    }
}
