package kr.dogfoot.hwpxlib.tool.finder.comm;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.compatibility.Case;
import kr.dogfoot.hwpxlib.object.common.compatibility.Default;
import kr.dogfoot.hwpxlib.object.common.compatibility.Switch;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;

public abstract class FinderBase {
    private final FinderManager finderManager;
    private final Parameter parameter;

    public FinderBase(FinderManager finderManager, Parameter parameter) {
        this.finderManager = finderManager;
        this.parameter = parameter;
    }

    public abstract ObjectType _objectType();

    public abstract void find(HWPXObject from) throws Exception;

    public void pushPath(HWPXObject object) {
        parameter.pushPath(object);
    }

    public void popPath() {
        parameter.popPath();
    }

    protected void check(HWPXObject object) throws FoundFirstResultException {
        if (object == null) {
            return;
        }

        parameter.checkFilter(object);
    }

    protected void checkWithChildren(HWPXObject object) throws Exception {
        if (object == null) {
            return;
        }

        parameter.checkFilter(object);
        FinderBase finder = finderManager.get(object._objectType());
        if (finder == null) {
            throw new NoFinderException(object);
        }
        finder.find(object);

        finderManager.release(finder);
    }

    protected void checkSwitchObject(Switch switchObject) throws Exception {
        if (switchObject == null) {
            return;
        }

        pushPath(switchObject);

        for (Case caseObject : switchObject.caseObjects()) {
            caseObject(caseObject);
        }
        defaultObject(switchObject.defaultObject());

        popPath();
    }

    private void caseObject(Case caseObject) throws Exception {
        check(caseObject);
        pushPath(caseObject);

        for (HWPXObject child : caseObject.children()) {
            if (child instanceof SwitchableObject) {
                checkWithChildren(child);
            } else {
                check(child);
            }
        }

        popPath();
    }

    private void defaultObject(Default defaultObject) throws Exception {
        check(defaultObject);
        pushPath(defaultObject);

        for (HWPXObject child : defaultObject.children()) {
            if (child instanceof SwitchableObject) {
                checkWithChildren(child);
            } else {
                check(child);
            }
        }

        popPath();
    }
}

