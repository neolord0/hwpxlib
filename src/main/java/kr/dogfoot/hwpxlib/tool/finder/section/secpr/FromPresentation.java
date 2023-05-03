package kr.dogfoot.hwpxlib.tool.finder.section.secpr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.Presentation;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromPresentation extends FinderBase {
    public FromPresentation(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_presentation;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Presentation presentation = (Presentation) from;
        pushPath(presentation);

        checkWithChildren(presentation.fillBrush());

        popPath();
    }
}
