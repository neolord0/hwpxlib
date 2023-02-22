package kr.dogfoot.hwpxlib.reader.section_xml.control.table;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.CellZone;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.object.names.AttributeNames;

public class CellZoneReader extends ElementReader {
    private CellZone cellZone;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.CellZone;
    }

    public void cellZone(CellZone cellZone) {
        this.cellZone = cellZone;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.startRowAddr:
                cellZone.startRowAddr(ValueConvertor.toShort(value));
                break;
            case AttributeNames.startColAddr:
                cellZone.startColAddr(ValueConvertor.toShort(value));
                break;
            case AttributeNames.endRowAddr:
                cellZone.endRowAddr(ValueConvertor.toShort(value));
                break;
            case AttributeNames.endColAddr:
                cellZone.endColAddr(ValueConvertor.toShort(value));
                break;
            case AttributeNames.borderFillIDRef:
                cellZone.borderFillIDRef(value);
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
