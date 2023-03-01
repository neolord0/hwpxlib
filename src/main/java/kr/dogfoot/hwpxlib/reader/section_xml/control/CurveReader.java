package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Curve;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.curve.CurveSegment;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingObject;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.section_xml.control.drawingobject.DrawingObjectReader;
import kr.dogfoot.hwpxlib.reader.section_xml.control.etc.CurveSegmentReader;
import org.xml.sax.Attributes;

public class CurveReader extends DrawingObjectReader {
    private Curve curve;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Curve;
    }

    @Override
    public DrawingObject drawingObject() {
        return curve;
    }

    public void curve(Curve curve) {
        this.curve = curve;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_seg:
                seg(curve.addNewSeg(), name, attrs);
                break;
            default:
                super.childElement(name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_seg:
                CurveSegment seg = new CurveSegment();
                seg(seg, name, attrs);
                return seg;
        }

        return super.childElementInSwitch(name, attrs);
    }

    private void seg(CurveSegment seg, String name, Attributes attrs) {
        ((CurveSegmentReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.CurveSegment))
                .curveSegment(seg);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return curve;
    }
}
