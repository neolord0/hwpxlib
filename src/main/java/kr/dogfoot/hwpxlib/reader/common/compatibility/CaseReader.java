package kr.dogfoot.hwpxlib.reader.common.compatibility;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.compatibility.Case;
import kr.dogfoot.hwpxlib.reader.common.*;
import kr.dogfoot.hwpxlib.util.AttributeNames;
import org.xml.sax.Attributes;

public class CaseReader extends ElementReader {
    private Case caseObject;
    private SwitchableObject switchableObject;

    private ElementReaderSort switchableObjectReaderSort;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Case;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.hp_required_namespace:
                caseObject.requiredNamespace(value);
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        HWPXObject child = switchableObject.createChildWithElementName(name);
        caseObject.addChild(child);

        xmlFileReader().setCurrentEntryReaderInSwitch(switchableObjectReaderSort)
                .childElementInSwitch(child, name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public CaseReader caseObjectAnd(Case caseObject) {
        this.caseObject = caseObject;
        return this;
    }

    public CaseReader switchableObjectAnd(SwitchableObject switchableObject) {
        this.switchableObject = switchableObject;
        return this;
    }

    public void switchableObjectReaderSort(ElementReaderSort switchableObjectReaderSort) {
        this.switchableObjectReaderSort = switchableObjectReaderSort;
    }
}
