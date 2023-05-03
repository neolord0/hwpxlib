package kr.dogfoot.hwpxlib.tool.finder.history;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.dochistory.HistoryEntry;
import kr.dogfoot.hwpxlib.object.dochistory.HistoryXMLFile;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromHistoryXMLFile extends FinderBase {

    public FromHistoryXMLFile(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hhs_history;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        HistoryXMLFile historyXMLFile = (HistoryXMLFile) from;
        pushPath(historyXMLFile);

        for (HistoryEntry historyEntry : historyXMLFile.entries()) {
            checkWithChildren(historyEntry);
        }

        checkSwitchObject(historyXMLFile.switchObject());
        popPath();
    }
}
