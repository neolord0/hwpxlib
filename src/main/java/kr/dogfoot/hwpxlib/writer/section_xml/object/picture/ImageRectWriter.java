package kr.dogfoot.hwpxlib.writer.section_xml.object.picture;

import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.Point;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.ImageRect;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class ImageRectWriter extends ElementWriter {
    public ImageRectWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.ImageRect;
    }

    @Override
    public void write(HWPXObject object) {
        ImageRect imageRect = (ImageRect) object;
        switchObject(imageRect.switchObject());

        xsb()
                .openElement(ElementNames.hp_imgRect)
                .elementWriter(this);

        if (imageRect.pt0() != null) {
            point(ElementNames.hc_pt0, imageRect.pt0());
        }

        if (imageRect.pt1() != null) {
            point(ElementNames.hc_pt1, imageRect.pt1());
        }

        if (imageRect.pt2() != null) {
            point(ElementNames.hc_pt2, imageRect.pt2());
        }

        if (imageRect.pt3() != null) {
            point(ElementNames.hc_pt3, imageRect.pt3());
        }

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
        }
    }
}
