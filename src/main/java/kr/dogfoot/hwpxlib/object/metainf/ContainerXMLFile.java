package kr.dogfoot.hwpxlib.object.metainf;

import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.XMLFile;

public class ContainerXMLFile extends XMLFile {
    private ObjectList<RootFile> rootFiles;

    public ContainerXMLFile() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Container_XMLFile;
    }

    public ObjectList<RootFile> rootFiles() {
        return rootFiles;
    }

    public void createRootFiles() {
        rootFiles = new ObjectList<RootFile>(ObjectType.RootFiles, RootFile.class);
    }

    public void removeRootFiles() {
        rootFiles = null;
    }

}
