package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.HorizontalAlign2;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.DutmalPosType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.dutmal.MainText;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.dutmal.SubText;

/**
 * 덧말
 */
public class Dutmal extends RunItem {
    /**
     * 위치
     */
    private DutmalPosType posType;
    /**
     * 덧말 크기 ,단위는 %
     */
    private Integer szRatio;
    /**
     * 덧말 글자의 글자 스타일을 지정하기 위한 속성 ??
     */
    private Integer option;
    /**
     * 글자 스타일 아이디 참조값
     */
    private String styleIDRef;
    /**
     * 정렬 방법
     */
    private HorizontalAlign2 align;
    /**
     * 본 내용
     */
    private MainText mainText;
    /**
     * 덧말
     */
    private SubText subText;

    public Dutmal() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_dutmal;
    }

    public DutmalPosType posType() {
        return posType;
    }

    public void posType(DutmalPosType posType) {
        this.posType = posType;
    }

    public Dutmal posTypeAnd(DutmalPosType posType) {
        this.posType = posType;
        return this;
    }

    public Integer szRatio() {
        return szRatio;
    }

    public void szRatio(Integer szRatio) {
        this.szRatio = szRatio;
    }

    public Dutmal szRatioAnd(Integer szRatio) {
        this.szRatio = szRatio;
        return this;
    }

    public Integer option() {
        return option;
    }

    public void option(Integer option) {
        this.option = option;
    }

    public Dutmal optionAnd(Integer option) {
        this.option = option;
        return this;
    }

    public String styleIDRef() {
        return styleIDRef;
    }

    public void styleIDRef(String styleIDRef) {
        this.styleIDRef = styleIDRef;
    }

    public Dutmal styleIDRefAnd(String styleIDRef) {
        this.styleIDRef = styleIDRef;
        return this;
    }

    public HorizontalAlign2 align() {
        return align;
    }

    public void align(HorizontalAlign2 align) {
        this.align = align;
    }

    public Dutmal alignAnd(HorizontalAlign2 align) {
        this.align = align;
        return this;
    }

    public MainText mainText() {
        return mainText;
    }

    public void createMainText() {
        mainText = new MainText();
    }

    public void removeMainText() {
        mainText = null;
    }

    public SubText subText() {
        return subText;
    }

    public void createSubText() {
        subText = new SubText();
    }

    public void removeSubText() {
        subText = null;
    }
}
