package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.SubList;

public class DrawText extends SwitchableObject {
    /**
     * 텍스트 문자열의 최대 폭, 단위는 hwpunit
     */
    private Integer lastWidth;
    /**
     * 필드명
     */
    private String name;
    /**
     * 편집 가능 여부
     */
    private Boolean editable;
    /**
     * 여백
     */
    private TextMargin textMargin;
    /**
     * 내부 문단 리스트
     */
    private SubList subList;

    public DrawText() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.DrawText;
    }

    public Integer lastWidth() {
        return lastWidth;
    }

    public void lastWidth(Integer lastWidth) {
        this.lastWidth = lastWidth;
    }

    public DrawText lastWidthAnd(Integer lastWidth) {
        this.lastWidth = lastWidth;
        return this;
    }

    public String name() {
        return name;
    }

    public void name(String name) {
        this.name = name;
    }

    public DrawText nameAnd(String name) {
        this.name = name;
        return this;
    }

    public Boolean editable() {
        return editable;
    }

    public void editable(Boolean editable) {
        this.editable = editable;
    }

    public DrawText editableAnd(Boolean editable) {
        this.editable = editable;
        return this;
    }

    public TextMargin textMargin() {
        return textMargin;
    }

    public void createTextMargin() {
        textMargin = new TextMargin();
    }

    public void removeTextMargin() {
        textMargin = null;
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
