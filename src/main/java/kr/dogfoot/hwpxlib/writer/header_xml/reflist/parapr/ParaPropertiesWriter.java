package kr.dogfoot.hwpxlib.writer.header_xml.reflist.parapr;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.ParaPr;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class ParaPropertiesWriter extends ElementWriter {
    public ParaPropertiesWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return null;
    }

    @Override
    public void write(HWPXObject object) {
        ObjectList<ParaPr> paraProperties = (ObjectList<ParaPr>) object;
        switchObject(paraProperties.switchObject());
        if (paraProperties.count() == 0) {
            return;
        }

        xsb()
                .openElement(ElementNames.hh_paraProperties)
                .elementWriter(this)
                .attribute(AttributeNames.itemCnt, paraProperties.count());

        for (ParaPr paraPr : paraProperties.items()) {
            writeChild(ElementWriterSort.ParaPr, paraPr);
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hh_paraPr:
                writeChild(ElementWriterSort.ParaPr, child);
                break;
        }
    }
}
