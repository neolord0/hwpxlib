package kr.dogfoot.hwpxlib.reader.header_xml.parapr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.ValueAndUnit;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr.*;
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
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.Intent:
                Intent intent = new Intent();
                valueAndUnit(intent, name, attrs);
                return intent;
            case ElementNames.Left:
                LeftMargin leftMargin = new LeftMargin();
                valueAndUnit(leftMargin, name, attrs);
                return leftMargin;
            case ElementNames.Right:
                RightMargin rightMargin = new RightMargin();
                valueAndUnit(rightMargin, name, attrs);
                return rightMargin;
            case ElementNames.Prev:
                PrevParaMargin prevParaMargin = new PrevParaMargin();
                valueAndUnit(prevParaMargin, name, attrs);
                return prevParaMargin;
            case ElementNames.Next:
                NextParaMargin nextParaMargin = new NextParaMargin();
                valueAndUnit(nextParaMargin, name, attrs);
                return nextParaMargin;
        }
        return null;
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
