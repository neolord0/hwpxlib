package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ComposeCircleType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ComposeType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.compose.ComposeCharPr;

import java.util.ArrayList;

/**
 * 글자 겹침
 */
public class Compose extends RunItem {
    /**
     * 테두리 형식
     */
    private ComposeCircleType circleType;
    /**
     * 테두리 내부 글자의 크기 비율, 단위는 10%
     */
    private Short charSz;
    /**
     * 겹치기 종류
     */
    private ComposeType composeType;
    /**
     * 겹쳐지는 글자들
     */
    private String composeText;
    /**
     * 글자모양 ID 참조값 리스트
     */
    private final ArrayList<ComposeCharPr> charPrRefList;

    public Compose() {
        charPrRefList = new ArrayList<ComposeCharPr>();
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_compose;
    }

    public ComposeCircleType circleType() {
        return circleType;
    }

    public void circleType(ComposeCircleType circleType) {
        this.circleType = circleType;
    }

    public Compose circleTypeAnd(ComposeCircleType circleType) {
        this.circleType = circleType;
        return this;
    }

    public Short charSz() {
        return charSz;
    }

    public void charSz(Short charSz) {
        this.charSz = charSz;
    }

    public Compose charSzAnd(Short charSz) {
        this.charSz = charSz;
        return this;
    }

    public ComposeType composeType() {
        return composeType;
    }

    public void composeType(ComposeType composeType) {
        this.composeType = composeType;
    }

    public Compose composeTypeAnd(ComposeType composeType) {
        this.composeType = composeType;
        return this;
    }

    public int charPrCnt() {
        return charPrRefList.size();
    }

    public String composeText() {
        return composeText;
    }

    public void composeText(String composeText) {
        this.composeText = composeText;
    }

    public Compose composeTextAnd(String composeText) {
        this.composeText = composeText;
        return this;
    }

    public int countOfCharPrRef() {
        return charPrRefList.size();
    }

    public ComposeCharPr getCharPrRef(int index) {
        return charPrRefList.get(index);
    }

    public void addCharPrRef(ComposeCharPr charPrRef) {
        charPrRefList.add(charPrRef);
    }

    public ComposeCharPr addNewCharPrRef() {
        ComposeCharPr charPrRef = new ComposeCharPr();
        charPrRefList.add(charPrRef);
        return charPrRef;
    }

    public void insertCharPrRef(ComposeCharPr charPrRef, int position) {
        charPrRefList.add(position, charPrRef);
    }

    public void removeCharPrRef(int position) {
        charPrRefList.remove(position);
    }

    public Iterable<ComposeCharPr> charPrRefs() {
        return charPrRefList;
    }
}
