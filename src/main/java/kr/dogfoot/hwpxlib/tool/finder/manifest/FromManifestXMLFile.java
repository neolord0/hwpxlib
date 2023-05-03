package kr.dogfoot.hwpxlib.tool.finder.manifest;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.metainf.FileEntry;
import kr.dogfoot.hwpxlib.object.metainf.ManifestXMLFile;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromManifestXMLFile extends FinderBase {
    public FromManifestXMLFile(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.odf_manifest;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        ManifestXMLFile manifestXMLFile = (ManifestXMLFile) from;
        pushPath(manifestXMLFile);

        for (FileEntry fileEntry : manifestXMLFile.fileEntries()) {
            checkWithChildren(fileEntry);
        }

        checkSwitchObject(manifestXMLFile.switchObject());
        popPath();
    }
}
