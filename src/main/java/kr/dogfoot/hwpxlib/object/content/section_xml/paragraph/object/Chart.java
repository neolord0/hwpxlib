package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeObject;

/**
 * 차트
 */
public class Chart extends ShapeObject<Chart> {
    /**
     * 버전
     */
    private Float version;
    /**
     * 차트 데이터에 대한 아이디 참조 값
     */
    private String chartIDRef;

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_chart;
    }

    public Float version() {
        return version;
    }

    public void version(Float version) {
        this.version = version;
    }

    public Chart versionAnd(Float version) {
        this.version = version;
        return this;
    }

    public String chartIDRef() {
        return chartIDRef;
    }

    public void chartIDRef(String chartIDRef) {
        this.chartIDRef = chartIDRef;
    }

    public Chart chartIDRefAnd(String chartIDRef) {
        this.chartIDRef = chartIDRef;
        return this;
    }

    @Override
    public Chart clone() {
        Chart cloned = new Chart();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(Chart from) {
        this.version = from.version;
        this.chartIDRef = from.chartIDRef;

        super.copyFrom(from);
    }
}
