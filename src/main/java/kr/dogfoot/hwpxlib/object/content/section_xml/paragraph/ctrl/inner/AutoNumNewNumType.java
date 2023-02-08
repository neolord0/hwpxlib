package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.NumType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.CtrlItem;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr.AutoNumFormat;

/**
 * 자동 번호/새 번호
 */
public abstract class AutoNumNewNumType<ChildType> extends CtrlItem {
    /**
     * 번호
     */
    private Integer num;
    /**
     * 번호 종류
     */
    private NumType numType;
    /**
     * 번호 서식
     */
    private AutoNumFormat autoNumFormat;

    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.AutoNumFormat.equalElementName(name)) {
            return new AutoNumFormat();
        }
        return null;
    }

    public Integer num() {
        return num;
    }

    public void num(Integer num) {
        this.num = num;
    }

    public ChildType numAnd(Integer num) {
        this.num = num;
        return (ChildType) this;
    }

    public NumType numType() {
        return numType;
    }

    public void numType(NumType numType) {
        this.numType = numType;
    }

    public ChildType numTypeAnd(NumType numType) {
        this.numType = numType;
        return (ChildType) this;
    }

    public AutoNumFormat autoNumFormat() {
        return autoNumFormat;
    }

    public void createAutoNumFormat() {
        autoNumFormat = new AutoNumFormat();
    }

    public void removeAutoNumFormat() {
        autoNumFormat = null;
    }
}

