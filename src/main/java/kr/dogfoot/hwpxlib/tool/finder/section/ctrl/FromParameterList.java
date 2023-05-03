package kr.dogfoot.hwpxlib.tool.finder.section.ctrl;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.parameter.Param;
import kr.dogfoot.hwpxlib.object.common.parameter.ParameterListCore;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromParameterList extends FinderBase {
    private ObjectType objectType;

    public FromParameterList(FinderManager finderManager, Parameter parameter, ObjectType objectType) {
        super(finderManager, parameter);
        this.objectType = objectType;
    }

    @Override
    public ObjectType _objectType() {
        return objectType;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        ParameterListCore parameterListCore = (ParameterListCore) from;
        pushPath(parameterListCore);

        int count = parameterListCore.countOfParam();
        for (int index = 0; index < count; index++) {
            Param param = parameterListCore.getParam(index);
            switch (param._objectType()) {
                case hp_booleanParam:
                case hp_integerParam:
                case hp_floatParam:
                case hp_stringParam:
                    check(param);
                    break;
                case hp_listParam:
                    checkWithChildren(param);
                    break;
            }
        }

        checkSwitchObject(parameterListCore.switchObject());
        popPath();
    }
}
