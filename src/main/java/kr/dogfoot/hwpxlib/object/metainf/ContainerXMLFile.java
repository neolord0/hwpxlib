package kr.dogfoot.hwpxlib.object.metainf;

import kr.dogfoot.hwpxlib.commonstrings.MineTypes;
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
        if (rootFiles == null) return null;

        for (RootFile rootFile : rootFiles.items()) {
            if (MineTypes.HWPML_Package.equals(rootFile.mediaType())) {
                return rootFile.fullPath();
            }
        }
        return null;
    }

    @Override
    public ContainerXMLFile clone() {
        ContainerXMLFile cloned = new ContainerXMLFile();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(ContainerXMLFile from) {
        if (from.rootFiles != null) {
            createRootFiles();
            for (RootFile rootFile : from.rootFiles.items()) {
                rootFiles.add(rootFile.clone());
            }
        } else {
            removeRootFiles();
        }

        super.copyFrom(from);
    }
}
