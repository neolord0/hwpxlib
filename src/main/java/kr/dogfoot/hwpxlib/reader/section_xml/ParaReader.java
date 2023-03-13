package kr.dogfoot.hwpxlib.reader.section_xml;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
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
            case ElementNames.hp_run:
                run(para.addNewRun(), name, attrs);
                break;
            case ElementNames.hp_linesegarray:
                para.createLineSegArray();
                lineSegArray(para.lineSegArray(), name, attrs);
                break;
        }
    }


    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_run:
                Run run = new Run();
                run(run, name, attrs);
                return run;
            case ElementNames.hp_linesegarray:
                ObjectList<LineSeg> lineSegArray = new ObjectList<LineSeg>(ObjectType.hp_linesegarray, LineSeg.class);
                lineSegArray(lineSegArray, name, attrs);
                return lineSegArray;
        }
        return null;
    }

    private void run(Run run, String name, Attributes attrs) {
        ((RunReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Run))
                .run(run);

        xmlFileReader().startElement(name, attrs);
    }

    private void lineSegArray(ObjectList<LineSeg> lineSegArray, String name, Attributes attrs) {
        ((LineSegArrayReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.LineSegArray))
                .lineSegArray(lineSegArray);

        xmlFileReader().startElement(name, attrs);
    }


    @Override
    public SwitchableObject switchableObject() {
        return para;
    }
}
