package kr.dogfoot.hwpxlib.tool.finder.section.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Arc;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;
import kr.dogfoot.hwpxlib.tool.finder.section.object.comm.FromDrawingObject;

public class FromArc extends FromDrawingObject {
    public FromArc(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_arc;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Arc arc = (Arc) from;
        pushPath(arc);

        checkFromDrawingObject(arc);

        check(arc.center());
        check(arc.ax1());
        check(arc.ax2());

        checkSwitchObject(arc.switchObject());
        popPath();
    }
}
