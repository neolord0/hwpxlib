package kr.dogfoot.hwpxlib.reader.common.compatibility;

import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import org.xml.sax.Attributes;

public class SwitchReader extends ElementReader {
    private SwitchableObject switchableObject;

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
                .caseObjectAnd(switchableObject.switchObject().addNewCaseObject())
                .switchableObjectReaderSort(previousReader().sort());

        xmlFileReader().startElement(name, attrs);
    }


    private void defaultObject(String name, Attributes attrs) {
        switchableObject.switchObject().createDefaultObject();
        ((DefaultReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Default))
                .defaultObjectAnd(switchableObject.switchObject().defaultObject())
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
