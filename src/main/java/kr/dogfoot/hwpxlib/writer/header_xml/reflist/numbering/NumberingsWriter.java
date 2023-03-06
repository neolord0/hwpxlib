package kr.dogfoot.hwpxlib.writer.header_xml.reflist.numbering;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Numbering;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class NumberingsWriter extends ElementWriter {
    public NumberingsWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return null;
    }

    @Override
    public void write(HWPXObject object) {
        ObjectList<Numbering> numberings = (ObjectList<Numbering>) object;
        switchObject(numberings.switchObject());
        if (numberings.count() == 0) {
            return;
        }

        xsb()
                .openElement(ElementNames.hh_numberings)
                .elementWriter(this)
                .attribute(AttributeNames.itemCnt, numberings.count());

        for (Numbering numbering : numberings.items()) {
            writeChild(ElementWriterSort.Numbering, numbering);
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hh_numbering:
                writeChild(ElementWriterSort.Numbering, child);
                break;
        }
    }
}
