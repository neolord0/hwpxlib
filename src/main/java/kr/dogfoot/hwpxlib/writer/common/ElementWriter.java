package kr.dogfoot.hwpxlib.writer.common;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.*;
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

    protected void switchObject(Switch switchObject) {
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

    protected void hasOnlyText(String elementName, HasOnlyText hasOnlyText) {
        xsb()
                .openElement(elementName)
                .text(hasOnlyText.text())
                .closeElement();
    }

    protected void noAttributeChild(String elementName) {
        xsb()
                .openElement(elementName)
                .closeElement();
    }

    protected void leftRightTopBottom(String elementName, LeftRightTopBottom leftRightTopBottom) {
        xsb()
                .openElement(elementName)
                .attribute(AttributeNames.left, leftRightTopBottom.left())
                .attribute(AttributeNames.right, leftRightTopBottom.right())
                .attribute(AttributeNames.top, leftRightTopBottom.top())
                .attribute(AttributeNames.bottom,leftRightTopBottom.bottom())
                .closeElement();
    }

    protected void widthAndHeight(String elementName, WidthAndHeight widthAndHeight) {
        xsb()
                .openElement(elementName)
                .attribute(AttributeNames.width, widthAndHeight.width())
                .attribute(AttributeNames.height, widthAndHeight.height())
                .closeElement();
    }

    protected void xAndY(String elementName, XAndY xAndY) {
        xsb()
                .openElement(elementName)
                .attribute(AttributeNames.x, xAndY.x())
                .attribute(AttributeNames.y, xAndY.y())
                .closeElement();
    }

    protected void xAndYFloat(String elementName, XAndYFloat xAndYFloat) {
        xsb()
                .openElement(elementName)
                .attribute(AttributeNames.x, xAndYFloat.x())
                .attribute(AttributeNames.y, xAndYFloat.y())
                .closeElement();
    }

    protected void point(String elementName, Point point) {
        xsb()
                .openElement(elementName)
                .attribute(AttributeNames.x, point.x())
                .attribute(AttributeNames.y, point.y())
                .closeElement();
    }

    protected void releaseMe() {
        elementWriterManager.release(this);
    }

}

