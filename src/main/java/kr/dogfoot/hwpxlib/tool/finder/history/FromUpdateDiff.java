package kr.dogfoot.hwpxlib.tool.finder.history;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.dochistory.DiffItem;
import kr.dogfoot.hwpxlib.object.dochistory.UpdateDiff;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromUpdateDiff extends FinderBase {
    public FromUpdateDiff(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hhs_update;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        UpdateDiff updateDiff = (UpdateDiff) from;
        pushPath(updateDiff);

        for (DiffItem childDiff : updateDiff.childDiffs()) {
            checkWithChildren(childDiff);
        }

        checkSwitchList(updateDiff.switchList());
        popPath();
    }
}
