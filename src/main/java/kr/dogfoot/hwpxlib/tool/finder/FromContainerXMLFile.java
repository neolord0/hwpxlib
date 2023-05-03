package kr.dogfoot.hwpxlib.tool.finder;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.metainf.ContainerXMLFile;
import kr.dogfoot.hwpxlib.object.metainf.RootFile;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromContainerXMLFile extends FinderBase {
    public FromContainerXMLFile(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.ocf_container;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        ContainerXMLFile containerXMLFile = (ContainerXMLFile) from;
        pushPath(containerXMLFile);

        for (RootFile rootFile : containerXMLFile.rootFiles().items()) {
            check(rootFile);
        }

        checkSwitchObject(containerXMLFile.switchObject());
        popPath();
    }
}
