package kr.dogfoot.hwpxlib.writer.section_xml.object;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.Point;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.TextArt;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;
import kr.dogfoot.hwpxlib.writer.section_xml.object.drawingobject.DrawingObjectWriter;

public class TextArtWriter extends DrawingObjectWriter {
    public TextArtWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.TextArt;
    }

    @Override
    public void write(HWPXObject object) {
        TextArt textArt = (TextArt) object;
        switchObject(textArt.switchObject());

        xsb()
                .openElement(ElementNames.hp_textart)
                .elementWriter(this);
        writeAttributeForDrawingObject(textArt);
        xsb().attribute(AttributeNames.text, textArt.text());

        writeChildrenForDrawingObject(textArt);

        if (textArt.pt0() != null) {
            point(ElementNames.hc_pt0, textArt.pt0());
        }

        if (textArt.pt1() != null) {
            point(ElementNames.hc_pt1, textArt.pt1());
        }

        if (textArt.pt2() != null) {
            point(ElementNames.hc_pt2, textArt.pt2());
        }

        if (textArt.pt3() != null) {
            point(ElementNames.hc_pt3, textArt.pt3());
        }

        if (textArt.textartPr() != null) {
            writeChild(ElementWriterSort.TextArtPr, textArt.textartPr());
        }

        if (textArt.outline() != null) {
            writeChild(ElementWriterSort.Outline, textArt.outline());
        }

        writeChildrenForShapeObject(textArt);

        xsb().closeElement();
        releaseMe();
    }


    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hc_pt0:
                point(ElementNames.hc_pt0, (Point) child);
                break;
            case hc_pt1:
                point(ElementNames.hc_pt1, (Point) child);
                break;
            case hc_pt2:
                point(ElementNames.hc_pt2, (Point) child);
                break;
            case hc_pt3:
                point(ElementNames.hc_pt3, (Point) child);
                break;
            case hp_textartPr:;
                writeChild(ElementWriterSort.TextArtPr, child);
                break;
            case hp_outline:
                writeChild(ElementWriterSort.Outline, child);
                break;
            default:
                super.childInSwitch(child);
                break;
        }
    }
}
