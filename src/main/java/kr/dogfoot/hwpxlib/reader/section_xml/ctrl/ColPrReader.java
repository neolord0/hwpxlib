package kr.dogfoot.hwpxlib.reader.section_xml.ctrl;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ColumnDirection;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.MultiColumnType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.ColPr;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.ColLine;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.ColSz;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
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
            case ElementNames.hp_colSz:
                colSz(colPr.addNewColSz(), name, attrs);
                break;
            case ElementNames.hp_colLine:
                colPr.createColLine();
                colLine(colPr.colLine(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_colSz:
                ColSz colSz = new ColSz();
                colSz(colSz, name, attrs);
                return colSz;
            case ElementNames.hp_colLine:
                ColLine colLine = new ColLine();
                colLine(colLine, name, attrs);
                return colLine;
        }
        return null;
    }

    private void colSz(ColSz colSz, String name, Attributes attrs) {
        ((ColSzReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ColSz))
                .colSz(colSz);

        xmlFileReader().startElement(name, attrs);
    }

    private void colLine(ColLine colLine, String name, Attributes attrs) {
        ((ColLineReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ColLine))
                .colLine(colLine);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return colPr;
    }
}
