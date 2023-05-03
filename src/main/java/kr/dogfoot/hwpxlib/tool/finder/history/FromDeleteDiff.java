package kr.dogfoot.hwpxlib.tool.finder.history;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.dochistory.DeleteDiff;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromDeleteDiff extends FinderBase {
    public FromDeleteDiff(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hhs_delete;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        DeleteDiff deleteDiff = (DeleteDiff) from;
        pushPath(deleteDiff);

        if (deleteDiff.deletedObject() instanceof SwitchableObject) {
            checkWithChildren(deleteDiff.deletedObject());
        } else {
            check(deleteDiff.deletedObject());
        }

        checkSwitchObject(deleteDiff.switchObject());
        popPath();
    }
}
