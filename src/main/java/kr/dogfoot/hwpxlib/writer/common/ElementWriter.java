package kr.dogfoot.hwpxlib.writer.common;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.object.common.compatibility.Case;
import kr.dogfoot.hwpxlib.object.common.compatibility.Switch;
import kr.dogfoot.hwpxlib.writer.util.XMLStringBuilder;

public abstract class ElementWriter {
    private ElementWriterManager elementWriterManager;
    private Switch stroedSwitchObject;

    protected ElementWriter(ElementWriterManager elementWriterManager) {
        this.elementWriterManager = elementWriterManager;
    }

    public abstract ElementWriterSort sort();

    public abstract void write(HWPXObject object);

    public XMLStringBuilder xsb() {
        return elementWriterManager.xsb();
    }

    public void writeChild(ElementWriterSort sort, HWPXObject child) {
        elementWriterManager.get(sort).write(child);
    }

    protected void storeSwitchObject(Switch switchObject) {
        this.stroedSwitchObject = switchObject;
    }

    public boolean hasStoredSwitchObject() {
        return stroedSwitchObject != null;
    }

    public int storedSwitchObjectPosition() {
        return stroedSwitchObject.position();
    }

    public void makeSwitchObject() {
        xsb()
                .openElementNotCheckingSwitch(ElementNames.hp_switch);

        for (Case caseObject : stroedSwitchObject.caseObjects()) {
            xsb()
                    .openElementNotCheckingSwitch(ElementNames.hp_case)
                    .attribute(AttributeNames.hp_required_namespace, caseObject.requiredNamespace());

            for (HWPXObject child : caseObject.children()) {
                childInSwitch(child);
            }

            xsb().closeElement();
        }

        if (stroedSwitchObject.defaultObject() != null) {
            xsb().openElementNotCheckingSwitch(ElementNames.hp_default);

            for (HWPXObject child : stroedSwitchObject.defaultObject().children()) {
                childInSwitch(child);
            }

            xsb().closeElement();
        }

        xsb().closeElement();
    }

    public void removeSwitchObject() {
        stroedSwitchObject = null;
    }

    protected void childInSwitch(HWPXObject child) {
    }

    protected void hasOnlyTextElement(String elementName, HasOnlyText hasOnlyText) {
        xsb()
                .openElement(elementName)
                .text(hasOnlyText.text())
                .closeElement();
    }

    protected void noAttributeChildElement(String elementName) {
        xsb()
                .openElement(elementName)
                .closeElement();
    }

    protected void releaseMe() {
        elementWriterManager.release(this);
    }

}

