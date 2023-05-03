package kr.dogfoot.hwpxlib.tool.finder.section.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.ConnectLine;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;
import kr.dogfoot.hwpxlib.tool.finder.section.object.comm.FromDrawingObject;

public class FromConnectLine extends FromDrawingObject {
    public FromConnectLine(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_connectLine;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        ConnectLine connectLine = (ConnectLine) from;
        pushPath(connectLine);

        checkFromDrawingObject(connectLine);

        check(connectLine.startPt());
        check(connectLine.endPt());

        checkSwitchObject(connectLine.switchObject());
        popPath();
    }
}
