package kr.dogfoot.hwpxlib.object.etc;

import kr.dogfoot.hwpxlib.object.HWPXFile;

public class UnparsedXMLFile {
    public static UnparsedXMLFile[] ZeroArray = new UnparsedXMLFile[0];

    private String href;
    private String xml;

    public UnparsedXMLFile() {
    }

    public String href() {
        return href;
    }

    public void href(String href) {
        this.href = href;
    }

    public UnparsedXMLFile hrefAnd(String href) {
        this.href = href;
        return this;
    }

    public String xml() {
        return xml;
    }

    public void xml(String xml) {
        this.xml = xml;
    }

    public UnparsedXMLFile xmlAnd(String xml) {
        this.xml = xml;
        return this;
    }

    public UnparsedXMLFile clone() {
        UnparsedXMLFile cloned = new UnparsedXMLFile();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(UnparsedXMLFile from) {
        this.href = from.href;
        this.xml = from.xml;
    }
}
