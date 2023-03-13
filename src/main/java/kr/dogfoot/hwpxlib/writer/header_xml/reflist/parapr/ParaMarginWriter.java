package kr.dogfoot.hwpxlib.writer.header_xml.reflist.parapr;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.ValueAndUnit;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr.ParaMargin;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class ParaMarginWriter extends ElementWriter {
    public ParaMarginWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.ParaMargin;
    }

    @Override
    public void write(HWPXObject object) {
        ParaMargin paraMargin = (ParaMargin) object;
        switchObject(paraMargin.switchObject());

        xsb()
                .openElement(ElementNames.hh_margin)
                .elementWriter(this);

        if (paraMargin.intent() != null) {
            valueAndUnit(ElementNames.hc_intent, paraMargin.intent());
        }

        if (paraMargin.left() != null) {
            valueAndUnit(ElementNames.hc_left, paraMargin.left());
        }

        if (paraMargin.right() != null) {
            valueAndUnit(ElementNames.hc_right, paraMargin.right());
        }

        if (paraMargin.prev() != null) {
            valueAndUnit(ElementNames.hc_prev, paraMargin.prev());
        }

        if (paraMargin.next() != null) {
            valueAndUnit(ElementNames.hc_next, paraMargin.next());
        }

        xsb().closeElement();
        releaseMe();
    }

    private void valueAndUnit(String elementName, ValueAndUnit valueAndUnit) {
        xsb()
                .openElement(elementName)
                .attribute(AttributeNames.value, valueAndUnit.value())
                .attribute(AttributeNames.unit, valueAndUnit.unit())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hc_intent:
                valueAndUnit(ElementNames.hc_intent, (ValueAndUnit) child);
                break;
            case hc_left:
                valueAndUnit(ElementNames.hc_left, (ValueAndUnit) child);
                break;
            case hc_right:
                valueAndUnit(ElementNames.hc_right, (ValueAndUnit) child);
                break;
            case hc_prev:
                valueAndUnit(ElementNames.hc_prev, (ValueAndUnit) child);
                break;
            case hc_next:
                valueAndUnit(ElementNames.hc_next, (ValueAndUnit) child);
                break;
        }
    }
}
