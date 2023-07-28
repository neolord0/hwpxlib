package kr.dogfoot.hwpxlib.writer.content_hpf;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.commonstrings.Namespaces;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.context_hpf.ContentHPFFile;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class ContentWriter extends ElementWriter {
    public ContentWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Content;
    }

    @Override
    public void write(HWPXObject object) {
        ContentHPFFile contentHPF = (ContentHPFFile) object;
        switchList(contentHPF.switchList());

        xsb()
                .clear()
                .openElement(ElementNames.opf_package)
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
                .attribute(AttributeNames.version, contentHPF.version())
                .attribute(AttributeNames.unique_identifier, contentHPF.uniqueIdentifier())
                .attribute(AttributeNames.id, contentHPF.id());

        if (contentHPF.metaData() != null) {
            writeChild(ElementWriterSort.MetaData, contentHPF.metaData());
        }

        if (contentHPF.manifest() != null) {
            writeChild(ElementWriterSort.ContentManifest, contentHPF.manifest());
        }

        if (contentHPF.spine() != null) {
            writeChild(ElementWriterSort.Spine, contentHPF.spine());
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case opf_metadata:
                writeChild(ElementWriterSort.MetaData, child);
                break;
            case opf_manifest:
                writeChild(ElementWriterSort.ContentManifest, child);
                break;
            case opf_spine:
                writeChild(ElementWriterSort.Spine, child);
                break;
        }
    }
}
