package kr.dogfoot.hwpxlib.tool.finder.section.ctrl;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.HeaderFooterCore;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromHeaderFooter extends FinderBase {
    private ObjectType objectType;

    public FromHeaderFooter(FinderManager finderManager, Parameter parameter, ObjectType objectType) {
        super(finderManager, parameter);
        this.objectType = objectType;
    }

    @Override
    public ObjectType _objectType() {
        return objectType;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        HeaderFooterCore headerFooterCore = (HeaderFooterCore) from;
        pushPath(headerFooterCore);

        checkWithChildren(headerFooterCore.subList());

        checkSwitchObject(headerFooterCore.switchObject());
        popPath();
    }
}
