package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.Point;

public class ImageRect extends SwitchableObject {
    /**
     * 첫번째 좌표, 좌측 상단
     */
    private Point pt0;
    /**
     * 두번째 좌표, 우측 상단
     */
    private Point pt1;
    /**
     * 세번째 좌표, 우측 하단
     */
    private Point pt2;
    /**
     * 네번째 좌표, 좌측 하단
     */
    private Point pt3;

    public ImageRect() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.ImgRect;
    }

    public Point pt0() {
        return pt0;
    }

    public void createPt0() {
        pt0 = new Point(ObjectType.Pt0);
    }

    public void removePt0() {
        pt0 = null;
    }

    public Point pt1() {
        return pt1;
    }

    public void createPt1() {
        pt1 = new Point(ObjectType.Pt1);
    }

    public void removePt1() {
        pt1 = null;
    }

    public Point pt2() {
        return pt2;
    }

    public void createPt2() {
        pt2 = new Point(ObjectType.Pt2);
    }

    public void removePt2() {
        pt2 = null;
    }

    public Point pt3() {
        return pt3;
    }

    public void createPt3() {
        pt3 = new Point(ObjectType.Pt3);
    }

    public void removePt3() {
        pt3 = null;
    }
}
