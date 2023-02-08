package kr.dogfoot.hwpxlib.reader.common;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import org.xml.sax.Attributes;

public abstract class ElementReader {
    private XMLFileReader xmlFileReader;
    private ElementReader previousReader;
    private boolean started;
    private boolean switchableObjectReader;

    protected ElementReader() {
    }

    public abstract ElementReaderSort sort();
    public abstract SwitchableObject switchableObject();

    public void startElement(Attributes attrs) {
        int count = attrs.getLength();
        for (int index = 0; index < count; index++) {
            setAttribute(attrs.getLocalName(index), attrs.getValue(index));
        }
    }

    protected void setAttribute(String localName, String value) {
    }

    public void childElement(String name, Attributes attrs) {
    }

    public void childElementInSwitch(HWPXObject child, String name, Attributes attrs) {
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
}
