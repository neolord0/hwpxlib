package kr.dogfoot.hwpxlib.reader.header_xml.parapr;

import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.ValueAndUnit;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr.ParaMargin;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import org.xml.sax.Attributes;

public class ParaMarginReader extends ElementReader {
    private ParaMargin margin;
    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ParaMargin;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hc_intent:
                margin.createIntent();
                valueAndUnit(margin.intent(), name, attrs);
                break;
            case ElementNames.hc_left:
                margin.createLeft();
                valueAndUnit(margin.left(), name, attrs);
                break;
            case ElementNames.hc_right:
                margin.createRight();
                valueAndUnit(margin.right(), name, attrs);
                break;
            case ElementNames.hc_prev:
                margin.createPrev();
                valueAndUnit(margin.prev(), name, attrs);
                break;
            case ElementNames.hc_next:
                margin.createNext();
                valueAndUnit(margin.next(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hc_intent:
                ValueAndUnit intent = new ValueAndUnit(ObjectType.hc_intent);
                valueAndUnit(intent, name, attrs);
                return intent;
            case ElementNames.hc_left:
                ValueAndUnit leftMargin = new ValueAndUnit(ObjectType.hc_left);
                valueAndUnit(leftMargin, name, attrs);
                return leftMargin;
            case ElementNames.hc_right:
                ValueAndUnit rightMargin = new ValueAndUnit(ObjectType.hc_right);
                valueAndUnit(rightMargin, name, attrs);
                return rightMargin;
            case ElementNames.hc_prev:
                ValueAndUnit prevParaMargin = new ValueAndUnit(ObjectType.hc_prev);
                valueAndUnit(prevParaMargin, name, attrs);
                return prevParaMargin;
            case ElementNames.hc_next:
                ValueAndUnit nextParaMargin = new ValueAndUnit(ObjectType.hc_next);
                valueAndUnit(nextParaMargin, name, attrs);
                return nextParaMargin;
        }
        return null;
    }

    private void valueAndUnit(ValueAndUnit valueAndUnit, String name, Attributes attrs) {
        ((ValueAndUnitReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ValueAndUnit))
                .valueAndUnit(valueAndUnit);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return margin;
    }

    public void margin(ParaMargin margin) {
        this.margin = margin;
    }
}
