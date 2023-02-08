package kr.dogfoot.hwpxlib.reader.section_xml;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.SectionXMLFile;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Para;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;


public class SecReader extends ElementReader {
    private SectionXMLFile sectionXMLFile;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Sec;
    }

    public void sectionXMLFile(SectionXMLFile sectionXMLFile) {
        this.sectionXMLFile = sectionXMLFile;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.Para:
                para(sectionXMLFile.addNewPara(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.Para:
                Para para = new Para();
                para(para, name, attrs);
                return para;
        }
        return null;
    }

    private void para(Para para, String name, Attributes attrs) {
        ((ParaReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Para))
                .para(para);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return sectionXMLFile;
    }
}
