package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.curve.CurveSegment;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingObject;

import java.util.ArrayList;

/**
 * 곡선
 */
public class Curve extends DrawingObject<Curve> {
    private final ArrayList<CurveSegment> segList;

    public Curve() {
        segList = new ArrayList<CurveSegment>();
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_curve;
    }

    public int countOfSeg() {
        return segList.size();
    }

    public CurveSegment getSeg(int index) {
        return segList.get(index);
    }

    public int getSegIndex(CurveSegment seg) {
        int count = segList.size();
        for (int index = 0; index < count; index++) {
            if (segList.get(index) == seg) {
                return index;
            }
        }
        return -1;
    }

    public void addSeg(CurveSegment seg) {
        segList.add(seg);
    }

    public CurveSegment addNewSeg() {
        CurveSegment seg = new CurveSegment();
        segList.add(seg);
        return seg;
    }

    public void insertSeg(CurveSegment seg, int position) {
        segList.add(position, seg);
    }

    public void removeSeg(int position) {
        segList.remove(position);
    }

    public void removeSeg(CurveSegment seg) {
        segList.remove(seg);
    }

    public void removeAllSegs() {
        segList.clear();
    }

    public Iterable<CurveSegment> segs() {
        return segList;
    }

    @Override
    public Curve clone() {
        Curve cloned = new Curve();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(Curve from) {
        for (CurveSegment seg : from.segList) {
            segList.add(seg.clone());
        }

        super.copyFrom(from);
    }
}
