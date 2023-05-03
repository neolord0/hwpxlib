package kr.dogfoot.hwpxlib.tool.finder.header;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.CompatibleDocument;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromCompatibleDocument extends FinderBase {
    public FromCompatibleDocument(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_compatibleDocument;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        CompatibleDocument compatibleDocument = (CompatibleDocument) from;
        pushPath(compatibleDocument);

        checkWithChildren(compatibleDocument.layoutCompatibility());

        checkSwitchObject(compatibleDocument.switchObject());
        popPath();
    }
}
