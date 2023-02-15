package kr.dogfoot.hwpxlib.reader.section_xml.control.table;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.CellSpan;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;

public class CellSpanReader extends ElementReader {
    private CellSpan cellSpan;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.CellSpan;
    }

    public void cellSpan(CellSpan cellSpan) {
        this.cellSpan = cellSpan;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.colSpan:
                cellSpan.colSpan(ValueConvertor.toShort(value));
                break;
            case AttributeNames.rowSpan:
                cellSpan.rowSpan(ValueConvertor.toShort(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
