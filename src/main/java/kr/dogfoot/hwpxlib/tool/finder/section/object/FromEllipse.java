package kr.dogfoot.hwpxlib.tool.finder.section.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Ellipse;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;
import kr.dogfoot.hwpxlib.tool.finder.section.object.comm.FromDrawingObject;

public class FromEllipse extends FromDrawingObject {
    public FromEllipse(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_ellipse;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Ellipse ellipse = (Ellipse) from;
        pushPath(ellipse);

        checkFromDrawingObject(ellipse);

        check(ellipse.center());
        check(ellipse.ax1());
        check(ellipse.ax2());
        check(ellipse.start1());
        check(ellipse.start2());
        check(ellipse.end1());
        check(ellipse.end2());

        checkSwitchList(ellipse.switchList());
        popPath();
    }
}
