package kr.dogfoot.hwpxlib.writer;

import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.content.context_hpf.*;
import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.writer.util.NamespaceSort;
import kr.dogfoot.hwpxlib.writer.util.XMLStringBuilder;

public class ContentHPFPWriter {
    public static void write(ContentHPFFile contentHPF, XMLStringBuilder xsb) {
        xsb
                .openElement(ElementNames.opf_package)
                .namespace(NamespaceSort.ha)
                .namespace(NamespaceSort.hp)
                .namespace(NamespaceSort.hp10)
                .namespace(NamespaceSort.hs)
                .namespace(NamespaceSort.hc)
                .namespace(NamespaceSort.hh)
                .namespace(NamespaceSort.hhs)
                .namespace(NamespaceSort.hm)
                .namespace(NamespaceSort.hpf)
                .namespace(NamespaceSort.dc)
                .namespace(NamespaceSort.opf)
                .namespace(NamespaceSort.ooxmlchart)
                .namespace(NamespaceSort.hwpunitchar)
                .namespace(NamespaceSort.epub)
                .namespace(NamespaceSort.config)
                .attribute(AttributeNames.version, contentHPF.version())
                .attribute(AttributeNames.unique_identifier, contentHPF.uniqueIdentifier())
                .attribute(AttributeNames.id, contentHPF.id());

        if (contentHPF.metaData() != null) {
            metadata(contentHPF.metaData(), xsb);
        }

        if (contentHPF.manifest() != null) {
            manifest(contentHPF.manifest(), xsb);
        }

        if (contentHPF.spine() != null) {
            spine(contentHPF.spine(), xsb);
        }

        xsb.closeElement();
    }

    private static void metadata(MetaData metaData, XMLStringBuilder xsb) {
        xsb
                .openElement(ElementNames.opf_metadata)
                .openElement(ElementNames.opf_title)
                .text(metaData.title().text())
                .closeElement()
                .openElement(ElementNames.opf_language)
                .text(metaData.language().text())
                .closeElement();
        for (Meta meta : metaData.metas()) {
            xsb
                    .openElement(ElementNames.opf_meta)
                    .attribute(AttributeNames.name, meta.name())
                    .attribute(AttributeNames.content, meta.content())
                    .text(meta.text())
                    .closeElement();
        }
        xsb.closeElement();
    }

    private static void manifest(ObjectList<ManifestItem> manifest, XMLStringBuilder xsb) {
        xsb.openElement(ElementNames.opf_manifest);
        for (ManifestItem item : manifest.items()) {
            xsb
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
                    .attribute(AttributeNames.isEmbedded, item.isEmbedded())
                    .attribute(AttributeNames.sub_path, item.subPath())
                    .closeElement();
        }
        xsb.closeElement();
    }

    private static void spine(ObjectList<SpineItemRef> spine, XMLStringBuilder xsb) {
        xsb.openElement(ElementNames.opf_spine);
        for (SpineItemRef itemRef : spine.items()) {
            xsb
                    .openElement(ElementNames.opf_itemref)
                    .attribute(AttributeNames.idref, itemRef.idref())
                    .attribute(AttributeNames.linear, itemRef.linear())
                    .closeElement();
        }
        xsb.closeElement();
    }

}
