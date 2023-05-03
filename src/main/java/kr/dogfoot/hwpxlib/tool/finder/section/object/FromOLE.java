package kr.dogfoot.hwpxlib.tool.finder.section.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.OLE;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;
import kr.dogfoot.hwpxlib.tool.finder.section.object.comm.FromShapeComponent;

public class FromOLE extends FromShapeComponent {
    public FromOLE(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_ole;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        OLE ole = (OLE) from;
        pushPath(ole);

        checkFromShapeComponent(ole);

        check(ole.extent());
        check(ole.lineShape());

        checkSwitchObject(ole.switchObject());
        popPath();
    }
}
