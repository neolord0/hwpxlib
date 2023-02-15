package kr.dogfoot.hwpxlib.object.metainf;

import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.XMLFile;

public class ContainerXMLFile extends XMLFile {
    private ObjectList<RootFile> rootFiles;

    public ContainerXMLFile() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.ocf_container;
    }

    public ObjectList<RootFile> rootFiles() {
        return rootFiles;
    }

    public void createRootFiles() {
        rootFiles = new ObjectList<RootFile>(ObjectType.ocf_rootfiles, RootFile.class);
    }

    public void removeRootFiles() {
        rootFiles = null;
    }

}
