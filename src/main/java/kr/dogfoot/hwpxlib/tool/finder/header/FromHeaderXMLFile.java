package kr.dogfoot.hwpxlib.tool.finder.header;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.HeaderXMLFile;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromHeaderXMLFile extends FinderBase {
    public FromHeaderXMLFile(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_head;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        HeaderXMLFile headerXMLFile = (HeaderXMLFile) from;
        pushPath(headerXMLFile);

        checkWithChildren(headerXMLFile.refList());
        checkWithChildren(headerXMLFile.forbiddenWordList());
        checkWithChildren(headerXMLFile.compatibleDocument());
        checkWithChildren(headerXMLFile.docOption());
        check(headerXMLFile.trackChangeConfig());

        checkSwitchList(headerXMLFile.switchList());
        popPath();
    }
}
