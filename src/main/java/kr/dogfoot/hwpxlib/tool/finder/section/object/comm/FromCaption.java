package kr.dogfoot.hwpxlib.tool.finder.section.object.comm;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.Caption;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromCaption extends FinderBase {

    public FromCaption(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_caption;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Caption caption = (Caption) from;
        pushPath(caption);

        checkWithChildren(caption.subList());

        checkSwitchObject(caption.switchObject());
        popPath();
    }
}
