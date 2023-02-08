package kr.dogfoot.hwpxlib.reader.section_xml.secpr;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.Grid;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;

public class GridReader extends ElementReader {
    private Grid grid;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Grid;
    }

    public void grid(Grid grid) {
        this.grid = grid;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.lineGrid:
                grid.lineGrid(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.charGrid:
                grid.charGrid(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.wonggojiFormat:
                grid.wonggojiFormat(ValueConvertor.toBoolean(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
