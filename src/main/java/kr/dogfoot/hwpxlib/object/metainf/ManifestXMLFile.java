package kr.dogfoot.hwpxlib.object.metainf;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.XMLFile;

import java.util.ArrayList;

public class ManifestXMLFile extends XMLFile {
    private final ArrayList<FileEntry> fileEntryList;

    public ManifestXMLFile() {
        fileEntryList = new ArrayList<FileEntry>();
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Manifest_XMLFIle;
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
