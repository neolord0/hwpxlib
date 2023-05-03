package kr.dogfoot.hwpxlib.tool.finder.history;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.dochistory.FilePartDiff;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromFilePartDiff extends FinderBase {
    private ObjectType objectType;

    public FromFilePartDiff(FinderManager finderManager, Parameter parameter, ObjectType objectType) {
        super(finderManager, parameter);

        this.objectType = objectType;
    }

    @Override
    public ObjectType _objectType() {
        return objectType;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        FilePartDiff filePartDiff = (FilePartDiff) from;
        pushPath(filePartDiff);

        int count = filePartDiff.countOfChildDiff();
        for (int index = 0; index < count; index++) {
            checkWithChildren(filePartDiff.getChildDiff(index));
        }

        checkSwitchObject(filePartDiff.switchObject());
        popPath();
    }
}
