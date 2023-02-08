package kr.dogfoot.hwpxlib.reader.common.compatibility;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.compatibility.Switch;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.manifest_xml.EncryptionDataReader;
import org.xml.sax.Attributes;

public class SwitchReader extends ElementReader {
    private SwitchableObject switchableObject;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Switch;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        if (ObjectType.Case.equalElementName(name)) {
            caseObject(name, attrs);
        } else if (ObjectType.Default.equalElementName(name)) {
            defaultObject(name, attrs);
        }
    }

    private void caseObject(String name, Attributes attrs) {
        ((CaseReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Case))
                .caseObjectAnd(switchableObject.switchObject().addNewCaseObject())
                .switchableObjectAnd(switchableObject)
                .switchableObjectReaderSort(previousReader().sort());

        xmlFileReader().startElement(name, attrs);
    }


    private void defaultObject(String name, Attributes attrs) {
        switchableObject.switchObject().createDefaultObject();
        ((DefaultReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Default))
                .defaultObjectAnd(switchableObject.switchObject().defaultObject())
                .switchableObjectAnd(switchableObject)
                .switchableObjectReaderSort(previousReader().sort());

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }


    public void switchableObject(SwitchableObject switchableObject) {
        this.switchableObject = switchableObject;
    }
}
