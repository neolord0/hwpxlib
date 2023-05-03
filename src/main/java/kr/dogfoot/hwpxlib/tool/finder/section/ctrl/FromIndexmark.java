package kr.dogfoot.hwpxlib.tool.finder.section.ctrl;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.Indexmark;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromIndexmark extends FinderBase {
    public FromIndexmark(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_indexmark;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Indexmark indexmark = (Indexmark) from;
        pushPath(indexmark);

        check(indexmark.firstKey());
        check(indexmark.secondKey());

        checkSwitchObject(indexmark.switchObject());
        popPath();
    }
}
