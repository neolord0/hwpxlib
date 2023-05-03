package kr.dogfoot.hwpxlib.tool.finder.section.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Edit;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;
import kr.dogfoot.hwpxlib.tool.finder.section.object.comm.FromFormObject;

public class FromEdit extends FromFormObject {
    public FromEdit(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_edit;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Edit edit = (Edit) from;
        pushPath(edit);

        checkFromFormObject(edit);

        check(edit.text());

        checkSwitchObject(edit.switchObject());
        popPath();
    }
}
