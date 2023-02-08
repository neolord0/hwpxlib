package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.FootNoteNumberingType;

/**
 * 번호 매김 방식
 */
public class FootNoteNumbering extends HWPXObject {
    /**
     * 번호 매기기 방식
     */
    private FootNoteNumberingType type;
    /**
     * 새번호
     */
    private Integer newNum;

    public FootNoteNumbering() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.FootNoteNumbering;
    }

    public FootNoteNumberingType type() {
        return type;
    }

    public void type(FootNoteNumberingType type) {
        this.type = type;
    }

    public FootNoteNumbering typeAnd(FootNoteNumberingType type) {
        this.type = type;
        return this;
    }

    public Integer newNum() {
        return newNum;
    }

    public void newNum(Integer newNum) {
        this.newNum = newNum;
    }

    public FootNoteNumbering newNumAnd(Integer newNum) {
        this.newNum = newNum;
        return this;
    }
}
