package kr.dogfoot.hwpxlib.tool.finder.manifest;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.metainf.FileEntry;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromFileEntry extends FinderBase {
    public FromFileEntry(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.odf_file_entry;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        FileEntry fileEntry = (FileEntry) from;
        pushPath(fileEntry);

        checkWithChildren(fileEntry.encryptionData());

        checkSwitchObject(fileEntry.switchObject());
        popPath();
    }
}
