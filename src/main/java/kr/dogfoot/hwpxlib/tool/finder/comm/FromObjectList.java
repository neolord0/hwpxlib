package kr.dogfoot.hwpxlib.tool.finder.comm;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;

public class FromObjectList extends FinderBase {
    private ObjectType objectType;
    public FromObjectList(FinderManager finderManager, Parameter parameter, ObjectType objectType) {
        super(finderManager, parameter);

        this.objectType = objectType;
    }

    @Override
    public ObjectType _objectType() {
        return objectType;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        ObjectList<HWPXObject> objectList = (ObjectList<HWPXObject>) from;
        pushPath(objectList);

        for (HWPXObject child : objectList.items()) {
            if (child instanceof SwitchableObject) {
                checkWithChildren(child);
            } else {
                check(child);
            }
        }

        checkSwitchList(objectList.switchList());
        popPath();
    }
}
