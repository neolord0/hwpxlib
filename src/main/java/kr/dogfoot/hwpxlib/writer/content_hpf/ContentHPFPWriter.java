package kr.dogfoot.hwpxlib.writer.content_hpf;

import kr.dogfoot.hwpxlib.CommonString;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.content.context_hpf.*;
import kr.dogfoot.hwpxlib.object.names.AttributeNames;
import kr.dogfoot.hwpxlib.object.names.ElementNames;
import kr.dogfoot.hwpxlib.writer.util.XMLStringBuilder;

public class ContentHPFPWriter {
    public static void write(ContentHPFFile contentHPF, XMLStringBuilder xsb) {
        xsb
                .openElement(ElementNames.opf_package)
                .attribute(AttributeNames.xmlns_ha, CommonString.xmlns_ha)
                .attribute(AttributeNames.xmlns_hp, CommonString.xmlns_hp)
                .attribute(AttributeNames.xmlns_hp10, CommonString.xmlns_hp10)
                .attribute(AttributeNames.xmlns_hs, CommonString.xmlns_hs)
                .attribute(AttributeNames.xmlns_hc, CommonString.xmlns_hc)
                .attribute(AttributeNames.xmlns_hh, CommonString.xmlns_hh)
                .attribute(AttributeNames.xmlns_hhs, CommonString.xmlns_hhs)
                .attribute(AttributeNames.xmlns_hm, CommonString.xmlns_hm)
                .attribute(AttributeNames.xmlns_hpf, CommonString.xmlns_hpf)
                .attribute(AttributeNames.xmlns_dc, CommonString.xmlns_dc)
                .attribute(AttributeNames.xmlns_opf, CommonString.xmlns_opf)
                .attribute(AttributeNames.xmlns_ooxmlchart, CommonString.xmlns_ooxmlchart)
                .attribute(AttributeNames.xmlns_hwpunitchar, CommonString.xmlns_hwpunitchar)
                .attribute(AttributeNames.xmlns_epub, CommonString.xmlns_epub)
                .attribute(AttributeNames.xmlns_config, CommonString.xmlns_config)
                .attribute(AttributeNames.version, contentHPF.version())
                .attribute(AttributeNames.unique_identifier, contentHPF.uniqueIdentifier())
                .attribute(AttributeNames.id, contentHPF.id());
        metadata(contentHPF.metaData(), xsb);
        manifest(contentHPF.manifest(), xsb);
        spine(contentHPF.spine(), xsb);
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
