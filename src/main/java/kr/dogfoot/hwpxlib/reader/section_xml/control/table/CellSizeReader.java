package kr.dogfoot.hwpxlib.reader.section_xml.control.table;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.CellSize;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;

public class CellSizeReader extends ElementReader {
    private CellSize cellSz;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.CellSize;
    }

    public void cellSz(CellSize cellSz) {
        this.cellSz = cellSz;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.width:
                cellSz.width(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.height:
                cellSz.height(ValueConvertor.toInteger(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
