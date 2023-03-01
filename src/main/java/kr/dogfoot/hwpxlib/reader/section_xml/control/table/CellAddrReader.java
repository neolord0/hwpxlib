package kr.dogfoot.hwpxlib.reader.section_xml.control.table;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.CellAddr;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class CellAddrReader extends ElementReader {
    private CellAddr cellAddr;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.CellAddr;
    }

    public void cellAddr(CellAddr cellAddr) {
        this.cellAddr = cellAddr;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.colAddr:
                cellAddr.colAddr(ValueConvertor.toShort(value));
                break;
            case AttributeNames.rowAddr:
                cellAddr.rowAddr(ValueConvertor.toShort(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
