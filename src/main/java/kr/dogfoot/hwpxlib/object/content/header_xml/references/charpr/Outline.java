package kr.dogfoot.hwpxlib.object.content.header_xml.references.charpr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType1;

/**
 * 글자 외곽선
 */
public class Outline extends HWPXObject {
    /**
     * 외곽선 종류
     */
    private LineType1 type;

    public Outline() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_outline;
    }

    public LineType1 type() {
        return type;
    }

    public void type(LineType1 type) {
        this.type = type;
    }

    public Outline typeAnd(LineType1 type) {
        this.type = type;
        return this;
    }

    @Override
    public Outline clone() {
        Outline cloned = new Outline();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(Outline from) {
        this.type = from.type;
    }
}
