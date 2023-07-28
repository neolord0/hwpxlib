package kr.dogfoot.hwpxlib.tool.finder.section.ctrl;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.FieldBegin;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromFieldBegin extends FinderBase {
    public FromFieldBegin(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_fieldBegin;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        FieldBegin fieldBegin = (FieldBegin) from;
        pushPath(fieldBegin);

        checkWithChildren(fieldBegin.parameters());
        checkWithChildren(fieldBegin.subList());

        checkSwitchList(fieldBegin.switchList());
        popPath();
    }
}
