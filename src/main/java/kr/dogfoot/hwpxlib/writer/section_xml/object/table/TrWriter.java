package kr.dogfoot.hwpxlib.writer.section_xml.object.table;

import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.Tc;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.Tr;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class TrWriter extends ElementWriter {
    public TrWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Tr;
    }

    @Override
    public void write(HWPXObject object) {
        Tr tr = (Tr) object;
        switchObject(tr.switchObject());

        xsb()
                .openElement(ElementNames.hp_tr)
                .elementWriter(this);

        for (Tc tc : tr.tcs()) {
            writeChild(ElementWriterSort.Tc, tc);
        }


        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_tc:
                writeChild(ElementWriterSort.Tc, child);
                break;
        }
    }
}
