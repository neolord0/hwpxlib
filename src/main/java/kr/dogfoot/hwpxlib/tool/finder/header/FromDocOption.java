package kr.dogfoot.hwpxlib.tool.finder.header;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.DocOption;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromDocOption extends FinderBase {
    public FromDocOption(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_docOption;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        DocOption docOption = (DocOption) from;
        pushPath(docOption);

        check(docOption.linkinfo());

        checkSwitchObject(docOption.switchObject());
        popPath();
    }
}
