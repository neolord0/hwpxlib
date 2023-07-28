package kr.dogfoot.hwpxlib.writer.common;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.*;
import kr.dogfoot.hwpxlib.object.common.compatibility.Case;
import kr.dogfoot.hwpxlib.object.common.compatibility.Switch;
import kr.dogfoot.hwpxlib.writer.util.XMLStringBuilder;

import java.util.ArrayList;

public abstract class ElementWriter {
    private ElementWriterManager elementWriterManager;
    private ArrayList<Switch> storedSwitchList;

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

    protected void switchList(ArrayList<Switch> switchList) {
        this.storedSwitchList = switchList;
    }

    public boolean hasStoredSwitchList() {
        return storedSwitchList != null;
    }

    public boolean makeSwitchObject(int childIndex) {
        Switch switchObject = findSwitchObject(childIndex + 1);
        if (switchObject == null) {
            return false;
        }

        xsb()
                .openElementNotCheckingSwitch(ElementNames.hp_switch);

        for (Case caseObject : switchObject.caseObjects()) {
            xsb()
                    .openElementNotCheckingSwitch(ElementNames.hp_case)
                    .attribute(AttributeNames.hp_required_namespace, caseObject.requiredNamespace());

            for (HWPXObject child : caseObject.children()) {
                childInSwitch(child);
            }

            xsb().closeElement();
        }

        if (switchObject.defaultObject() != null) {
            xsb().openElementNotCheckingSwitch(ElementNames.hp_default);

            for (HWPXObject child : switchObject.defaultObject().children()) {
                childInSwitch(child);
            }

            xsb().closeElement();
        }

        xsb().closeElement();
        return true;
    }

    private Switch findSwitchObject(int childIndex) {
        for (Switch switchObject : storedSwitchList) {
            if (switchObject.position() == childIndex) {
                return switchObject;
            }
        }
        return null;
    }

    public void removeSwitchList() {
        storedSwitchList = null;
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

