package kr.dogfoot.hwpxlib.tool.finder.header;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Fontface;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Fontfaces;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromFontfaces extends FinderBase {
    public FromFontfaces(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_fontfaces;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Fontfaces fontfaces = (Fontfaces) from;
        pushPath(fontfaces);

        for (Fontface fontface : fontfaces.fontfaces()) {
            checkWithChildren(fontface);
        }

        checkSwitchObject(fontfaces.switchObject());
        popPath();
    }
}
