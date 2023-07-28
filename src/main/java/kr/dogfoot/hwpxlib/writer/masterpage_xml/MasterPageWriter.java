package kr.dogfoot.hwpxlib.writer.masterpage_xml;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.commonstrings.Namespaces;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.masterpage_xml.MasterPageXMLFile;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class MasterPageWriter extends ElementWriter {
    public MasterPageWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.MasterPage;
    }

    @Override
    public void write(HWPXObject object) {
        MasterPageXMLFile masterPageXMLFile = (MasterPageXMLFile) object;
        switchList(masterPageXMLFile.switchList());

        xsb()
                .clear()
                .openElement(ElementNames.masterPage)
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
                .namespace(Namespaces.config)
                .attribute(AttributeNames.id, masterPageXMLFile.id())
                .attribute(AttributeNames.type, masterPageXMLFile.type())
                .attribute(AttributeNames.pageNumber, masterPageXMLFile.pageNumber())
                .attribute(AttributeNames.pageDuplicate, masterPageXMLFile.pageDuplicate())
                .attribute(AttributeNames.pageFront, masterPageXMLFile.pageFront());

        if (masterPageXMLFile.subList() != null) {
            writeChild(ElementWriterSort.SubList, masterPageXMLFile.subList());
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_subList:
                writeChild(ElementWriterSort.SubList, child);
                break;
        }
    }
}
