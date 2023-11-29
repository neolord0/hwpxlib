package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class FormCharPr extends HWPXObject {
    /**
     * 글자 모양 아이디 참조값
     */
    private String charPrIDRef;
    /**
     * 양식 개체가 주변의 글자 속성을 따를 건지 여부
     */
    private Boolean followContext;
    /**
     * 자동 크기 조절 여부
     */
    private Boolean autoSz;
    /**
     * 줄 내림 여부
     */
    private Boolean wordWrap;

    public FormCharPr() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_formCharPr;
    }

    public String charPrIDRef() {
        return charPrIDRef;
    }

    public void charPrIDRef(String charPrIDRef) {
        this.charPrIDRef = charPrIDRef;
    }

    public FormCharPr charPrIDRefAnd(String charPrIDRef) {
        this.charPrIDRef = charPrIDRef;
        return this;
    }

    public Boolean followContext() {
        return followContext;
    }

    public void followContext(Boolean followContext) {
        this.followContext = followContext;
    }

    public FormCharPr followContextAnd(Boolean followContext) {
        this.followContext = followContext;
        return this;
    }

    public Boolean autoSz() {
        return autoSz;
    }

    public void autoSz(Boolean autoSz) {
        this.autoSz = autoSz;
    }

    public FormCharPr autoSzAnd(Boolean autoSz) {
        this.autoSz = autoSz;
        return this;
    }

    public Boolean wordWrap() {
        return wordWrap;
    }

    public void wordWrap(Boolean wordWrap) {
        this.wordWrap = wordWrap;
    }

    public FormCharPr wordWrapAnd(Boolean wordWrap) {
        this.wordWrap = wordWrap;
        return this;
    }

    @Override
    public FormCharPr clone() {
        FormCharPr cloned = new FormCharPr();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(FormCharPr from) {
        this.charPrIDRef = from.charPrIDRef;
        this.followContext = from.followContext;
        this.autoSz = from.autoSz;
        this.wordWrap = from.wordWrap;
    }
}
