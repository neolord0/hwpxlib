package kr.dogfoot.hwpxlib.reader.section_xml;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.LineSeg;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Para;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Run;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class ParaReader extends ElementReader {
    private Para para;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Para;
    }

    public void para(Para para) {
        this.para = para;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.id:
                para.id(value);
                break;
            case AttributeNames.paraPrIDRef:
                para.paraPrIDRef(value);
                break;
            case AttributeNames.styleIDRef:
                para.styleIDRef(value);
                break;
            case AttributeNames.pageBreak:
                para.pageBreak(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.columnBreak:
                para.columnBreak(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.merged:
                para.merged(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.paraTcId:
                para.paraTcId(value);
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.Run:
                run(para.addNewRun(), name, attrs);
                break;
            case ElementNames.LineSegArray:
                para.createLineSegArray();
                lineSegArray(para.lineSegArray(), name, attrs);
                break;
        }
    }


    @Override
    public void childElementInSwitch(HWPXObject child, String name, Attributes attrs) {
        if (ObjectType.Run.equalElementName(name)) {
            run((Run) child, name, attrs);
        } else if (ObjectType.LineSegArray.equalElementName(name)) {
            lineSegArray((ObjectList<LineSeg>) child, name, attrs);
        }
    }

    private void run(Run run, String name, Attributes attrs) {
        ((RunReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Run))
                .run(run);

        xmlFileReader().startElement(name, attrs);
    }

    private void lineSegArray(ObjectList<LineSeg> lineSegArray, String name, Attributes attrs) {
        ((LineSegArrayReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.LineSegArray))
                .lineSegArray(lineSegArray);

        xmlFileReader().startElement(name, attrs);
    }


    @Override
    public SwitchableObject switchableObject() {
        return para;
    }
}
