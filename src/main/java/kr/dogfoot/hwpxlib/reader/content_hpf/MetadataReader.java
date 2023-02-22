package kr.dogfoot.hwpxlib.reader.content_hpf;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.context_hpf.Language;
import kr.dogfoot.hwpxlib.object.content.context_hpf.Meta;
import kr.dogfoot.hwpxlib.object.content.context_hpf.MetaData;
import kr.dogfoot.hwpxlib.object.content.context_hpf.Title;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.common.baseobject.HasOnlyTextReader;
import kr.dogfoot.hwpxlib.object.names.ElementNames;
import org.xml.sax.Attributes;

public class MetadataReader extends ElementReader {
    private MetaData metaData;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Metadata;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch(name) {
            case ElementNames.opf_title:
                metaData.createTitle();
                title(metaData.title(), name, attrs);
                break;
            case ElementNames.opf_language:
                metaData.createLanguage();
                language(metaData.language(), name, attrs);
                break;
            case ElementNames.opf_meta:
                meta(metaData.addNewMeta(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch(name) {
            case ElementNames.opf_title:
                Title title = new Title();
                title(title, name, attrs);
                return title;
            case ElementNames.opf_language:
                Language language = new Language();
                language(language, name, attrs);
                return language;
            case ElementNames.opf_meta:
                Meta meta = new Meta();
                meta(meta, name, attrs);
                return meta;
        }
        return null;
    }

    private void title(Title title, String name, Attributes attrs) {
        ((HasOnlyTextReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.HasOnlyText))
                .hasOnlyText(title);

        xmlFileReader().startElement(name, attrs);
    }

    private void language(Language language, String name, Attributes attrs) {
        ((HasOnlyTextReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.HasOnlyText))
                .hasOnlyText(language);

        xmlFileReader().startElement(name, attrs);
    }

    private void meta(Meta meta, String name, Attributes attrs) {
        ((MetaReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Meta))
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
