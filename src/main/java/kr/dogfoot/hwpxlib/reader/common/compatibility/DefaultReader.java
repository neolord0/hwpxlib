package kr.dogfoot.hwpxlib.reader.common.compatibility;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.compatibility.Case;
import kr.dogfoot.hwpxlib.object.common.compatibility.Default;
import kr.dogfoot.hwpxlib.object.common.compatibility.Switch;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import org.xml.sax.Attributes;

public class DefaultReader extends ElementReader {
    private Default defaultObject;
    private SwitchableObject switchableObject;
    private ElementReaderSort switchableObjectReaderSort;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Default;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        HWPXObject child = switchableObject.createChildWithElementName(name);
        defaultObject.addChild(child);

        xmlFileReader().setCurrentEntryReaderInSwitch(switchableObjectReaderSort)
                .childElementInSwitch(child, name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public DefaultReader defaultObjectAnd(Default defaultObject) {
        this.defaultObject = defaultObject;
        return this;
    }

    public DefaultReader switchableObjectAnd(SwitchableObject switchableObject) {
        this.switchableObject = switchableObject;
        return this;
    }

    public void switchableObjectReaderSort(ElementReaderSort switchableObjectReaderSort) {
        this.switchableObjectReaderSort = switchableObjectReaderSort;
    }
}
