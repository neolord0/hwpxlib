package kr.dogfoot.hwpxlib.reader.section_xml;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.LineSeg;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Run;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class LineSegArrayReader extends ElementReader {
    private ObjectList<LineSeg> lineSegArray;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.LineSegArray;
    }

    public void lineSegArray(ObjectList<LineSeg> lineSegArray) {
        this.lineSegArray = lineSegArray;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.LineSeg:
                lineSeg(lineSegArray.addNew(), name, attrs);
                break;
        }
    }
    @Override
    public void childElementInSwitch(HWPXObject child, String name, Attributes attrs) {
        if (ObjectType.LineSeg.equalElementName(name)) {
            lineSeg((LineSeg) child, name, attrs);
        }
    }

    private void lineSeg(LineSeg lineSeg, String name, Attributes attrs) {
        ((LineSegReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.LineSeg))
                .lineSeg(lineSeg);

        xmlFileReader().startElement(name, attrs);

    }


    @Override
    public SwitchableObject switchableObject() {
        return lineSegArray;
    }
}