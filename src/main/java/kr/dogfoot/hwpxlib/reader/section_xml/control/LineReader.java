package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.Point;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Line;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingObject;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.common.baseobject.XAndYReader;
import kr.dogfoot.hwpxlib.reader.section_xml.control.drawingobject.DrawingObjectReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class LineReader extends DrawingObjectReader {
    private Line line;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Line;
    }

    @Override
    public DrawingObject drawingObject() {
        return line;
    }

    public void line(Line line) {
        this.line = line;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.isReverseHV:
                line.isReverseHV(ValueConvertor.toBoolean(value));
            default:
                super.setAttribute(name, value);
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hc_startPt:
                line.createStartPt();
                point(line.startPt(), name, attrs);
                break;
            case ElementNames.hc_endPt:
                line.createEndPt();
                point(line.endPt(), name, attrs);
                break;
            default:
                super.childElement(name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hc_startPt:
                Point startPt = new Point(ObjectType.hc_startPt);
                point(startPt, name, attrs);
                return startPt;
            case ElementNames.hc_endPt:
                Point endPt = new Point(ObjectType.hc_endPt);
                point(endPt, name, attrs);
                return endPt;
        }

        return super.childElementInSwitch(name, attrs);
    }

    private void point(Point pt, String name, Attributes attrs) {
        ((XAndYReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.XAndY))
                .xAndY(pt);

        xmlFileReader().startElement(name, attrs);

    }

    @Override
    public SwitchableObject switchableObject() {
        return line;
    }
}
