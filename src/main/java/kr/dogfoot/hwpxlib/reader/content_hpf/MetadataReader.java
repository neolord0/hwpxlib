package kr.dogfoot.hwpxlib.reader.content_hpf;

import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.object.content.context_hpf.Meta;
import kr.dogfoot.hwpxlib.object.content.context_hpf.MetaData;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import org.xml.sax.Attributes;

public class MetadataReader extends ElementReader {
    private MetaData metaData;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Metadata;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.opf_title:
                metaData.createTitle();
                hasOnlyText(metaData.title(), name, attrs);
                break;
            case ElementNames.opf_language:
                metaData.createLanguage();
                hasOnlyText(metaData.language(), name, attrs);
                break;
            case ElementNames.opf_meta:
                meta(metaData.addNewMeta(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.opf_title:
                HasOnlyText title = new HasOnlyText(ObjectType.opf_title);
                hasOnlyText(title, name, attrs);
                return title;
            case ElementNames.opf_language:
                HasOnlyText language = new HasOnlyText(ObjectType.opf_language);
                hasOnlyText(language, name, attrs);
                return language;
            case ElementNames.opf_meta:
                Meta meta = new Meta();
                meta(meta, name, attrs);
                return meta;
        }
        return null;
    }

    private void meta(Meta meta, String name, Attributes attrs) {
        ((MetaReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Meta))
                .meta(meta);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return metaData;
    }

    public void metaData(MetaData metaData) {
        this.metaData = metaData;
    }
}
