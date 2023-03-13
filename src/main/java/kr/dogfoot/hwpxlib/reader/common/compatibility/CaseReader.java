package kr.dogfoot.hwpxlib.reader.common.compatibility;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.compatibility.Case;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import org.xml.sax.Attributes;

public class CaseReader extends ElementReader {
    private Case caseObject;
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
        HWPXObject child = xmlFileReader().setCurrentElementReaderInSwitch(switchableObjectReaderSort)
                .childElementInSwitch(name, attrs);
        caseObject.addChild(child);
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public CaseReader caseObjectAnd(Case caseObject) {
        this.caseObject = caseObject;
        return this;
    }

    public void switchableObjectReaderSort(ElementReaderSort switchableObjectReaderSort) {
        this.switchableObjectReaderSort = switchableObjectReaderSort;
    }
}
