package kr.dogfoot.hwpxlib.tool.finder.section.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.Point;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Polygon;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;
import kr.dogfoot.hwpxlib.tool.finder.section.object.comm.FromDrawingObject;

public class FromPolygon extends FromDrawingObject {
    public FromPolygon(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_polygon;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Polygon polygon = (Polygon) from;
        pushPath(polygon);

        checkFromDrawingObject(polygon);

        for (Point point : polygon.pts()) {
            check(point);
        }

        checkSwitchList(polygon.switchList());
        popPath();
    }
}
