package kr.dogfoot.hwpxlib.writer.section_xml.object.table;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.LeftRightTopBottom;
import kr.dogfoot.hwpxlib.object.common.baseobject.WidthAndHeight;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.CellAddr;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.CellSpan;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.Tc;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class TcWriter extends ElementWriter {
    public TcWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Tc;
    }

    @Override
    public void write(HWPXObject object) {
        Tc tc = (Tc) object;
        switchObject(tc.switchObject());

        xsb()
                .openElement(ElementNames.hp_tc)
                .elementWriter(this)
                .attribute(AttributeNames.name, tc.name())
                .attribute(AttributeNames.header, tc.header())
                .attribute(AttributeNames.hasMargin, tc.hasMargin())
                .attribute(AttributeNames.protect, tc.protect())
                .attribute(AttributeNames.editable, tc.editable())
                .attribute(AttributeNames.dirty, tc.dirty())
                .attribute(AttributeNames.borderFillIDRef, tc.borderFillIDRef());

        if (tc.subList() != null) {
            writeChild(ElementWriterSort.SubList, tc.subList());
        }

        if (tc.cellAddr() != null) {
            cellAddr(tc.cellAddr());
        }

        if (tc.cellSpan() != null) {
            cellSpan(tc.cellSpan());
        }

        if (tc.cellSz() != null) {
            widthAndHeight(ElementNames.hp_cellSz, tc.cellSz());
        }

        if (tc.cellMargin() != null) {
            leftRightTopBottom(ElementNames.hp_cellMargin, tc.cellMargin());
        }

        xsb().closeElement();
        releaseMe();
    }

    private void cellAddr(CellAddr cellAddr) {
        xsb()
                .openElement(ElementNames.hp_cellAddr)
                .attribute(AttributeNames.colAddr, cellAddr.colAddr())
                .attribute(AttributeNames.rowAddr, cellAddr.rowAddr())
                .closeElement();
    }

    private void cellSpan(CellSpan cellSpan) {
        xsb()
                .openElement(ElementNames.hp_cellSpan)
                .attribute(AttributeNames.colSpan, cellSpan.colSpan())
                .attribute(AttributeNames.rowSpan, cellSpan.rowSpan())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_cellAddr:
                cellAddr((CellAddr) child);
                break;
            case hp_cellSpan:
                cellSpan((CellSpan) child);
                break;
            case hp_cellSz:
                widthAndHeight(ElementNames.hp_cellSz, (WidthAndHeight) child);
                break;
            case hp_cellMargin:
                leftRightTopBottom(ElementNames.hp_cellMargin, (LeftRightTopBottom) child);
                break;
            case hp_subList:
                writeChild(ElementWriterSort.SubList, child);
                break;
        }
    }
}
