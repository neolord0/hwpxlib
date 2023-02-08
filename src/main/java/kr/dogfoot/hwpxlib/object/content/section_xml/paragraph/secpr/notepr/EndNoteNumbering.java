package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.EndNoteNumberingType;

/**
 * 번호 매김 방식
 */
public class EndNoteNumbering extends HWPXObject {
    /**
     * 번호 매기기 방식
     */
    private EndNoteNumberingType type;
    /**
     * 새번호
     */
    private Integer newNum;

    public EndNoteNumbering() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.EndNoteNumbering;
    }

    public EndNoteNumberingType type() {
        return type;
    }

    public void type(EndNoteNumberingType type) {
        this.type = type;
    }

    public EndNoteNumbering typeAnd(EndNoteNumberingType type) {
        this.type = type;
        return this;
    }

    public Integer newNum() {
        return newNum;
    }

    public void newNum(Integer newNum) {
        this.newNum = newNum;
    }

    public EndNoteNumbering newNumAnd(Integer newNum) {
        this.newNum = newNum;
        return this;
    }
}
