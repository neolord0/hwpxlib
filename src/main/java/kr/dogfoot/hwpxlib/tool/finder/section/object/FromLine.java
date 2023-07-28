package kr.dogfoot.hwpxlib.tool.finder.section.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Line;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;
import kr.dogfoot.hwpxlib.tool.finder.section.object.comm.FromDrawingObject;

public class FromLine extends FromDrawingObject {
    public FromLine(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_line;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Line line = (Line) from;
        pushPath(line);

        checkFromDrawingObject(line);

        check(line.startPt());
        check(line.endPt());

        checkSwitchList(line.switchList());
        popPath();
    }
}
