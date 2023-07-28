package kr.dogfoot.hwpxlib.tool.finder.section.ctrl;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.FootNoteEndNoteCore;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromFootNoteEndNote extends FinderBase {
    private ObjectType objectType;

    public FromFootNoteEndNote(FinderManager finderManager, Parameter parameter, ObjectType objectType) {
        super(finderManager, parameter);
        this.objectType = objectType;
    }

    @Override
    public ObjectType _objectType() {
        return objectType;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        FootNoteEndNoteCore footNoteEndNoteCore = (FootNoteEndNoteCore) from;
        pushPath(footNoteEndNoteCore);

        checkWithChildren(footNoteEndNoteCore.subList());

        checkSwitchList(footNoteEndNoteCore.switchList());
        popPath();
    }
}
