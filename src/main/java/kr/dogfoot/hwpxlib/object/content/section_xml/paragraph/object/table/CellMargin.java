package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.LeftRightTopBottom;

/**
 * 셀 여백
 */
public class CellMargin extends LeftRightTopBottom<CellMargin> {
    public CellMargin() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.CellMargin;
    }
}
