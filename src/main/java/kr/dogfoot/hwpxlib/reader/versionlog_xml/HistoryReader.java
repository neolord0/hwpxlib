package kr.dogfoot.hwpxlib.reader.versionlog_xml;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.dochistory.HistoryEntry;
import kr.dogfoot.hwpxlib.object.dochistory.HistoryXMLFile;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.util.AttributeNames;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class HistoryReader extends ElementReader {
    private HistoryXMLFile historyXMLFile;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.History;
    }

    public void historyXMLFile(HistoryXMLFile historyXMLFile) {
        this.historyXMLFile = historyXMLFile;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.version:
                historyXMLFile.version(value);
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hhs_historyEntry:
                historyEntry(historyXMLFile.addNewEntry(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hhs_historyEntry:
                HistoryEntry historyEntry = new HistoryEntry();
                historyEntry(historyEntry, name, attrs);
                return historyEntry;
        }
        return null;
    }

    private void historyEntry(HistoryEntry historyEntry, String name, Attributes attrs) {
        ((HistoryEntryReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.HistoryEntry))
                .historyEntry(historyEntry);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return historyXMLFile;
    }
}
