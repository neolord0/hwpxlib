package kr.dogfoot.hwpxlib.writer.header_xml.reflist.charpr;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.CharPr;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class CharPropertiesWriter extends ElementWriter {
    public CharPropertiesWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.CharProperties;
    }

    @Override
    public void write(HWPXObject object) {
        ObjectList<CharPr> charProperties = (ObjectList<CharPr>) object;
        storeSwitchObject(charProperties.switchObject());

        if (charProperties.count() == 0) {
            return;
        }

        xsb()
                .openElement(ElementNames.hh_charProperties)
                .elementWriter(this)
                .attribute(AttributeNames.itemCnt, charProperties.count());

        for (CharPr charPr : charProperties.items()) {
            writeChild(ElementWriterSort.CharPr, charPr);
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hh_charPr:
                writeChild(ElementWriterSort.CharPr, child);
                break;
        }
    }

}
