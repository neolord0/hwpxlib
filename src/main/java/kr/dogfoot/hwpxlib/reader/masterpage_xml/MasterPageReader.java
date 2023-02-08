package kr.dogfoot.hwpxlib.reader.masterpage_xml;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.masterpage_xml.MasterPageXMLFile;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import org.xml.sax.Attributes;

public class MasterPageReader extends ElementReader {
    private MasterPageXMLFile masterPageXMLFile;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.MasterPage;
    }

    public void masterPageXMLFile(MasterPageXMLFile masterPageXMLFile) {
        this.masterPageXMLFile = masterPageXMLFile;
    }


    public void startElement(Attributes attrs) {
    }

    public void childElement(String name, Attributes attrs) {
    }

    public void text(String text) {

    }

    public void endElement() {
    }

    @Override
    public SwitchableObject switchableObject() {
        return masterPageXMLFile;
    }
}
