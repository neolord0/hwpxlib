package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.Point;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingObject;

/**
 * 선
 */
public class Line extends DrawingObject<Line> {
    /**
     * 처음 생성시 수직선 또는 수평선일때, 선의 방향이 언제나 오른쪽(왼쪽)으로 잡히는 현상 떄문에 생기는 오류를 방지하기 위한 속성
     */
    private Boolean isReverseHV;
    /**
     * 시작점 좌표
     */
    private Point startPt;
    /**
     * 끝점 좌표
     */
    private Point endPt;

    public Line() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_line;
    }

    public Boolean isReverseHV() {
        return isReverseHV;
    }

    public void isReverseHV(Boolean isReverseHV) {
        this.isReverseHV = isReverseHV;
    }

    public Line isReverseHVAnd(Boolean isReverseHV) {
        this.isReverseHV = isReverseHV;
        return this;
    }

    public Point startPt() {
        return startPt;
    }

    public void createStartPt() {
        startPt = new Point(ObjectType.hc_startPt);
    }

    public void removeStartPt() {
        startPt = null;
    }

    public Point endPt() {
        return endPt;
    }

    public void createEndPt() {
        endPt = new Point(ObjectType.hc_endPt);
    }

    public void removeEndPt() {
        endPt = null;
    }

    @Override
    public Line clone() {
        Line cloned = new Line();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(Line from) {
        this.isReverseHV = from.isReverseHV;

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

        super.copyFrom(from);
    }
}
