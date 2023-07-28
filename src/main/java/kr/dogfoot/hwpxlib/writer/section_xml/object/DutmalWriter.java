package kr.dogfoot.hwpxlib.writer.section_xml.object;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Dutmal;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class DutmalWriter extends ElementWriter {
    public DutmalWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Dutmal;
    }

    @Override
    public void write(HWPXObject object) {
        Dutmal dutmal = (Dutmal) object;
        switchList(dutmal.switchList());

        xsb()
                .openElement(ElementNames.hp_dutmal)
                .elementWriter(this)
                .attribute(AttributeNames.posType, dutmal.posType())
                .attribute(AttributeNames.szRatio, dutmal.szRatio())
                .attribute(AttributeNames.option, dutmal.option())
                .attribute(AttributeNames.styleIDRef, dutmal.styleIDRef())
                .attribute(AttributeNames.align, dutmal.align());

        if (dutmal.mainText() != null) {
            hasOnlyText(ElementNames.hp_mainText, dutmal.mainText());
        }

        if (dutmal.subText() != null) {
            hasOnlyText(ElementNames.hp_subText, dutmal.subText());
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_mainText:
                hasOnlyText(ElementNames.hp_mainText, (HasOnlyText) child);
                break;
            case hp_subText:
                hasOnlyText(ElementNames.hp_subText, (HasOnlyText) child);
                break;
        }
    }
}
