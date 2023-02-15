package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.WidthAndHeight;

/**
 * 셀 크기
 */
public class CellSize extends WidthAndHeight<CellSize> {
    public CellSize() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_cellSz;
    }
}
