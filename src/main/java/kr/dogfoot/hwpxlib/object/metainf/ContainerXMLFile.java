package kr.dogfoot.hwpxlib.object.metainf;

import kr.dogfoot.hwpxlib.commonstirngs.MineTypes;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;

public class ContainerXMLFile extends SwitchableObject {
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

    public String packageXMLFilePath() {
        if ( rootFiles != null) {
            for (RootFile rootFile : rootFiles.items()) {
                if (MineTypes.HWPML_Package.equals(rootFile.mediaType())) {
                    return rootFile.fullPath();
                }
            }
        }
        return null;
    }
}
