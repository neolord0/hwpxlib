package kr.dogfoot.hwpxlib.reader.versionlog_xml;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.dochistory.DeleteDiff;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.util.AttributeNames;
import org.xml.sax.Attributes;

public class DeleteDiffReader extends ElementReader {
    private DeleteDiff deleteDiff;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.DeleteDiff;
    }

    public void deleteDiff(DeleteDiff deleteDiff) {
        this.deleteDiff = deleteDiff;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.path:
                deleteDiff.path(value);
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        deleteDiff.deletedObject(AllElementReader.read(deleteDiff.filePartDiffType(), name, attrs, xmlFileReader()));
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        return AllElementReader.read(deleteDiff.filePartDiffType(), name, attrs, xmlFileReader());
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}