package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.Point;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ConnectLineType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.connectline.EndPoint;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.connectline.StartPoint;
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
    private StartPoint startPt;
    /**
     * 끝점
     */
    private EndPoint endPt;

    public ConnectLine() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.ConnectLine;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.StartPt.equalElementName(name)) {
            return new StartPoint();
        } else if (ObjectType.EndPt.equalElementName(name)) {
            return new EndPoint();
        }
        return super.createChildWithElementName(name);
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

    public StartPoint startPt() {
        return startPt;
    }

    public void createStartPt() {
        startPt = new StartPoint();
    }

    public void removeStartPt() {
        startPt = null;
    }

    public EndPoint endPt() {
        return endPt;
    }

    public void createEndPt() {
        endPt = new EndPoint();
    }

    public void removeEndPt() {
        endPt = null;
    }
}
