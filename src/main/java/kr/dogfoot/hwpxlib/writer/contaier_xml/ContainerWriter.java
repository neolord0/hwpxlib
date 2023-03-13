package kr.dogfoot.hwpxlib.writer.contaier_xml;

import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.commonstrings.Namespaces;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.metainf.ContainerXMLFile;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class ContainerWriter extends ElementWriter {
    public ContainerWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Container;
    }

    @Override
    public void write(HWPXObject object) {
        ContainerXMLFile containerXMLFile = (ContainerXMLFile) object;
        switchObject(containerXMLFile.switchObject());



        xsb()
                .clear()
                .openElement(ElementNames.ocf_container)
                .elementWriter(this)
                .namespace(Namespaces.ocf)
                .namespace(Namespaces.hpf);

        if (!containerXMLFile.rootFiles().empty()) {
            writeChild(ElementWriterSort.RootFiles, containerXMLFile.rootFiles());
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case ocf_rootfiles:
                writeChild(ElementWriterSort.RootFiles, child);
                break;
        }
    }
}

