package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object;

import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ConnectLineType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.connectline.ConnectLinePoint;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.connectline.Point;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingObject;

/**
 * 연결선
 */
public class ConnectLine extends DrawingObject<ConnectLine> {
    /**
     * 연결선 종류
     */
    private ConnectLineType type;
    /**
     * 시작점
     */
    private ConnectLinePoint startPt;
    /**
     * 끝점
     */
    private ConnectLinePoint endPt;

    private ObjectList<Point> controlPoints;

    public ConnectLine() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_connectLine;
    }

    public ConnectLineType type() {
        return type;
    }

    public void type(ConnectLineType type) {
        this.type = type;
    }

    public ConnectLine typeAnd(ConnectLineType type) {
        this.type = type;
        return this;
    }

    public ConnectLinePoint startPt() {
        return startPt;
    }

    public void createStartPt() {
        startPt = new ConnectLinePoint(ObjectType.hp_startPt);
    }

    public void removeStartPt() {
        startPt = null;
    }

    public ConnectLinePoint endPt() {
        return endPt;
    }

    public void createEndPt() {
        endPt = new ConnectLinePoint(ObjectType.hp_endPt);
    }

    public void removeEndPt() {
        endPt = null;
    }

    public ObjectList<Point> controlPoints() {
        return controlPoints;
    }

    public void createControlPoints() {
        controlPoints = new ObjectList<Point>(ObjectType.hp_controlPoints, Point.class);
    }

    public void removeControlPoints() {
        controlPoints = null;
    }

    @Override
    public ConnectLine clone() {
        ConnectLine cloned = new ConnectLine();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(ConnectLine from) {
        this.type = from.type;

        if (from.startPt != null) {
            startPt = from.startPt.clone();
        } else {
            startPt = null;
        }

        if (from.endPt != null) {
            endPt = from.endPt.clone();
        } else {
            endPt = null;
        }

        if (from.controlPoints != null) {
            createControlPoints();
            for (Point point : from.controlPoints.items()) {
                controlPoints.add(point.clone());
            }
        } else {
            removeControlPoints();
        }

        super.copyFrom(from);
    }
}
