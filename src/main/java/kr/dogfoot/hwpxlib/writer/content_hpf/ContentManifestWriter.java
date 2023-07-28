package kr.dogfoot.hwpxlib.writer.content_hpf;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.content.context_hpf.ManifestItem;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class ContentManifestWriter extends ElementWriter {
    public ContentManifestWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.ContentManifest;
    }

    @Override
    public void write(HWPXObject object) {
        ObjectList<ManifestItem> manifest = (ObjectList<ManifestItem>) object;
        switchList(manifest.switchList());

        xsb()
                .openElement(ElementNames.opf_manifest)
                .elementWriter(this);

        for (ManifestItem item : manifest.items()) {
            item(item);
        }

        xsb().closeElement();
        releaseMe();
    }

    private void item(ManifestItem item) {
        xsb()
                .openElement(ElementNames.opf_item)
                .attribute(AttributeNames.id, item.id())
                .attribute(AttributeNames.href, item.href())
                .attribute(AttributeNames.media_type, item.mediaType())
                .attribute(AttributeNames.fallback, item.fallback())
                .attribute(AttributeNames.fallback_style, item.fallbackStyle())
                .attribute(AttributeNames.required_namespace, item.requiredNamespace())
                .attribute(AttributeNames.required_modules, item.requiredModules())
                .attribute(AttributeNames.encryption, item.encryption())
                .attribute(AttributeNames.file_size, item.fileSize())
                .attribute(AttributeNames.isEmbeded, item.isEmbedded())
                .attribute(AttributeNames.sub_path, item.subPath())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case opf_item:
                item((ManifestItem) child);
                break;
        }
    }
}
