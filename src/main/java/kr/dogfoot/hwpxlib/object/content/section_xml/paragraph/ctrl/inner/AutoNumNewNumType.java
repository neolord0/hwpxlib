package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner;

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
    private kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.NumType numType;
    /**
     * 번호 서식
     */
    private AutoNumFormat autoNumFormat;

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

    public kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.NumType numType() {
        return numType;
    }

    public void numType(kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.NumType numType) {
        this.numType = numType;
    }

    public ChildType numTypeAnd(kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.NumType numType) {
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

