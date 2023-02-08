package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.pageborder;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.LeftRightTopBottom;

public class PageBorderFillOffset extends LeftRightTopBottom<PageBorderFillOffset> {
    public PageBorderFillOffset() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.PageBorderFillOffset;
    }
}
