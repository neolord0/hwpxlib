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
    public ObjectType objectType() {
        return ObjectType.Outline;
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
}
