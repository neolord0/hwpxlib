package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Table;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class TableReader extends ElementReader {
    private Table table;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Tbl;
    }

    public void table(Table table) {
        this.table = table;
    }

    @Override
    public SwitchableObject switchableObject() {
        return table;
    }
}
