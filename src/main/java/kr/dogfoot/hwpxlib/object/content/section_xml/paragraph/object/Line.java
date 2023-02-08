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
    public ObjectType objectType() {
        return ObjectType.Line;
    }

    public Boolean isReverseHV() {
        return isReverseHV;
    }

    public void reverseHV(Boolean reverseHV) {
        this.isReverseHV = reverseHV;
    }

    public Line reverseHVAnd(Boolean reverseHV) {
        this.isReverseHV = reverseHV;
        return this;
    }

    public Point startPt() {
        return startPt;
    }

    public void createStartPt() {
        startPt = new Point(ObjectType.StartPt);
    }

    public void removeStartPt() {
        startPt = null;
    }

    public Point endPt() {
        return endPt;
    }

    public void createEndPt() {
        endPt = new Point(ObjectType.EndPt);
    }

    public void removeEndPt() {
        endPt = null;
    }
}
