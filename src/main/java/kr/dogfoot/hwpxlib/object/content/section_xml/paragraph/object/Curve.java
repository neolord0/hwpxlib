package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.curve.CurveSegment;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingObject;

import java.util.ArrayList;

/**
 * 곡선
 */
public class Curve extends DrawingObject<Curve> {
    public final ArrayList<CurveSegment> segmentList;

    public Curve() {
        segmentList = new ArrayList<CurveSegment>();
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Curve;
    }

    public int countOfSegment() {
        return segmentList.size();
    }

    public CurveSegment getSegment(int index) {
        return segmentList.get(index);
    }

    public void addSegment(CurveSegment segment) {
        segmentList.add(segment);
    }

    public CurveSegment addNewSegment() {
        CurveSegment segment = new CurveSegment();
        segmentList.add(segment);
        return segment;
    }

    public void insertSegment(CurveSegment segment, int position) {
        segmentList.add(position, segment);
    }

    public void removeSegment(int position) {
        segmentList.remove(position);
    }

    public Iterable<CurveSegment> segments() {
        return segmentList;
    }
}
