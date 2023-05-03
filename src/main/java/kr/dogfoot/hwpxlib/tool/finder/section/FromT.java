package kr.dogfoot.hwpxlib.tool.finder.section;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.T;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.TItem;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromT extends FinderBase {
    public FromT(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_t;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        T t = (T) from;
        pushPath(t);
        if (t.isEmpty() == false && t.isOnlyText() == false) {
            for (TItem item : t.items()) {
                check(item);
            }
        }

        checkSwitchObject(t.switchObject());
        popPath();
    }
}
