package kr.dogfoot.hwpxlib.tool.finder.header;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Fontface;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.fontface.Font;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromFontface extends FinderBase {
    public FromFontface(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_fontface;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Fontface fontface = (Fontface) from;
        pushPath(fontface);

        for (Font font : fontface.fonts()) {
            checkWithChildren(font);
        }

        checkSwitchObject(fontface.switchObject());
        popPath();
    }
}
