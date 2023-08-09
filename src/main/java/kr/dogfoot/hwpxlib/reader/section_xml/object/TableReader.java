package kr.dogfoot.hwpxlib.reader.section_xml.object;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.LeftRightTopBottom;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.TablePageBreak;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Table;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.CellZone;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.ParameterSet;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.Tr;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.section_xml.object.shapeobject.ShapeObjectReader;
import kr.dogfoot.hwpxlib.reader.section_xml.object.table.CellzoneListReader;
import kr.dogfoot.hwpxlib.reader.section_xml.object.table.TrReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
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
                leftRightTopBottom(table.inMargin(), name, attrs);
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
                parameterList(table.parameterSet(), name, attrs);
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
                LeftRightTopBottom inMargin = new LeftRightTopBottom(ObjectType.hp_inMargin);
                leftRightTopBottom(inMargin, name, attrs);
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
                parameterList(parameterSet, name, attrs);
                return parameterSet;
        }
        return super.childElementInSwitch(name, attrs);
    }

    private void cellzoneList(ObjectList<CellZone> cellzoneList, String name, Attributes attrs) {
        ((CellzoneListReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.CellZoneList))
                .cellzoneList(cellzoneList);

        xmlFileReader().startElement(name, attrs);
    }

    private void tr(Tr tr, String name, Attributes attrs) {
        ((TrReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Tr))
                .tr(tr);

        xmlFileReader().startElement(name, attrs);
    }


    @Override
    public SwitchableObject switchableObject() {
        return table;
    }
}
