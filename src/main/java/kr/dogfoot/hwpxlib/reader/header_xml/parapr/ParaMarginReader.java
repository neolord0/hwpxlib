package kr.dogfoot.hwpxlib.reader.header_xml.parapr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.ValueAndUnit;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.ParaPr;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr.ParaMargin;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.util.ElementNames;
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
            case ElementNames.Intent:
                margin.createIntent();
                valueAndUnit(margin.intent(), name, attrs);
                break;
            case ElementNames.Left:
                margin.createLeft();
                valueAndUnit(margin.left(), name, attrs);
                break;
            case ElementNames.Right:
                margin.createRight();
                valueAndUnit(margin.right(), name, attrs);
                break;
            case ElementNames.Prev:
                margin.createPrev();
                valueAndUnit(margin.prev(), name, attrs);
                break;
            case ElementNames.Next:
                margin.createNext();
                valueAndUnit(margin.next(), name, attrs);
                break;
        }
    }

    @Override
    public void childElementInSwitch(HWPXObject child, String name, Attributes attrs) {
        if (child.objectType() == ObjectType.Intent) {
            valueAndUnit((ValueAndUnit) child, name, attrs);
        } else if (child.objectType() == ObjectType.Left) {
            valueAndUnit((ValueAndUnit) child, name, attrs);
        } else if (child.objectType() == ObjectType.Right) {
            valueAndUnit((ValueAndUnit) child, name, attrs);
        } else if (child.objectType() == ObjectType.Prev) {
            valueAndUnit((ValueAndUnit) child, name, attrs);
        } else if (child.objectType() == ObjectType.Next) {
            valueAndUnit((ValueAndUnit) child, name, attrs);
        }
    }

    private void valueAndUnit(ValueAndUnit valueAndUnit, String name, Attributes attrs) {
        ((ValueAndUnitReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ValueAndUnit))
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
