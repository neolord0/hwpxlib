package kr.dogfoot.hwpxlib.reader.section_xml.object.picture;

import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.Point;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.ImageRect;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import org.xml.sax.Attributes;

public class ImageRectReader extends ElementReader {
    private ImageRect imgRect;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ImageRect;
    }

    public void imgRect(ImageRect imgRect) {
        this.imgRect = imgRect;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hc_pt0:
                imgRect.createPt0();
                point(imgRect.pt0(), name, attrs);
                break;
            case ElementNames.hc_pt1:
                imgRect.createPt1();
                point(imgRect.pt1(), name, attrs);
                break;
            case ElementNames.hc_pt2:
                imgRect.createPt2();
                point(imgRect.pt2(), name, attrs);
                break;
            case ElementNames.hc_pt3:
                imgRect.createPt3();
                point(imgRect.pt3(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hc_pt0:
                Point pt0 = new Point(ObjectType.hc_pt0);
                point(pt0, name, attrs);
                return pt0;
            case ElementNames.hc_pt1:
                Point pt1 = new Point(ObjectType.hc_pt1);
                point(pt1, name, attrs);
                return pt1;
            case ElementNames.hc_pt2:
                Point pt2 = new Point(ObjectType.hc_pt2);
                point(pt2, name, attrs);
                return pt2;
            case ElementNames.hc_pt3:
                Point pt3 = new Point(ObjectType.hc_pt3);
                point(pt3, name, attrs);
                return pt3;
        }
        return null;
    }

    @Override
    public SwitchableObject switchableObject() {
        return imgRect;
    }
}
