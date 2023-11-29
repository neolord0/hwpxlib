package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.LineNumberRestartType;

public class LineNumberShape extends HWPXObject {
    /**
     * 번호 시작 방식
     */
    private LineNumberRestartType restartType;
    /**
     * 번호 간격
     */
    private Integer countBy;
    /**
     * 본문과의 간격
     */
    private Integer distance;
    /**
     * 새 번호
     */
    private Integer startNumber;

    public LineNumberShape() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_lineNumberShape;
    }

    public LineNumberRestartType restartType() {
        return restartType;
    }

    public void restartType(LineNumberRestartType restartType) {
        this.restartType = restartType;
    }

    public LineNumberShape restartTypeAnd(LineNumberRestartType restartType) {
        this.restartType = restartType;
        return this;
    }

    public Integer countBy() {
        return countBy;
    }

    public void countBy(Integer countBy) {
        this.countBy = countBy;
    }

    public LineNumberShape countByAnd(Integer countBy) {
        this.countBy = countBy;
        return this;
    }

    public Integer distance() {
        return distance;
    }

    public void distance(Integer distance) {
        this.distance = distance;
    }

    public LineNumberShape distanceAnd(Integer distance) {
        this.distance = distance;
        return this;
    }

    public Integer startNumber() {
        return startNumber;
    }

    public void startNumber(Integer startNumber) {
        this.startNumber = startNumber;
    }

    public LineNumberShape startNumberAnd(Integer startNumber) {
        this.startNumber = startNumber;
        return this;
    }

    @Override
    public LineNumberShape clone() {
        LineNumberShape cloned = new LineNumberShape();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(LineNumberShape from) {
        this.restartType = from.restartType;
        this.countBy= from.countBy;
        this.distance = from.distance;
        this.startNumber = from.startNumber;
    }
}
