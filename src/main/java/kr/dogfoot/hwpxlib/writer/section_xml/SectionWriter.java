package kr.dogfoot.hwpxlib.writer.section_xml;

import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.commonstrings.Namespaces;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.SectionXMLFile;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Para;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class SectionWriter extends ElementWriter {
    public SectionWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Section;
    }

    @Override
    public void write(HWPXObject object) {
        SectionXMLFile sectionXMLFile = (SectionXMLFile) object;
        switchList(sectionXMLFile.switchList());

        xsb()
                .clear()
                .openElement(ElementNames.hs_sec)
                .elementWriter(this)
                .namespace(Namespaces.ha)
                .namespace(Namespaces.hp)
                .namespace(Namespaces.hp10)
                .namespace(Namespaces.hs)
                .namespace(Namespaces.hc)
                .namespace(Namespaces.hh)
                .namespace(Namespaces.hhs)
                .namespace(Namespaces.hm)
                .namespace(Namespaces.hpf)
                .namespace(Namespaces.dc)
                .namespace(Namespaces.opf)
                .namespace(Namespaces.ooxmlchart)
                .namespace(Namespaces.hwpunitchar)
                .namespace(Namespaces.epub)
                .namespace(Namespaces.config);

        for (Para para : sectionXMLFile.paras()) {
            writeChild(ElementWriterSort.Para, para);
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_p:
                writeChild(ElementWriterSort.Para, child);
                break;
        }
    }
}
