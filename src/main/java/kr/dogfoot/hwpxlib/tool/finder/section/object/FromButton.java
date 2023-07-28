package kr.dogfoot.hwpxlib.tool.finder.section.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject.ButtonCore;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;
import kr.dogfoot.hwpxlib.tool.finder.section.object.comm.FromFormObject;

public class FromButton extends FromFormObject {
    private ObjectType objectType;

    public FromButton(FinderManager finderManager, Parameter parameter, ObjectType objectType) {
        super(finderManager, parameter);
        this.objectType = objectType;
    }

    @Override
    public ObjectType _objectType() {
        return objectType;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        ButtonCore button = (ButtonCore) from;
        pushPath(button);

        checkFromFormObject(button);

        checkSwitchList(button.switchList());
        popPath();
    }
}
