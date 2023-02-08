package kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.HorizontalAlign2;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.VerticalAlign1;

/**
 * 문단 정렬
 */
public class Align extends HWPXObject {
    /**
     * 가로 정렬
     */
    private HorizontalAlign2 horizontal;
    /**
     * 세로 정렬
     */
    private VerticalAlign1 vertical;

    public Align() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Align;
    }


    public HorizontalAlign2 horizontal() {
        return horizontal;
    }

    public void horizontal(HorizontalAlign2 horizontal) {
        this.horizontal = horizontal;
    }

    public Align horizontalAnd(HorizontalAlign2 horizontal) {
        this.horizontal = horizontal;
        return this;
    }

    public VerticalAlign1 vertical() {
        return vertical;
    }

    public void vertical(VerticalAlign1 vertical) {
        this.vertical = vertical;
    }

    public Align verticalAnd(VerticalAlign1 vertical) {
        this.vertical = vertical;
        return this;
    }
}
