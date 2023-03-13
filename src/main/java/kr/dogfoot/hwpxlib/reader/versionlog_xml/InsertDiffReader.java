package kr.dogfoot.hwpxlib.reader.versionlog_xml;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.dochistory.DeleteDiff;
import kr.dogfoot.hwpxlib.object.dochistory.InsertDiff;
import kr.dogfoot.hwpxlib.object.dochistory.UpdateDiff;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import org.xml.sax.Attributes;

public class InsertDiffReader extends ElementReader {
    private InsertDiff insertDiff;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.InsertDiff;
    }

    public void insertDiff(InsertDiff insertDiff) {
        this.insertDiff = insertDiff;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.path:
                insertDiff.path(value);
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hhs_insert:
                insert(insertDiff.addNewInsertDiff(), name, attrs);
                break;
            case ElementNames.hhs_update:
                update(insertDiff.addNewUpdateDiff(), name, attrs);
                break;
            case ElementNames.hhs_delete:
                delete(insertDiff.addNewDeleteDiff(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hhs_insert:
                InsertDiff insertDiff2 = new InsertDiff()
                        .filePartDiffTypeAnd(insertDiff.filePartDiffType());
                insert(insertDiff2, name, attrs);
                return insertDiff2;
            case ElementNames.hhs_update:
                UpdateDiff updateDiff = new UpdateDiff()
                        .filePartDiffTypeAnd(insertDiff.filePartDiffType());
                update(updateDiff, name, attrs);
                return updateDiff;
            case ElementNames.hhs_delete:
                DeleteDiff deleteDiff = new DeleteDiff()
                        .filePartDiffTypeAnd(insertDiff.filePartDiffType());
                delete(deleteDiff, name, attrs);
                return deleteDiff;
        }
        return null;
    }

    private void insert(InsertDiff insertDiff, String name, Attributes attrs) {
        ((InsertDiffReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.InsertDiff))
                .insertDiff(insertDiff);

        xmlFileReader().startElement(name, attrs);
    }

    private void update(UpdateDiff updateDiff, String name, Attributes attrs) {
        ((UpdateDiffReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.UpdateDiff))
                .updateDiff(updateDiff);

        xmlFileReader().startElement(name, attrs);
    }

    private void delete(DeleteDiff deleteDiff, String name, Attributes attrs) {
        ((DeleteDiffReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.DeleteDiff))
                .deleteDiff(deleteDiff);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return insertDiff;
    }
}
