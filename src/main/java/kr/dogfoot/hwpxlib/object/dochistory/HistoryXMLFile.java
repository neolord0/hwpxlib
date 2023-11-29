package kr.dogfoot.hwpxlib.object.dochistory;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;

import java.util.ArrayList;

public class HistoryXMLFile extends SwitchableObject {
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

    public int getEntryIndex(HistoryEntry entry) {
        int count = entryList.size();
        for (int index = 0; index < count; index++) {
            if (entryList.get(index) == entry) {
                return index;
            }
        }
        return -1;
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

    public HistoryXMLFile clone() {
        HistoryXMLFile cloned = new HistoryXMLFile();
        cloned.copyFrom(this);

        return cloned;
    }

    public void copyFrom(HistoryXMLFile from) {
        this.version = from.version;

        for (HistoryEntry historyEntry : from.entryList) {
            entryList.add(historyEntry.clone());
        }

        super.copyFrom(from);
    }
}
