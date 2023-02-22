package kr.dogfoot.hwpxlib.reader.content_hpf;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.context_hpf.Meta;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.object.names.AttributeNames;

public class MetaReader extends ElementReader {
    private Meta meta;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Meta;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.name:
                meta.name(value);
                break;
            case AttributeNames.content:
                meta.content(value);
                break;
        }
    }

    @Override
    public void text(String text) {
        meta.text(text);
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void meta(Meta meta) {
        this.meta = meta;
    }
}
