package kr.dogfoot.hwpxlib.tool.finder;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.masterpage_xml.MasterPageXMLFile;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromMasterPageXMLFile extends FinderBase {
    public FromMasterPageXMLFile(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return null;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        MasterPageXMLFile masterPageXMLFile = (MasterPageXMLFile) from;
        pushPath(masterPageXMLFile);

        checkWithChildren(masterPageXMLFile.subList());

        checkSwitchObject(masterPageXMLFile.switchObject());
        popPath();
    }
}
