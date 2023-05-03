package kr.dogfoot.hwpxlib.tool.finder.section.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Dutmal;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromDutmal extends FinderBase {
    public FromDutmal(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_dutmal;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Dutmal dutmal = (Dutmal) from;
        pushPath(dutmal);

        check(dutmal.mainText());
        check(dutmal.subText());

        checkSwitchObject(dutmal.switchObject());
        popPath();
    }
}
