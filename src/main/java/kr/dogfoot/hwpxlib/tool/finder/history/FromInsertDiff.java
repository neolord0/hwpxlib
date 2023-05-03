package kr.dogfoot.hwpxlib.tool.finder.history;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.dochistory.DiffItem;
import kr.dogfoot.hwpxlib.object.dochistory.InsertDiff;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromInsertDiff extends FinderBase {
    public FromInsertDiff(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return null;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        InsertDiff insertDiff = (InsertDiff) from;
        pushPath(insertDiff);

        for (DiffItem childDiff : insertDiff.childDiffs()) {
            checkWithChildren(childDiff);
        }

        checkSwitchObject(insertDiff.switchObject());
        popPath();
    }
}
