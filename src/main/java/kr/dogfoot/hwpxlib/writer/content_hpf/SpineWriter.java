package kr.dogfoot.hwpxlib.writer.content_hpf;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.content.context_hpf.SpineItemRef;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class SpineWriter extends ElementWriter {
    public SpineWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Spine;
    }

    @Override
    public void write(HWPXObject object) {
        ObjectList<SpineItemRef> spine = (ObjectList<SpineItemRef>) object;
        switchList(spine.switchList());

        xsb()
                .openElement(ElementNames.opf_spine)
                .elementWriter(this);

        for (SpineItemRef itemRef : spine.items()) {
            itemRef(itemRef);
        }

        xsb().closeElement();
        releaseMe();
    }

    private void itemRef(SpineItemRef itemRef) {
        xsb()
                .openElement(ElementNames.opf_itemref)
                .attribute(AttributeNames.idref, itemRef.idref())
                .attribute(AttributeNames.linear, itemRef.linear())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case opf_itemref:
                itemRef((SpineItemRef) child);
                break;
        }
    }
}
