package kr.dogfoot.hwpxlib.reader.section_xml.object.etc;

import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.Point;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import org.xml.sax.Attributes;

public class PointListReader extends ElementReader {
    private ObjectList<Point> pointList;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.PointList;
    }

    public void pointList(ObjectList<Point> pointList) {
        this.pointList = pointList;
    }


    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hc_pt:
                point(pointList.addNew(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hc_pt:
                Point pt = new Point(ObjectType.hc_pt);
                point(pt, name, attrs);
                return pt;
        }

        return super.childElementInSwitch(name, attrs);
    }


    @Override
    public SwitchableObject switchableObject() {
        return pointList;
    }
}
