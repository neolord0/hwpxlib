package kr.dogfoot.hwpxlib.reader.versionlog_xml;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
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
        // TODO : 차일드 객체로 올 수 있는 것들을 파악한 후에.. 다시..
        xmlFileReader().setCurrentEntryReader(ElementReaderSort.UnknownElement);
        xmlFileReader().startElement(name, attrs);

        deleteDiff.deletedObject(null);
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
