package kr.dogfoot.hwpxlib.tool.finder.section.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Rectangle;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;
import kr.dogfoot.hwpxlib.tool.finder.section.object.comm.FromDrawingObject;

public class FromRectangle extends FromDrawingObject {
    public FromRectangle(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_rect;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Rectangle rectangle = (Rectangle) from;
        pushPath(rectangle);

        checkFromDrawingObject(rectangle);

        check(rectangle.pt0());
        check(rectangle.pt1());
        check(rectangle.pt2());
        check(rectangle.pt3());

        checkSwitchList(rectangle.switchList());
        popPath();
    }
}
