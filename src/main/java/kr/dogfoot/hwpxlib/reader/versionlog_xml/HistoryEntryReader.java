package kr.dogfoot.hwpxlib.reader.versionlog_xml;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.dochistory.FilePartDiff;
import kr.dogfoot.hwpxlib.object.dochistory.HistoryEntry;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import org.xml.sax.Attributes;

public class HistoryEntryReader extends ElementReader {
    private HistoryEntry historyEntry;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.HistoryEntry;
    }

    public void historyEntry(HistoryEntry historyEntry) {
        this.historyEntry = historyEntry;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.revisionNumber:
                historyEntry.revisionNumber(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.revisionDate:
                historyEntry.revisionDate(value);
                break;
            case AttributeNames.revisionAuthor:
                historyEntry.revisionAuthor(value);
                break;
            case AttributeNames.revisionDesc:
                historyEntry.revisionDesc(value);
                break;
            case AttributeNames.revisionLock:
                historyEntry.revisionLock(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.autoSave:
                historyEntry.autoSave(ValueConvertor.toBoolean(value));
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hhs_packageDiff:
                historyEntry.createPackageDiff();
                filePartDiff(historyEntry.packageDiff(), name, attrs);
                break;
            case ElementNames.hhs_headDiff:
                historyEntry.createHeadDiff();
                filePartDiff(historyEntry.headDiff(), name, attrs);
                break;
            case ElementNames.hhs_bodyDiff:
                historyEntry.createBodyDiff();
                filePartDiff(historyEntry.bodyDiff(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hhs_packageDiff:
                FilePartDiff packageDiff = new FilePartDiff(ObjectType.hhs_packageDiff);
                filePartDiff(packageDiff, name, attrs);
                return packageDiff;
            case ElementNames.hhs_headDiff:
                FilePartDiff headDiff = new FilePartDiff(ObjectType.hhs_headDiff);
                filePartDiff(headDiff, name, attrs);
                return headDiff;
            case ElementNames.hhs_bodyDiff:
                FilePartDiff bodyDiff = new FilePartDiff(ObjectType.hhs_bodyDiff);
                filePartDiff(bodyDiff, name, attrs);
                return bodyDiff;
        }

        return null;
    }

    private void filePartDiff(FilePartDiff filePartDiff, String name, Attributes attrs) {
        ((FilePartDiffReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.FilePartDiff))
                .filePartDiff(filePartDiff);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return historyEntry;
    }
}
