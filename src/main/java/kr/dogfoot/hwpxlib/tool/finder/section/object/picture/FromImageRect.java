package kr.dogfoot.hwpxlib.tool.finder.section.object.picture;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.ImageRect;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromImageRect extends FinderBase {
    public FromImageRect(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_imgRect;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        ImageRect imageRect = (ImageRect) from;
        pushPath(imageRect);

        check(imageRect.pt0());
        check(imageRect.pt1());
        check(imageRect.pt2());
        check(imageRect.pt3());

        checkSwitchList(imageRect.switchList());
        popPath();
    }
}
