package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.NumberType1;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.PageNumPosition;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.CtrlItem;

/**
 * 쪽 번호 위치
 */
public class PageNum extends CtrlItem {
    /**
     * 위치
     */
    private PageNumPosition pos;
    /**
     * 숫자 형식
     */
    private NumberType1 formatType;
    /**
     * 줖표 문자, 양쪽에 붙는 문
     */
    private String sideChar;

    public PageNum() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.PageNum;
    }

    public PageNumPosition pos() {
        return pos;
    }

    public void pos(PageNumPosition pos) {
        this.pos = pos;
    }

    public PageNum posAnd(PageNumPosition pos) {
        this.pos = pos;
        return this;
    }

    public NumberType1 formatType() {
        return formatType;
    }

    public void formatType(NumberType1 formatType) {
        this.formatType = formatType;
    }

    public PageNum formatTypeAnd(NumberType1 formatType) {
        this.formatType = formatType;
        return this;
    }

    public String sideChar() {
        return sideChar;
    }

    public void sideChar(String sideChar) {
        this.sideChar = sideChar;
    }

    public PageNum sideCharAnd(String sideChar) {
        this.sideChar = sideChar;
        return this;
    }
}
