package kr.dogfoot.hwpxlib.writer.content_hpf;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.context_hpf.Language;
import kr.dogfoot.hwpxlib.object.content.context_hpf.Meta;
import kr.dogfoot.hwpxlib.object.content.context_hpf.MetaData;
import kr.dogfoot.hwpxlib.object.content.context_hpf.Title;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class MetaDataWriter extends ElementWriter {
    public MetaDataWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.MetaData;
    }

    @Override
    public void write(HWPXObject object) {
        MetaData metaData = (MetaData) object;
        storeSwitchObject(metaData.switchObject());

        xsb()
                .openElement(ElementNames.opf_metadata)
                .elementWriter(this);

        if (metaData.title() != null) {
            hasOnlyTextElement(ElementNames.opf_title, metaData.title());
        }

        if (metaData.language() != null) {
            hasOnlyTextElement(ElementNames.opf_language, metaData.language());
        }

        for (Meta meta : metaData.metas()) {
            meta(meta);
        }

        xsb().closeElement();
        releaseMe();
    }

    private void meta(Meta meta) {
        xsb()
                .openElement(ElementNames.opf_meta)
                .attribute(AttributeNames.name, meta.name())
                .attribute(AttributeNames.content, meta.content())
                .text(meta.text())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case opf_title:
                hasOnlyTextElement(ElementNames.opf_title, (Title) child);
                break;
            case opf_language:
                hasOnlyTextElement(ElementNames.opf_language, (Language) child);
                break;
            case opf_meta:
                meta((Meta) child);
                break;
        }
    }
}
