package kr.dogfoot.hwpxlib.writer.section_xml.object.table;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.CellZone;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class CellZoneListWriter extends ElementWriter {
    public CellZoneListWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.CellZoneList;
    }

    @Override
    public void write(HWPXObject object) {
        ObjectList<CellZone> cellZoneList = (ObjectList<CellZone>) object;
        switchObject(cellZoneList.switchObject());

        xsb()
                .openElement(ElementNames.hp_cellzoneList)
                .elementWriter(this);

        for (CellZone cellZone : cellZoneList.items()) {
            cellZone(cellZone);
        }

        xsb().closeElement();
        releaseMe();
    }

    private void cellZone(CellZone cellZone) {
        xsb()
                .openElement(ElementNames.hp_cellzone)
                .attribute(AttributeNames.startRowAddr, cellZone.startRowAddr())
                .attribute(AttributeNames.startColAddr, cellZone.startColAddr())
                .attribute(AttributeNames.endRowAddr, cellZone.endRowAddr())
                .attribute(AttributeNames.endColAddr, cellZone.endColAddr())
                .attribute(AttributeNames.borderFillIDRef, cellZone.borderFillIDRef())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_cellzone:
                cellZone((CellZone) child);
                break;
        }
    }
}
