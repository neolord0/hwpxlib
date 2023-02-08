package kr.dogfoot.hwpxlib.reader.section_xml.ctrl;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ColumnDirection;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.EndNoteNumberingType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.MultiColumnType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.ColPr;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.ColLine;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.ColSz;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class ColPrReader extends ElementReader {
    private ColPr colPr;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ColPr;
    }

    public void colPr(ColPr colPr) {
        this.colPr = colPr;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.id:
                colPr.id(value);
                break;
            case AttributeNames.type:
                colPr.type(MultiColumnType.fromString(value));
                break;
            case AttributeNames.layout:
                colPr.layout(ColumnDirection.fromString(value));
                break;
            case AttributeNames.colCount:
                colPr.colCount(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.sameSz:
                colPr.sameSz(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.sameGap:
                colPr.sameGap(ValueConvertor.toInteger(value));
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.ColSz:
                colSz(colPr.addNewColSz(), name, attrs);
                break;
            case ElementNames.ColLine:
                colPr.createColLine();
                colLine(colPr.colLine(), name, attrs);
                break;
        }
    }

    @Override
    public void childElementInSwitch(HWPXObject child, String name, Attributes attrs) {
        if (child.objectType() == ObjectType.ColSz) {
            colSz((ColSz) child, name, attrs);
        } else if (child.objectType() == ObjectType.ColLine) {
            colLine((ColLine) child, name, attrs);
        }
    }

    private void colSz(ColSz colSz, String name, Attributes attrs) {
        ((ColSzReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ColSz))
                .colSz(colSz);

        xmlFileReader().startElement(name, attrs);
    }

    private void colLine(ColLine colLine, String name, Attributes attrs) {
        ((ColLineReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ColLine))
                .colLine(colLine);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return colPr;
    }
}
