package kr.dogfoot.hwpxlib.reader.common;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.*;
import kr.dogfoot.hwpxlib.reader.common.baseobject.*;
import org.xml.sax.Attributes;

public abstract class ElementReader {
    private XMLFileReader xmlFileReader;
    private ElementReader previousReader;
    private boolean started;
    private boolean switchableObjectReader;
    private int childIndex;

    protected ElementReader() {
    }

    public abstract ElementReaderSort sort();

    public abstract SwitchableObject switchableObject();

    public void startElement(Attributes attrs) {
        childIndex = 0;
        int count = attrs.getLength();
        for (int index = 0; index < count; index++) {
            setAttribute(attrs.getLocalName(index), attrs.getValue(index));
        }
    }

    protected void setAttribute(String localName, String value) {
    }

    public void childElement(String name, Attributes attrs) {
    }

    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        return null;
    }


    public void text(String text) {
    }

    public void endElement() {
    }

    public XMLFileReader xmlFileReader() {
        return xmlFileReader;
    }

    public ElementReader xmlFileReaderAnd(XMLFileReader xmlFileReader) {
        this.xmlFileReader = xmlFileReader;
        return this;
    }

    public ElementReader previousReader() {
        return previousReader;
    }

    public ElementReader previousReaderAnd(ElementReader previousReader) {
        this.previousReader = previousReader;
        return this;
    }

    public boolean started() {
        return started;
    }

    public ElementReader startedAnd(boolean started) {
        this.started = started;
        return this;
    }

    public void started(boolean started) {
        this.started = started;
    }

    public boolean switchableObjectReader() {
        return switchableObjectReader;
    }

    public ElementReader switchableObjectReaderAnd(boolean switchableObjectReader) {
        this.switchableObjectReader = switchableObjectReader;
        return this;
    }

    public void increaseChildIndex() {
        childIndex++;
    }

    public int childIndex() {
        return childIndex;
    }

    protected void hasOnlyText(HasOnlyText hasOnlyText, String name, Attributes attrs) {
        ((HasOnlyTextReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.HasOnlyText))
                .hasOnlyText(hasOnlyText);

        xmlFileReader().startElement(name, attrs);
    }

    protected void leftRightTopBottom(LeftRightTopBottom leftRightTopBottom, String name, Attributes attrs) {
        ((LeftRightTopBottomReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.LeftRightTopBottom))
                .leftRightTopBottom(leftRightTopBottom);

        xmlFileReader().startElement(name, attrs);
    }

    protected void xAndY(XAndY xAndY, String name, Attributes attrs) {
        ((XAndYReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.XAndY))
                .xAndY(xAndY);

        xmlFileReader().startElement(name, attrs);
    }

    protected void point(Point pt, String name, Attributes attrs) {
        ((PointReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Point))
                .point(pt);

        xmlFileReader().startElement(name, attrs);
    }

    protected void xAndYFloat(XAndYFloat xAndYFloat, String name, Attributes attrs) {
        ((XAndYFloatReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.XAndYFloat))
                .xAndYFloat(xAndYFloat);

        xmlFileReader().startElement(name, attrs);
    }

    protected void widthAndHeight(WidthAndHeight widthAndHeight, String name, Attributes attrs) {
        ((WidthAndHeightReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.WidthAndHeight))
                .widthAndHeight(widthAndHeight);

        xmlFileReader().startElement(name, attrs);
    }
}
