package kr.dogfoot.hwpxlib.reader.section_xml.control.table;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.SubList;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.*;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.common.baseobject.LeftRightTopBottomReader;
import kr.dogfoot.hwpxlib.reader.common.baseobject.WidthAndHeightReader;
import kr.dogfoot.hwpxlib.reader.section_xml.SubListReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import org.xml.sax.Attributes;

public class TcReader extends ElementReader {
    private Tc tc;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Tc;
    }

    public void tc(Tc tc) {
        this.tc = tc;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.name:
                tc.name(value);
                break;
            case AttributeNames.header:
                tc.header(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.hasMargin:
                tc.hasMargin(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.protect:
                tc.protect(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.editable:
                tc.editable(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.dirty:
                tc.dirty(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.borderFillIDRef:
                tc.borderFillIDRef(value);
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_cellAddr:
                tc.createCellAddr();
                cellAddr(tc.cellAddr(), name, attrs);
                break;
            case ElementNames.hp_cellSpan:
                tc.createCellSpan();
                cellSpan(tc.cellSpan(), name, attrs);
                break;
            case ElementNames.hp_cellSz:
                tc.createCellSz();
                cellSz(tc.cellSz(), name, attrs);
                break;
            case ElementNames.hp_cellMargin:
                tc.createCellMargin();
                cellMargin(tc.cellMargin(), name, attrs);
                break;
            case ElementNames.hp_subList:
                tc.createSubList();
                subList(tc.subList(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_cellAddr:
                CellAddr cellAddr = new CellAddr();
                cellAddr(cellAddr, name, attrs);
                return cellAddr;
            case ElementNames.hp_cellSpan:
                CellSpan cellSpan = new CellSpan();
                cellSpan(cellSpan, name, attrs);
                return cellSpan;
            case ElementNames.hp_cellSz:
                CellSize cellSize = new CellSize();
                cellSz(cellSize, name, attrs);
                return cellSize;
            case ElementNames.hp_cellMargin:
                CellMargin cellMargin = new CellMargin();
                cellMargin(cellMargin, name, attrs);
                return cellMargin;
            case ElementNames.hp_subList:
                SubList subList = new SubList();
                subList(subList, name, attrs);
                return subList;
        }
        return null;
    }

    private void cellAddr(CellAddr cellAddr, String name, Attributes attrs) {
        ((CellAddrReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.CellAddr))
                .cellAddr(cellAddr);

        xmlFileReader().startElement(name, attrs);
    }

    private void cellSpan(CellSpan cellSpan, String name, Attributes attrs) {
        ((CellSpanReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.CellSpan))
                .cellSpan(cellSpan);

        xmlFileReader().startElement(name, attrs);
    }

    private void cellSz(CellSize cellSz, String name, Attributes attrs) {
        ((WidthAndHeightReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.WidthAndHeight))
                .widthAndHeight(cellSz);

        xmlFileReader().startElement(name, attrs);
    }

    private void cellMargin(CellMargin cellMargin, String name, Attributes attrs) {
        ((LeftRightTopBottomReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.LeftRightTopBottom))
                .leftRightTopBottom(cellMargin);

        xmlFileReader().startElement(name, attrs);
    }

    private void subList(SubList subList, String name, Attributes attrs) {
        ((SubListReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.SubList))
                .subList(subList);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return tc;
    }
}
