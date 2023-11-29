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
    public ObjectType _objectType() {
        return ObjectType.hp_imgRect;
    }

    public Point pt0() {
        return pt0;
    }

    public void createPt0() {
        pt0 = new Point(ObjectType.hc_pt0);
    }

    public void removePt0() {
        pt0 = null;
    }

    public Point pt1() {
        return pt1;
    }

    public void createPt1() {
        pt1 = new Point(ObjectType.hc_pt1);
    }

    public void removePt1() {
        pt1 = null;
    }

    public Point pt2() {
        return pt2;
    }

    public void createPt2() {
        pt2 = new Point(ObjectType.hc_pt2);
    }

    public void removePt2() {
        pt2 = null;
    }

    public Point pt3() {
        return pt3;
    }

    public void createPt3() {
        pt3 = new Point(ObjectType.hc_pt3);
    }

    public void removePt3() {
        pt3 = null;
    }

    @Override
    public ImageRect clone() {
        ImageRect cloned = new ImageRect();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(ImageRect from) {
        if (from.pt0 != null) {
            pt0 = from.pt0.clone();
        } else {
            pt0 = null;
        }

        if (from.pt1 != null) {
            pt1 = from.pt1.clone();
        } else {
            pt1 = null;
        }

        if (from.pt2 != null) {
            pt2 = from.pt2.clone();
        } else {
            pt2 = null;
        }

        if (from.pt3 != null) {
            pt3 = from.pt3.clone();
        } else {
            pt3 = null;
        }

        super.copyFrom(from);
    }
}

