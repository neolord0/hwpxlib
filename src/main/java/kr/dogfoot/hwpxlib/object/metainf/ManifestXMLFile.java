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

    public Iterable<FileEntry> fileEntries() {
        return fileEntryList;
    }

}
