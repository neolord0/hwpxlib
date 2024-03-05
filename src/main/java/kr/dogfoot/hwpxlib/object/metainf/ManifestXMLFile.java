package kr.dogfoot.hwpxlib.object.metainf;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;

import java.util.ArrayList;

public class ManifestXMLFile extends SwitchableObject {
    private final ArrayList<FileEntry> fileEntryList;

    public ManifestXMLFile() {
        fileEntryList = new ArrayList<FileEntry>();
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.odf_manifest;
    }

    public int countOfFileEntry() {
        return fileEntryList.size();
    }

    public FileEntry getFileEntry(int index) {
        return fileEntryList.get(index);
    }

    public int getFileEntryIndex(FileEntry fileEntry) {
        int count = fileEntryList.size();
        for (int index = 0; index < count; index++) {
            if (fileEntryList.get(index) == fileEntry) {
                return index;
            }
        }
        return -1;
    }

    public void addFileEntry(FileEntry fileEntry) {
        fileEntryList.add(fileEntry);
    }

    public FileEntry addNewFileEntry() {
        FileEntry fileEntry = new FileEntry();
        fileEntryList.add(fileEntry);
        return fileEntry;
    }

    public void insertFileEntry(FileEntry fileEntry, int position) {
        fileEntryList.add(position, fileEntry);
    }

    public void removeFileEntry(int position) {
        fileEntryList.remove(position);
    }

    public void removeFileEntry(FileEntry fileEntry) {
        fileEntryList.remove(fileEntry);
    }

    public Iterable<FileEntry> fileEntries() {
        return fileEntryList;
    }

    public ManifestXMLFile clone() {
        ManifestXMLFile cloned = new ManifestXMLFile();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(ManifestXMLFile from) {
        for (FileEntry fileEntry : from.fileEntryList) {
            fileEntryList.add(fileEntry.clone());
        }
        super.copyFrom(from);
    }
}

