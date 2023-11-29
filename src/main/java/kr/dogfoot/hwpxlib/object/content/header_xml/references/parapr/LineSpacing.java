package kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineSpacingType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.ValueUnit2;

/**
 * 줄간격
 */
public class LineSpacing extends HWPXObject {
    /**
     * 줄간격 종류
     */
    private LineSpacingType type;
    /**
     * 줄간격 값
     */
    private Integer value;
    /**
     * 줄간격 단위
     */
    private ValueUnit2 unit;

    public LineSpacing() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_lineSpacing;
    }


    public LineSpacingType type() {
        return type;
    }

    public void type(LineSpacingType type) {
        this.type = type;
    }

    public LineSpacing typeAnd(LineSpacingType type) {
        this.type = type;
        return this;
    }

    public Integer value() {
        return value;
    }

    public void value(Integer value) {
        this.value = value;
    }

    public LineSpacing valueAnd(Integer value) {
        this.value = value;
        return this;
    }

    public ValueUnit2 unit() {
        return unit;
    }

    public void unit(ValueUnit2 unit) {
        this.unit = unit;
    }

    public LineSpacing unitAnd(ValueUnit2 unit) {
        this.unit = unit;
        return this;
    }

    @Override
    public LineSpacing clone() {
        LineSpacing cloned = new LineSpacing();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(LineSpacing from) {
        this.type = from.type;
        this.value = from.value;
        this.unit = from.unit;
    }
}
