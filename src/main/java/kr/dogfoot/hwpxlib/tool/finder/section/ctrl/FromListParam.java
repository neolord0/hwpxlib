package kr.dogfoot.hwpxlib.tool.finder.section.ctrl;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.parameter.ListParam;
import kr.dogfoot.hwpxlib.object.common.parameter.Param;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromListParam extends FinderBase {
    public FromListParam(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_listParam;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        ListParam listParam = (ListParam) from;
        pushPath(listParam);

        for (Param param : listParam.params()) {
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

        checkSwitchObject(listParam.switchObject());
        popPath();
    }


}
