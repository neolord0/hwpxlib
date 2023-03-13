package kr.dogfoot.hwpxlib.writer.section_xml.ctrl;

import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.Indexmark;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class IndexmarkWriter extends ElementWriter {
    public IndexmarkWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Indexmark;
    }

    @Override
    public void write(HWPXObject object) {
        Indexmark indexmark = (Indexmark) object;
        switchObject(indexmark.switchObject());

        xsb()
                .openElement(ElementNames.hp_indexmark)
                .elementWriter(this);

        if (indexmark.firstKey() != null) {
            hasOnlyText(ElementNames.hp_firstKey, indexmark.firstKey());
        }

        if (indexmark.secondKey() != null) {
            hasOnlyText(ElementNames.hp_secondKey, indexmark.secondKey());
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_firstKey:
                hasOnlyText(ElementNames.hp_firstKey, (HasOnlyText) child);
                break;
            case hp_secondKey:
                hasOnlyText(ElementNames.hp_secondKey, (HasOnlyText) child);
                break;
        }
    }
}
