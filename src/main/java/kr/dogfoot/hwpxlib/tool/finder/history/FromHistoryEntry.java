package kr.dogfoot.hwpxlib.tool.finder.history;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.dochistory.HistoryEntry;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromHistoryEntry extends FinderBase {
    public FromHistoryEntry(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hhs_historyEntry;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        HistoryEntry historyEntry = (HistoryEntry) from;
        pushPath(historyEntry);

        checkWithChildren(historyEntry.packageDiff());
        checkWithChildren(historyEntry.headDiff());
        checkWithChildren(historyEntry.bodyDiff());

        checkSwitchObject(historyEntry.switchObject());
        popPath();
    }
}
