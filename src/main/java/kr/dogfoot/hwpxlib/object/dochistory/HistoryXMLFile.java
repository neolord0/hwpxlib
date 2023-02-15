package kr.dogfoot.hwpxlib.object.dochistory;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.XMLFile;

import java.util.ArrayList;

public class HistoryXMLFile extends XMLFile {
    private String version;
    private final ArrayList<HistoryEntry> entryList;

    public HistoryXMLFile() {
        entryList = new ArrayList<HistoryEntry>();
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hhs_history;
    }

    public String version() {
        return version;
    }

    public void version(String version) {
        this.version = version;
    }

    public HistoryXMLFile versionAnd(String version) {
        this.version = version;
        return this;
    }

    public int countOfEntry() {
        return entryList.size();
    }

    public HistoryEntry getEntry(int index) {
        return entryList.get(index);
    }

    public void addEntry(HistoryEntry entry) {
        entryList.add(entry);
    }

    public HistoryEntry addNewEntry() {
        HistoryEntry entry = new HistoryEntry();
        entryList.add(entry);
        return entry;
    }

    public void insertEntry(HistoryEntry entry, int position) {
        entryList.add(position, entry);
    }

    public void removeEntry(int position) {
        entryList.remove(position);
    }

    public Iterable<HistoryEntry> entries() {
        return entryList;
    }

}
