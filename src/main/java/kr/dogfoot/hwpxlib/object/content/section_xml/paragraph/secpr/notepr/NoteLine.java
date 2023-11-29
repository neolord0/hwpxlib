package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType2;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineWidth;

/**
 * 구분선
 */
public class NoteLine extends HWPXObject {
    /**
     * 구분선 길이
     * 0 : 구분선 없음
     * -1 : 5cm
     * -2 : 2cm
     * -3 : 단 너비의 1/3
     * -4 : 단 너비
     * 이외의 값 : 사용자 정의 값, 단위 hwpunit
     */
    private Integer length;
    /**
     * 구분선 종류
     */
    private LineType2 type;
    /**
     * 구분선 굵기
     */
    private LineWidth width;
    /**
     * 구분선 색
     */
    private String color;

    public NoteLine() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_noteLine;
    }

    public Integer length() {
        return length;
    }

    public void length(Integer length) {
        this.length = length;
    }

    public NoteLine lengthAnd(Integer length) {
        this.length = length;
        return this;
    }

    public LineType2 type() {
        return type;
    }

    public void type(LineType2 type) {
        this.type = type;
    }

    public NoteLine typeAnd(LineType2 type) {
        this.type = type;
        return this;
    }

    public LineWidth width() {
        return width;
    }

    public void width(LineWidth width) {
        this.width = width;
    }

    public NoteLine widthAnd(LineWidth width) {
        this.width = width;
        return this;
    }

    public String color() {
        return color;
    }

    public void color(String color) {
        this.color = color;
    }

    public NoteLine colorAnd(String color) {
        this.color = color;
        return this;
    }

    @Override
    public NoteLine clone() {
        NoteLine cloned = new NoteLine();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(NoteLine from) {
        this.length = from.length;
        this.type = from.type;
        this.width = from.width;
        this.color = from.color;
    }
}
