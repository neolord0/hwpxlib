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
    private final ArrayList<ComposeCharPr> charPrList;

    public Compose() {
        charPrList = new ArrayList<ComposeCharPr>();
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
        return charPrList.size();
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

    public int countOfCharPr() {
        return charPrList.size();
    }

    public ComposeCharPr getCharPr(int index) {
        return charPrList.get(index);
    }

    public int getCharPrIndex(ComposeCharPr charPr) {
        int count = charPrList.size();
        for (int index = 0; index < count; index++) {
            if (charPrList.get(index) == charPr) {
                return index;
            }
        }
        return -1;
    }

    public void addCharPr(ComposeCharPr charPr) {
        charPrList.add(charPr);
    }

    public ComposeCharPr addNewCharPr() {
        ComposeCharPr charPr = new ComposeCharPr();
        charPrList.add(charPr);
        return charPr;
    }

    public void insertCharPr(ComposeCharPr charPr, int position) {
        charPrList.add(position, charPr);
    }

    public void removeCharPr(int position) {
        charPrList.remove(position);
    }

    public void removeCharPr(ComposeCharPr charPr) {
        charPrList.remove(charPr);
    }

    public Iterable<ComposeCharPr> charPrs() {
        return charPrList;
    }

    @Override
    public Compose clone() {
        Compose cloned = new Compose();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(Compose from) {
        this.circleType = from.circleType;
        this.charSz = from.charSz;
        this.composeType = from.composeType;
        this.composeText = from.composeText;

        for (ComposeCharPr composeCharPr : from.charPrList) {
            charPrList.add(composeCharPr.clone());
        }

        super.copyFrom(this);
    }
}
