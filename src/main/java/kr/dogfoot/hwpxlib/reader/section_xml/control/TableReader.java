package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.TablePageBreak;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Table;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.CellZone;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.InMargin;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.ParameterSet;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.Tr;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.common.baseobject.LeftRightTopBottomReader;
import kr.dogfoot.hwpxlib.reader.common.parameter.ParameterListReader;
import kr.dogfoot.hwpxlib.reader.section_xml.control.shapeobject.ShapeObjectReader;
import kr.dogfoot.hwpxlib.reader.section_xml.control.table.CellzoneListReader;
import kr.dogfoot.hwpxlib.reader.section_xml.control.table.TrReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class TableReader extends ShapeObjectReader {
    private Table table;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Tbl;
    }

    @Override
    public ShapeObject shapeObject() {
        return table;
    }

    public void table(Table table) {
        this.table = table;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.pageBreak:
                table.pageBreak(TablePageBreak.fromString(value));
                break;
            case AttributeNames.repeatHeader:
                table.repeatHeader(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.rowCnt:
                table.rowCnt(ValueConvertor.toShort(value));
                break;
            case AttributeNames.colCnt:
                table.colCnt(ValueConvertor.toShort(value));
                break;
            case AttributeNames.cellSpacing:
                table.cellSpacing(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.borderFillIDRef:
                table.borderFillIDRef(value);
                break;
            case AttributeNames.noAdjust:
                table.noAdjust(ValueConvertor.toBoolean(value));
                break;
            default:
                super.setAttribute(name, value);
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_inMargin:
                table.createInMargin();
                inMargin(table.inMargin(), name, attrs);
                break;
            case ElementNames.hp_cellzoneList:
                table.createCellzoneList();
                cellzoneList(table.cellzoneList(), name, attrs);
                break;
            case ElementNames.hp_tr:
                tr(table.addNewTr(), name, attrs);
                break;
            case ElementNames.hp_parameterset:
                table.createParameterSet();
                parameterSet(table.parameterSet(), name, attrs);
                break;
            default:
                super.childElement(name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_inMargin:
                InMargin inMargin = new InMargin();
                inMargin(inMargin, name, attrs);
                return inMargin;
            case ElementNames.hp_cellzoneList:
                ObjectList<CellZone> cellzoneList = new ObjectList<CellZone>(ObjectType.hp_cellzoneList, CellZone.class);
                cellzoneList(cellzoneList, name, attrs);
                return cellzoneList;
            case ElementNames.hp_tr:
                Tr tr = new Tr();
                tr(tr, name, attrs);
                return tr;
            case ElementNames.hp_parameterset:
                ParameterSet parameterSet = new ParameterSet();
                parameterSet(parameterSet, name, attrs);
                return parameterSet;
        }
        return super.childElementInSwitch(name, attrs);
    }

    private void inMargin(InMargin inMargin, String name, Attributes attrs) {
        ((LeftRightTopBottomReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.LeftRightTopBottom))
                .leftRightTopBottom(inMargin);

        xmlFileReader().startElement(name, attrs);
    }

    private void cellzoneList(ObjectList<CellZone> cellzoneList, String name, Attributes attrs) {
        ((CellzoneListReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.CellZoneList))
                .cellzoneList(cellzoneList);

        xmlFileReader().startElement(name, attrs);
    }

    private void tr(Tr tr, String name, Attributes attrs) {
        ((TrReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Tr))
                .tr(tr);

        xmlFileReader().startElement(name, attrs);
    }

    private void parameterSet(ParameterSet parameterSet, String name, Attributes attrs) {
        ((ParameterListReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ParameterList))
                .parameterList(parameterSet);

        xmlFileReader().startElement(name, attrs);
    }


    @Override
    public SwitchableObject switchableObject() {
        return table;
    }
}
