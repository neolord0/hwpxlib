package kr.dogfoot.hwpxlib.tool.finder.section.ctrl;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.HiddenComment;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromHiddenComment extends FinderBase {
    public FromHiddenComment(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_hiddenComment;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        HiddenComment hiddenComment = (HiddenComment) from;
        pushPath(hiddenComment);

        checkWithChildren(hiddenComment.subList());

        checkSwitchObject(hiddenComment.switchObject());
        popPath();
    }
}
