package kr.dogfoot.hwpxlib.tool.finder.section.ctrl;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.AutoNumNewNumCore;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromAutoNumNewNum extends FinderBase {
    private ObjectType objectType;

    public FromAutoNumNewNum(FinderManager finderManager, Parameter parameter, ObjectType objectType) {
        super(finderManager, parameter);
        this.objectType = objectType;
    }

    @Override
    public ObjectType _objectType() {
        return objectType;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        AutoNumNewNumCore autoNumNewNumCore = (AutoNumNewNumCore) from;
        pushPath(autoNumNewNumCore);

        check(autoNumNewNumCore.autoNumFormat());

        checkSwitchList(autoNumNewNumCore.switchList());
        popPath();
    }
}
