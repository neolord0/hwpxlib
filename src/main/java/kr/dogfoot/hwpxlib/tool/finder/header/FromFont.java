package kr.dogfoot.hwpxlib.tool.finder.header;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.fontface.Font;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromFont extends FinderBase {
    public FromFont(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_font;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Font font = (Font) from;
        pushPath(font);

        check(font.substFont());
        check(font.typeInfo());

        checkSwitchObject(font.switchObject());
        popPath();
    }
}
