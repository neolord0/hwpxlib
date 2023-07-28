package kr.dogfoot.hwpxlib.reader.common.compatibility;

import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.compatibility.Switch;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import org.xml.sax.Attributes;

public class SwitchReader extends ElementReader {
    private Switch switchObject;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Switch;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        if (ElementNames.hp_case.equals(name)) {
            caseObject(name, attrs);
        } else if (ElementNames.hp_default.equals(name)) {
            defaultObject(name, attrs);
        }
    }

    private void caseObject(String name, Attributes attrs) {
        ((CaseReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Case))
                .caseObjectAnd(switchObject.addNewCaseObject())
                .switchableObjectReaderSort(previousReader().sort());

        xmlFileReader().startElement(name, attrs);
    }


    private void defaultObject(String name, Attributes attrs) {
        switchObject.createDefaultObject();
        ((DefaultReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Default))
                .defaultObjectAnd(switchObject.defaultObject())
                .switchableObjectReaderSort(previousReader().sort());

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }


    public void switchObject(Switch switchObject) {
        this.switchObject = switchObject;
    }
}
