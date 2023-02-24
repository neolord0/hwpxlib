package kr.dogfoot.hwpxlib.reader.versionlog_xml;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.dochistory.DeleteDiff;
import kr.dogfoot.hwpxlib.object.dochistory.InsertDiff;
import kr.dogfoot.hwpxlib.object.dochistory.UpdateDiff;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import org.xml.sax.Attributes;

public class UpdateDiffReader extends ElementReader {
    private UpdateDiff updateDiff;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.UpdateDiff;
    }

    public void updateDiff(UpdateDiff updateDiff) {
        this.updateDiff = updateDiff;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.path:
                updateDiff.path(value);
                break;
            case AttributeNames.oldValue:
                updateDiff.oldValue(value);
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hhs_insert:
                insert(updateDiff.addNewInsertDiff(), name, attrs);
                break;
            case ElementNames.hhs_update:
                update(updateDiff.addNewUpdateDiff(), name, attrs);
                break;
            case ElementNames.hhs_delete:
                delete(updateDiff.addNewDeleteDiff(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hhs_insert:
                InsertDiff insertDiff = new InsertDiff()
                        .filePartDiffTypeAnd(updateDiff.filePartDiffType());
                insert(insertDiff, name, attrs);
                return insertDiff;
            case ElementNames.hhs_update:
                UpdateDiff updateDiff2 = new UpdateDiff()
                        .filePartDiffTypeAnd(updateDiff.filePartDiffType());
                update(updateDiff2, name, attrs);
                return updateDiff2;
            case ElementNames.hhs_delete:
                DeleteDiff deleteDiff = new DeleteDiff()
                        .filePartDiffTypeAnd(updateDiff.filePartDiffType());
                delete(deleteDiff, name, attrs);
                return deleteDiff;
        }
        return null;
    }

    private void insert(InsertDiff insertDiff, String name, Attributes attrs) {
        ((InsertDiffReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.InsertDiff))
                .insertDiff(insertDiff);

        xmlFileReader().startElement(name, attrs);
    }

    private void update(UpdateDiff updateDiff, String name, Attributes attrs) {
        ((UpdateDiffReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.UpdateDiff))
                .updateDiff(updateDiff);

        xmlFileReader().startElement(name, attrs);
    }

    private void delete(DeleteDiff deleteDiff, String name, Attributes attrs) {
        ((DeleteDiffReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.DeleteDiff))
                .deleteDiff(deleteDiff);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return updateDiff;
    }
}
