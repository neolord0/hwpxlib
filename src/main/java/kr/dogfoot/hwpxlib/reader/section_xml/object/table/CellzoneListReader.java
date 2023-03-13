package kr.dogfoot.hwpxlib.reader.section_xml.object.table;

import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.CellZone;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import org.xml.sax.Attributes;

public class CellzoneListReader extends ElementReader {
    private ObjectList<CellZone> cellzoneList;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.CellZoneList;
    }

    public void cellzoneList(ObjectList<CellZone> cellzoneList) {
        this.cellzoneList = cellzoneList;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_cellzone:
                cellzone(cellzoneList.addNew(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_cellzone:
                CellZone cellZone = new CellZone();
                cellzone(cellZone, name, attrs);
                return cellZone;
        }
        return null;
    }

    private void cellzone(CellZone cellZone, String name, Attributes attrs) {
        ((CellZoneReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.CellZone))
                .cellZone(cellZone);

        xmlFileReader().startElement(name, attrs);
    }


    @Override
    public SwitchableObject switchableObject() {
        return cellzoneList;
    }
}
